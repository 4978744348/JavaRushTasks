package com.javarush.task.task18.task1817;

/* 
Пробелы
*/

import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;

public class Solution {
    public static void main(String[] args) {

        BufferedReader reader = null;
        try{
            File file = new File(args[0]);
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.ready()){
                String line = reader.readLine();
                double countGap = 0;
                double countLetters = 0;
                for(char element : line.toCharArray()){
                    if(element != ' '){
                        countLetters++;
                    }else{
                        countGap++;
                    }
                }
              //  System.out.print("countLet: "+countLetters+"\n");
              //  System.out.print("countGap: "+countGap+"\n");
                double p1 = countGap+countLetters;
              //  System.out.print("p1: "+p1+"\n");
                double ressult = countGap/p1*100;
               // System.out.print("res: "+ressult+"\n");
                double round = new BigDecimal(ressult).setScale(2,RoundingMode.UP).doubleValue();
                System.out.print(round);
            }
        }catch(IOException e){
            e.printStackTrace();
        }finally {
            try{
                if(reader != null) {
                    reader.close();
                }
            }catch (IOException ignore){}
        }

    }
}
