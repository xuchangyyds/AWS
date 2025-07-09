package com.aws.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.nio.charset.StandardCharsets;
import java.security.*;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Base64;

@Component
public class JwtUtil {

    @Value("${jwt.private-key}")
    private String privateKeyString;

    @Value("${jwt.algorithm}")
    private String algorithm;

    @Value("${jwt.kid}")
    private String kid;

    @Value("${jwt.subject-id}")
    private String subject_id;

    @Value("${jwt.expiration-seconds}")
    private int expirationSeconds;

    public String createJwt() throws Exception {
        // 1. 解析私钥
        privateKeyString = privateKeyString
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .trim();
        byte[] privateKeyBytes = Base64.getDecoder().decode(privateKeyString);
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(privateKeyBytes);
        KeyFactory keyFactory = KeyFactory.getInstance("EdDSA");
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);

        // Header
        String headerJson = "{\"alg\": \"" + algorithm + "\", \"kid\": \"" + kid + "\"}";

        // 2. 构建Header和Payload
        long iat = ZonedDateTime.now(ZoneOffset.UTC).toEpochSecond() - 30;
        long exp = expirationSeconds + iat;
        String payloadJson = "{\"sub\": \"" + subject_id + "\", \"iat\": " + iat + ", \"exp\": " + exp + "}";

        // 3. Base64编码
        String headerEncoded = Base64.getUrlEncoder().encodeToString(headerJson.getBytes(StandardCharsets.UTF_8));
        String payloadEncoded = Base64.getUrlEncoder().encodeToString(payloadJson.getBytes(StandardCharsets.UTF_8));
        String data = headerEncoded + "." + payloadEncoded;

        // 4. 签名
        Signature signer = Signature.getInstance("EdDSA");
        signer.initSign(privateKey);
        signer.update(data.getBytes(StandardCharsets.UTF_8));
        byte[] signature = signer.sign();

        String signatureEncoded = Base64.getUrlEncoder().encodeToString(signature);

        return data + "." + signatureEncoded;
    }
}