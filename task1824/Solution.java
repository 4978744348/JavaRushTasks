package com.javarush.task.task18.task1824;

/* 
Файлы и исключения
*/

import java.io.*;

public class Solution {

    public static void main(String[] args) {
        BufferedReader reader = null;
        FileInputStream fileInputStream = null;
        try {
            while(true) {
                reader = new BufferedReader(new InputStreamReader(System.in));//C:\foto\file1.txt
                String  line = reader.readLine();
                try {
                    fileInputStream = new FileInputStream(line);
                }catch(FileNotFoundException e){
                    System.out.print(line);
                    break;
                }finally {
                    if(fileInputStream != null) {
                        fileInputStream.close();
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ignore) {
            }
        }
    }






}
