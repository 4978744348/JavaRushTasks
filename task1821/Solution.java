package com.javarush.task.task18.task1821;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.zip.InflaterInputStream;

public class Solution {
    public static void main(String[] args )  {
        FileInputStream inputStream = null;
        TreeMap<Byte, Integer> map = new TreeMap<Byte, Integer>();
        try{
            inputStream = new FileInputStream(args[0]);
            while (inputStream.available() > 0) {
                byte[]buffer = new byte[inputStream.available()];
                inputStream.read(buffer);
               // System.out.println(Arrays.toString(buffer));
                for(int i = 0; i <buffer.length; i++){
                     if(map.containsKey(buffer[i])){
                         map.put(buffer[i], map.get(buffer[i])+1);
                         //System.out.println(map);
                     }else{
                         map.put(buffer[i],1);
                         //System.out.println(map);
                     }
                }
                for(Map.Entry pair : map.entrySet()){
                    System.out.println((char)((byte) pair.getKey()) + " " + pair.getValue());
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(inputStream != null) {
                    inputStream.close();
                }
            }catch (IOException ignore){}
        }
    }
}
