package com.yunli.web.config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunli.web.dto.LoginDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;
import java.util.UUID;

@Slf4j
public class AKSK {
    /**
     * 通过 AKSK 生成密文
     *
     * @param userId     用户 ID
     * @param privateKey 私钥
     * @return
     */
    public static String getCipherText(String userId, String privateKey)
            throws InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException {
        // 根据用户 ID 和当前时间，拼接成待加密的内容
        String secretBody = userId + "#" + new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
        // 使用 RSA 的私钥对其进行加密
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKey));
        PrivateKey finalPrivateKey = factory.generatePrivate(privateKeySpec);
        Cipher encryptCipher = Cipher.getInstance("RSA");
        encryptCipher.init(Cipher.ENCRYPT_MODE, finalPrivateKey);
        byte[] finalData = encryptCipher.doFinal(secretBody.getBytes());
        String finalDataString = new String(Base64.getEncoder().encode(finalData));
        // 最终用于获取 token 的字符串
        return userId + "#" + finalDataString;
    }

    /**
     * 数据中台 2.x 生成密文
     * @author wangjingdong
     * @date 2021/6/21 15:14
     */
    public static String getCipherText(String privateKeyString)
            throws NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException, InvalidKeyException,
            SignatureException {
        KeyFactory factory = KeyFactory.getInstance("RSA");
        PKCS8EncodedKeySpec privateKeySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(privateKeyString));
        PrivateKey privateKey = factory.generatePrivate(privateKeySpec);
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(privateKey);
        String input = String.format("%s@%s", UUID.randomUUID().toString(), 3600 * 24);
        privateSignature.update(input.getBytes(StandardCharsets.UTF_8));
        return input + "#" + new String(Base64.getEncoder().encode(privateSignature.sign()), StandardCharsets.UTF_8);
    }

    public static String getToken(String address, String cipherText) {
        return getToken(new RestTemplate(), address, cipherText);
    }

    /**
     * 数据中台 2.x 获取token方法
     * @author wangjingdong
     * @date 2021/6/21 15:13
     */
    public static String getToken(RestTemplate restTemplate, String address, String keyId, String cipherText)
            throws IOException {
        String uri = address + "/x-authorization-service/authorizations/logins";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        LoginDto domain = new LoginDto(
                keyId,
                cipherText,
                "aksk"
        );
        HttpEntity<Object> request = new HttpEntity<>(domain, requestHeaders);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK || responseEntity.getStatusCode() == HttpStatus.CREATED) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = mapper.readTree(responseEntity.getBody());
            return rootNode.get("token").asText();
        } else {
            System.out.println("get token failed-------------------");
        }
        return null;
    }

    /**
     * 获取 token
     *
     * @param cipherText 密文
     * @return token
     */
    public static String getToken(RestTemplate restTemplate, String address, String
            cipherText) {
        String uri = address + "/x-authentication-service/v1/tokens";
        HttpHeaders requestHeaders = new HttpHeaders();
        requestHeaders.add("Accept", MediaType.APPLICATION_JSON.toString());
        requestHeaders.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<Object> request = new HttpEntity<>(cipherText, requestHeaders);
        log.info(cipherText);
        ResponseEntity<String> responseEntity = restTemplate.exchange(uri, HttpMethod.POST, request, String.class);
        if (responseEntity.getStatusCode() == HttpStatus.OK ||
                responseEntity.getStatusCode() == HttpStatus.CREATED) {
            ObjectMapper mapper = new ObjectMapper();
            JsonNode rootNode = null;
            try {
                rootNode = mapper.readTree(responseEntity.getBody());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            return rootNode.get("data").asText();
        } else {
            System.out.println("getToken failed ------------------- ");
        }
        return null;
    }
}
