package com.javarush.task.task18.task1816;

/* 
Английские буквы
*/

import java.io.*;
import java.util.List;

public class Solution {
    public static void main(String[] args) {


        BufferedReader reader = null;
        try{
            File file = new File("D:/JavaRushFiles/test.txt");
            reader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            while (reader.ready()){
                String line = reader.readLine();
                //System.out.print(line+"\n");
                int countUpperCase = 0;
                int countLowCase = 0;
                for(char element : line.toCharArray()){
                  /*  for(char i = 'a';i<='z';i++) {
                       if(element == i){
                           countLowCase++;
                       }
                    }
                    for(char i = 'A';i<='Z';i++) {
                        if(element == i){
                            countUpperCase++;
                        }
                    }*/

                    if(element == 'l'){
                        countLowCase++;
                    }

                }
               // System.out.print(countLowCase+countUpperCase);
                System.out.print(countLowCase);
            }

        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if(reader != null) {
                    reader.close();
                }
            }catch (IOException e){}
        }

    }
}
