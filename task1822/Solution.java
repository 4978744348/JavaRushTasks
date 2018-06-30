package com.javarush.task.task18.task1822;

/* 
Поиск данных внутри файла
*/

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
    public static void main(String[] args) {//D:/JavaRushFiles/test.txt
        BufferedReader readLine = null;
        BufferedReader reader = null;
        try{
            readLine = new BufferedReader(new InputStreamReader(System.in));
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(readLine.readLine())));
            String id = args[0];
            while (reader.ready()){
                String line = reader.readLine();
               if(line.contains(id)){
                    System.out.print(line);
                }
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(readLine != null && reader != null) {
                    readLine.close();
                    reader.close();
                }
            }catch (IOException ignore){}
        }

    }
}
