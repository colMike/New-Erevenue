package com.revenue.revenueCollection.Utility;

//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by Fernflower decompiler)
//



import java.security.Key;
import java.security.MessageDigest;
import java.util.Arrays;
import java.util.Scanner;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.apache.commons.codec.binary.Base64;



public class AES {
    private static final String ALGORITHM = "AES";
    private static Scanner scanner;

    public AES() {
    }

    public static void main(String[] args) {
        print("1) For Encrypt, 2) For Decrypt>>");
        scanner = new Scanner(System.in);
        String sAction = scanner.nextLine();
        String decStr;
        if (sAction.toLowerCase().equalsIgnoreCase("1")) {
            print("Enter String To Encrypt");
            scanner = new Scanner(System.in);
            decStr = scanner.nextLine();

            try {
                print("Encrypted String Is >> " + encrypt(decStr));
            } catch (Exception var5) {
                var5.printStackTrace();
            }
        } else if (sAction.toLowerCase().equalsIgnoreCase("2")) {
            print("Enter String To decrypt");
            scanner = new Scanner(System.in);
            decStr = scanner.nextLine();

            try {
                print("Decrypted String in main>> " + decrypt(decStr));
            } catch (Exception var4) {
                var4.printStackTrace();
            }
        } else {
            print("Invalid Action Selected");
        }

    }
    public static String randomPassword() {
        //logger.info("Generating Password");

        String ALPHA_NUMERIC_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%&?{}*";
        StringBuilder builder = new StringBuilder();

        int count = 8;

        while (count-- != 0) {
            int character = (int) (Math.random() * ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();

    }

    public static void print(String value) {
        System.out.println(value);
    }

    public static String encrypt(String input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(1, generateKey());
            return encodeString(cipher.doFinal(input.getBytes()));
        } catch (Exception var2) {
            var2.printStackTrace();
            return "";
        }
    }

    public static String decrypt(String input) throws Exception {
        try {
            Cipher cipher = Cipher.getInstance("AES");
            cipher.init(2, generateKey());
            String value = new String(cipher.doFinal(decodeString(input)));
            return value;
        } catch (Exception var3) {
            var3.printStackTrace();
            return "";
        }
    }

    private static Key generateKey() throws Exception {
        try {
            byte[] keyval = "@compulynx#54321".getBytes();
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            keyval = digest.digest(keyval);
            keyval = Arrays.copyOf(keyval, 16);
            Key key = new SecretKeySpec(keyval, "AES");
            return key;
        } catch (Exception var3) {
            var3.printStackTrace();
            return null;
        }
    }

    public static String encodeString(byte[] input) {
        return Base64.encodeBase64URLSafeString(input);
    }

    public static byte[] decodeString(String output) {
        return Base64.decodeBase64(output);
    }
}

