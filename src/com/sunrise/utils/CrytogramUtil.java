package com.sunrise.utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import sun.misc.BASE64Encoder;

public class CrytogramUtil
{
    public static String encrypt(String message, String algorithmName)
    {
        MessageDigest messageDigest = null;
        try {
            messageDigest = MessageDigest.getInstance(algorithmName);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        messageDigest.reset();
        byte[] bytes = message.getBytes();
        byte[] out = messageDigest.digest(bytes);
        BASE64Encoder enc = new BASE64Encoder();
        return enc.encode(out);
    }
}