package com.javarush.task.task18.task1826;

/*
Шифровка
*/

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws Exception {
        String switcher = args[0];//-e -d
        String fileName = args[1];//C:\java\encrypt.txt
        String fileOutputName = args[2];//C:\java\decrypt.txt

        KeyGenerator keyGenerator = KeyGenerator.getInstance("AES");
        keyGenerator.init(128);
        SecretKey key = keyGenerator.generateKey();
        // SecretKeySpec key = new SecretKeySpec("Bar12345BAr12345".getBytes(), "AES");

        byte[] dataFile = new Solution().readFile(fileName);//read file

        switch (switcher){
            case "-e" :
                byte[] encrypt = new Solution().encryptData(key,dataFile); // encrypt data file
                out(encrypt);
                new Solution().writeFile(encrypt, fileOutputName);
                break;
            case "-d" :
                byte[] decrypt = new Solution().decryptData(key,dataFile);//decrypt data file
                out(decrypt);
                new Solution().writeFile(decrypt, fileOutputName);
                break;

        }
    }

    public static void out(byte[] bytes){
        for(byte read : bytes) System.out.print((char)read);
        System.out.println();
    }

    public byte[] encryptData(SecretKey key, byte[] bytes) throws Exception{
        Cipher encrypt = Cipher.getInstance("AES");
        encrypt.init(Cipher.ENCRYPT_MODE, key);
        byte[] enBytes = encrypt.doFinal(bytes);
        return enBytes;
    }

    public byte[] decryptData(SecretKey key, byte[] bytes) throws  Exception{
        Cipher decrypt = Cipher.getInstance("AES");
        decrypt.init(Cipher.DECRYPT_MODE, key);
        decrypt.doFinal(bytes, bytes.length);
        return bytes;
    }

    public byte[] readFile(String fileName){
        FileInputStream fileInputStream = null;
        try{
            fileInputStream = new FileInputStream(fileName);
            byte[] buffer = new byte[fileInputStream.available()];
            fileInputStream.read(buffer);
            return buffer;
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileInputStream.close();
            }catch(IOException e){}
        }
        return null;
    }

    public void writeFile(byte[] buffer, String fileOutputName){
        FileOutputStream fileOutputStream = null;
        try{
            fileOutputStream  = new FileOutputStream(fileOutputName);
            fileOutputStream.write(buffer);
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            }catch(IOException e){}
        }
    }
}
