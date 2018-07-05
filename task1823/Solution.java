package com.javarush.task.task18.task1823;

import java.io.*;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/*
Нити и байты
*/

public class Solution {
    public static Map<String, Integer> resultMap = new HashMap<String, Integer>();

    public static void main(String[] args) {
        BufferedReader reader = null;
        try {
            while (true) {
                reader = new BufferedReader(new InputStreamReader(System.in));
                String line = reader.readLine();
                if (line.equals("exit")) {
                    break;
                }
                new ReadThread(line).start();

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

    public static class ReadThread extends Thread {

        private String fileName;
        private HashMap<Byte, Integer> symbols = new HashMap<>();

        public ReadThread(String fileName) {
            this.fileName = fileName;
        }

        @Override
        public void run() {
            FileInputStream fileRead = null;
            try {
                fileRead = new FileInputStream(this.fileName);//C:\foto\file1.txt
                while (fileRead.available() > 0) {
                    byte[] buffer = new byte[fileRead.available()];
                    fileRead.read(buffer);
                    fillHashMap(buffer);
                    findByte();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    fileRead.close();
                } catch (IOException ignore) {
                }
            }
        }

        private HashMap<Byte, Integer> fillHashMap(byte[] buffer) {
            for (byte bytes : buffer) {
                if (symbols.containsKey(bytes)) {
                    symbols.put(bytes, symbols.get(bytes) + 1);
                } else {
                    symbols.put(bytes, 1);
                }
            }
            return symbols;
        }

        private void findByte(){
            int msxByte = 0;
            byte findByte = 0;
            for(Map.Entry<Byte, Integer> pair : symbols.entrySet()){
                if(msxByte < pair.getValue()){
                    findByte = pair.getKey();
                }
            }
            synchronized (resultMap){
                resultMap.put(this.fileName,(int)findByte);
                System.out.println("resultMap: "+resultMap);
            }
        }
    }
}
