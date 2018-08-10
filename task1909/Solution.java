package com.javarush.task.task19.task1909;

/* 
Замена знаков
*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = consoleReader.readLine();//C:\foto\read.txt
        String fileTwo = consoleReader.readLine();//C:\foto\write.txt
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader((new FileReader(fileOne)));
        BufferedWriter fileWriter = new  BufferedWriter((new FileWriter(fileTwo)));

        StringBuilder stringBuilder = new StringBuilder();
        while(fileReader.ready()){
            int data = fileReader.read();
            stringBuilder.append((char)data);
        }
        String str = String.valueOf(stringBuilder);
         //System.out.println(str);

        String out  = str.replace(".","!");
          //System.out.println(out);

        fileWriter.write(out);

        fileReader.close();
        fileWriter.close();

    }
}
