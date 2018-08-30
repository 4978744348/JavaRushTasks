package com.javarush.task.task19.task1920;

/* 
Самый богатый
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new FileReader(args[0]));//C:\\java\\read.txt
        TreeMap<String,Double> map = new TreeMap<>();

        String line;
        double findMax = 0.0;

        while((line = reader.readLine()) != null) {
            String[] symbols = line.split(" ");
            String name = symbols[0];
            double value = Double.parseDouble(symbols[1]);
            if(map.containsKey(name)){
                map.put(name, value + map.get(name));
            }else{
                map.put(name, value);
            }

            if(map.get(name) > findMax){
                findMax = map.get(name);
            }
        }
       reader.close();

        for(Map.Entry<String, Double> entry : map.entrySet()){
            if(entry.getValue() == findMax){
                System.out.println(entry.getKey());
            }
        }
    }
}
