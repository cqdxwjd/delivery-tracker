package com.yunli.bigdata.dsep.service.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.yunli.bigdata.dsep.service.common.ExpiredTokenException;
import com.yunli.bigdata.dsep.service.common.InvalidSignatureException;
import com.yunli.bigdata.dsep.service.common.InvalidTokenStringException;
import com.yunli.bigdata.dsep.service.common.Token;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Date;

/**
 * @author wangpengfei
 * @date 2019-06-26
 */
public class TokenUtil {
  private static final Logger log = LoggerFactory.getLogger(TokenUtil.class);

  private static final ObjectMapper MAPPER = new ObjectMapper();

  private static final PublicKey PUBLIC_KEY;

  private static final String THE_WANG = "pengfei.wang@gmail.com";

  public static final String SIGN_ALGORITHM = "SHA256withRSA";

  static {
    try {
      CertificateFactory factory = CertificateFactory.getInstance("X.509");
      X509Certificate certificate = (X509Certificate) factory
          .generateCertificate(new ClassPathResource("/dsep.cer").getInputStream());
      PUBLIC_KEY = certificate.getPublicKey();
    } catch (Exception e) {
      log.error("init failed", e);
      throw new RuntimeException("init failed", e);
    }
  }

  public static Token parseToken(String token) throws InvalidTokenStringException {
    try {
      byte[] buf = Base64Utils.decodeFromUrlSafeString(token);
      String json = new String(buf, StandardCharsets.UTF_8);
      return MAPPER.readValue(json, Token.class);
    } catch (Exception e) {
      log.error("parseToken failed, token:" + token, e);
      throw new InvalidTokenStringException("parseToken failed");
    }
  }

  public static void validateToken(Token token) throws ExpiredTokenException, InvalidSignatureException {
    if (token.getExpiredDate().before(new Date())) {
      throw new ExpiredTokenException(String.format("Expired time of the token is '%tT'", token.getExpiredDate()));
    }

    String toBeSigned = getStringToBeSigned(token);
    try {
      Signature signature = Signature.getInstance(SIGN_ALGORITHM);
      signature.initVerify(PUBLIC_KEY);
      signature.update(toBeSigned.getBytes());
      if (!signature.verify(Base64Utils.decodeFromUrlSafeString(token.getSignature()))) {
        throw new InvalidSignatureException(
            String.format("Signature of token '%s' is invalid.", token.toString()));
      }
    } catch (NoSuchAlgorithmException e) {
      log.error("Signature.getInstance failed.", e);
      throw new RuntimeException("System internal error.");
    } catch (InvalidKeyException e) {
      log.error("Signature.initVerify failed.", e);
      throw new RuntimeException("System internal error.");
    } catch (SignatureException e) {
      log.error("Signature.update failed.", e);
      throw new RuntimeException("System internal error.");
    }
  }

  public static String getStringToBeSigned(Token token) {
    return String.format("%s-%s-%tT", token.getUser(), THE_WANG, token.getExpiredDate());
  }

  public static String tokenToString(Token token) {
    try {
      return Base64Utils.encodeToUrlSafeString(MAPPER.writeValueAsString(token).getBytes());
    } catch (JsonProcessingException e) {
      log.error("tokenToString failed.", e);
      return null;
    }
  }
}
