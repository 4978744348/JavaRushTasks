package com.javarush.task.task19.task1914;

/* 
Решаем пример
*/

import java.awt.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;
import java.util.List;

public class Solution {

    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream print = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(print);

        String[] arrData = result.split(" ");
        //System.out.println("str: "+Arrays.toString(arrData));

        int[] numArr = new int[arrData.length];
        String[] signArr = new String[arrData.length];
        for(int i = 0; i < numArr.length; i++){

            if(arrData[i].equals("+") || arrData[i].equals("-") || arrData[i].equals("*")){
                signArr[i] = arrData[i];
            }

            Integer num = numArr[i];
            try {
                if (num instanceof Integer) {
                    numArr[i] = Integer.parseInt(arrData[i]);
                }
            }catch (NumberFormatException e){
                continue;
            }
        }

        //System.out.println("int: "+Arrays.toString(numArr));
        //System.out.println("sign: "+Arrays.toString(signArr));

        Integer[] tmpArr = Arrays.stream(numArr).boxed().toArray(Integer[]::new);
        List<Integer> listInt = new ArrayList<Integer>(Arrays.asList(tmpArr));
        listInt.removeAll(Arrays.asList(Integer.valueOf(0)));
        //System.out.println("editNum: "+listInt);

        List<String> listSign = new ArrayList<>();
       for(String s : signArr){
           if(s != null){
               listSign.add(s);
           }
       }
        //System.out.println("editSign: "+listSign);

       int a = listInt.get(0);
       int b = listInt.get(1);
       int c = 0;
       for(int i = 0; i < listSign.size(); i++) {
           switch (listSign.get(i)) {
               case "+": c = sum(a, b);
                   System.out.println(a+" + "+b+" = "+c);
                   break;
               case "-": c = min(a, b);
                   System.out.println(a+" - "+b+" = "+c);
                   break;
               case "*": c = mult(a, b);
                   System.out.println(a+" * "+b+" = "+c);
                   break;
           }
       }
    }

    public static int sum(int a, int b){
        return  a + b;
    }

    public static int min(int a, int b){
        return  a - b;
    }
    public static int mult(int a, int b){
        return  a * b;
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("3 + 6 = ");
        }
    }
}

