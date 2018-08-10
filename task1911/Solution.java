package com.javarush.task.task19.task1911;

/* 
Ридер обертка
*/

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

public class Solution {
    public static TestString testString = new TestString();

    public static void main(String[] args) {

        PrintStream printStream = System.out;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        PrintStream stream = new PrintStream(byteArrayOutputStream);

        System.setOut(stream);
        testString.printSomething();
        String result = byteArrayOutputStream.toString();
        System.setOut(printStream);

        StringBuilder stringBuilder = new StringBuilder(result);
        String out = stringBuilder.toString().toUpperCase();
        System.out.print(out);
    }

    public static class TestString {
        public void printSomething() {
            System.out.println("it's a text for testing");
        }
    }
}
