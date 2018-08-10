package com.javarush.task.task19.task1908;
import java.io.*;
import java.math.BigInteger;
import java.nio.charset.Charset;
import java.util.*;
/* 
Выделяем числа
*/

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String fileOne = consoleReader.readLine();//C:\foto\read.txt
        String fileTwo = consoleReader.readLine();//C:\foto\write.txt
        consoleReader.close();

        BufferedReader fileReader = new BufferedReader((new FileReader(fileOne)));
        BufferedWriter fileWriter = new  BufferedWriter((new FileWriter(fileTwo)));

        StringBuilder stringBuilder = new StringBuilder();
        List<String> list = new ArrayList<>();

        while(fileReader.ready()){
           int data = fileReader.read();
           stringBuilder.append((char)data);
        }
           String str = String.valueOf(stringBuilder);
          //  System.out.println(str);

           String[] splitString  = str.split("\\s");
          //  System.out.println(Arrays.toString(splitString));
            for(String s : splitString){
                try {
                    Integer number = Integer.parseInt(s);
                    if (number instanceof Integer) {
                        list.add(number.toString());
                    }
                }catch (NumberFormatException e){
                    continue;
                }
            }
       // System.out.println(list);
        String out = String.join(" ",list);
        fileWriter.write(out);

        fileReader.close();
        fileWriter.close();


    }
}
