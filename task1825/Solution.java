package com.javarush.task.task18.task1825;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.Comparator;

/*
Собираем файл
*/

public class Solution {
    public static void main(String[] args) {  //C:\java\file1.txt.part1
        BufferedReader reader = null;
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        List<String> parts = new ArrayList<>();
        try{
            while(true) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                if(line.equals("end")) {
                    break;
                }else{
                    parts.add(line);
                }

            }

            Collections.sort(parts, new Comparator<String>() {
                @Override
                public int compare(String o1, String o2) {
                    return o1.toString().compareTo(o2.toString());
                }
            });

            String outputData = parts.get(0).split(".part")[0];
            fileOutputStream = new FileOutputStream(outputData);
            for(String fileNames : parts){
                fileInputStream = new FileInputStream(fileNames);
                byte[] buffer = new byte[fileInputStream.available()];
                fileInputStream.read(buffer);
                fileOutputStream.write(buffer);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null && fileInputStream != null && fileOutputStream != null) {
                    reader.close();
                    fileInputStream.close();
                    fileOutputStream.close();
                }
            }catch (IOException e){}
        }
    }
}