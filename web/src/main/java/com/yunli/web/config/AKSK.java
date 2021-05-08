package com.yunli.web.config;


import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.text.SimpleDateFormat;
import java.util.Base64;
import java.util.Date;

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

    public static String getToken(String address, String cipherText) {
        return getToken(new RestTemplate(), address, cipherText);
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
