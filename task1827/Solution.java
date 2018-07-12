package com.javarush.task.task18.task1827;

/*
Прайсы
*/

import java.io.*;
import java.util.*;


public class Solution {
    public static void main(String[] args) throws Exception {//C:\java\CRUD.txt
        //-c productName price quantity
        if (args.length == 0) return;
        if (args[0].equals("-c")) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            String pathFile = reader.readLine();
            reader.close();

            int maxId = new Solution().getMaxIdFromReadFile(pathFile);
            String writeData = new Solution().add(maxId, args);

            BufferedWriter writeFile =  new BufferedWriter(new OutputStreamWriter(new FileOutputStream(pathFile, true)));
            writeFile.write(writeData);
            writeFile.newLine();
            writeFile.close();
        }
    }

    private int getMaxIdFromReadFile(String pathFile) throws IOException{
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile)));
        String dataFile = null;
        List<Integer>  listId = new ArrayList<>();
        while(readerFile.ready()) {
            dataFile = readerFile.readLine();
            listId.add(Integer.parseInt(dataFile.split(" ")[0]));
        }
        readerFile.close();
        Collections.sort(listId);
        return  Collections.max(listId);
    }

    private String add(int maxId, String[] args){
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0; i < args.length; i++){
            switch (i){
                case 0 : stringBuilder.append(String.format("%-8s",maxId+1));//id
                    break;
                case 1 : stringBuilder.append(String.format("%-30s",args[1]));//productName
                    break;
                case 2 : stringBuilder.append(String.format("%-8s",args[2]));//price
                    break;
                case 3 : stringBuilder.append(String.format("%-4s",args[3]));//quantity
                    break;
            }
        }
        return stringBuilder.toString();
    }
}
