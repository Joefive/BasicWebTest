package com.sunrise.utils;


public class PassWordUtils {
    public static void main(String[] args) {
        String md5 = CrytogramUtil.encrypt("123", "MD5");
        System.out.println(md5);
    }
}
