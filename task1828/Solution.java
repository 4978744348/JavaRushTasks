package com.javarush.task.task18.task1828;

/* 
Прайсы 2
*/

import java.io.*;
import java.util.ArrayList;
import java.util.*;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {
    public static void main(String[] args) throws Exception {//C:\java\CRUD.txt

        if (args.length == 0) return;//-u id productName price quantity      or      -d id
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String pathFile = reader.readLine();
        reader.close();
        List<String> products = new Solution().getProductsFromReadFile(pathFile);
        switch(args[0]) {
            case "-u" : {
             new Solution().update(products, args);
                break;
            }
            case "-d" : {
             new Solution().delete(products, args);
                break;
            }
        }

        PrintWriter writer = new PrintWriter(pathFile);
        for(String str : products){
            writer.println(str);
        }
        writer.close();
        }

    private List delete(List<String> list, String[] args){
        for(int i = 0; i < list.size(); i++) {
            String str = list.get(i).substring(0, 8);
            if (str.equals(String.format("%-8s",args[1]))) {
                list.remove(i).substring(0,50);
            }
        }
        return list;
    }

    private List update(List<String> products, String[] args){
        int idArg = Integer.parseInt(args[1]);
        String productName = args[2];
        String price = args[3];
        String quantity = args[4];
        Pattern pattern = Pattern.compile("([0-9]{1,8})");
        for(int i = 0; i < products.size(); i++){
            String str = products.get(i);
            Matcher matcher = pattern.matcher(str);
            if(matcher.lookingAt()){
                int  id = Integer.parseInt(str.substring(matcher.start(),matcher.end()));
                if(id == idArg){
                    products.set(i,String.format(Locale.ROOT,"%-8s%-30s%-8s%-4s", id, productName,price,quantity));
                    break;
                }
            }
        }

        return products;
    }

    private List getProductsFromReadFile(String pathFile) throws IOException{
        BufferedReader readerFile = new BufferedReader(new InputStreamReader(new FileInputStream(pathFile)));
        List<String> list = new ArrayList<>();
        while(readerFile.ready()) {
            list.add(readerFile.readLine());
        }
        readerFile.close();
        return  list;
    }
}
