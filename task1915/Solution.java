package com.javarush.task.task19.task1915;

/* 
Дублируем текст
*/

import java.io.*;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) throws IOException {
        PrintStream print = System.out;
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream printStream = new PrintStream(outputStream);
        System.setOut(printStream);

        testString.printSomething();
        String result = outputStream.toString();
        System.setOut(print);

        BufferedReader consoleReader = new BufferedReader(new InputStreamReader(System.in));
        String readLine = consoleReader.readLine();//C:\java\write.txt
        consoleReader.close();

        FileOutputStream fileOutputStream = new FileOutputStream(readLine);
        byte[] bytes = result.getBytes();
        System.out.println(result);
        fileOutputStream.write(bytes);
        fileOutputStream.close();

    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}

