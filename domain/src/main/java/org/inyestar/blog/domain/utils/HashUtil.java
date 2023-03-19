package org.inyestar.blog.domain.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import org.inyestar.blog.domain.exception.KeywordHashFailException;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class HashUtil {
    public static String hash(String source) {
        MessageDigest digest;
        try {
            digest = MessageDigest.getInstance("SHA-256");
        } catch (NoSuchAlgorithmException e) {
            throw new KeywordHashFailException(e.getMessage());
        }
        byte[] encodedhash = digest.digest(source.getBytes(StandardCharsets.UTF_8));
        return bytesToHex(encodedhash);
    }

    public static String bytesToHex(byte[] hash) {
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (int i = 0; i < hash.length; i++) {
            String hex = Integer.toHexString(0xff & hash[i]);
            if(hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }
        return hexString.toString();
    }
}
