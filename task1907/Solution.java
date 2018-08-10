package com.javarush.task.task19.task1907;

/* 
Считаем слово
*/

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {

        BufferedReader readerConsole = new BufferedReader(new InputStreamReader(System.in));
        String readDataFile = readerConsole.readLine();
        readerConsole.close();

        FileReader  fileReader = new FileReader(readDataFile);//C:\foto\read.txt
        Scanner scan = new Scanner(fileReader);
        String str = null;
        String[] s = null;
        List<String> list = new ArrayList<>();
        while(scan.hasNextLine()){
        str = scan.nextLine();
            //System.out.println(str);
            s = str.split("[qetyuipasfghjkzxcvbnmWQETYUIPASFGHJKZXCVBNM. ]");
            //System.out.println(Arrays.toString(s));
            for(int i = 0; i < s.length; i++){
                  if(s[i].equals("world")){
                      list.add(s[i]);
                  }
            }
       }
        fileReader.close();
       int count = list.size()-1;
        System.out.println(count);

    }
}
