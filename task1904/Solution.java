package com.javarush.task.task19.task1904;

import java.io.IOException;
import java.util.*;
import java.text.SimpleDateFormat;

/* 
И еще один адаптер
*/

public class Solution {

    public static void main(String[] args) {

    }

    public static class PersonScannerAdapter implements PersonScanner {

        private final Scanner fileScanner;

        public PersonScannerAdapter(Scanner fileScanner){
            this.fileScanner = fileScanner;
        }

        @Override
        public Person read() throws IOException {
            Person person = null;
            if(fileScanner.hasNext()){
                String str = fileScanner.nextLine();
                String[] data = str.split(" ");
                String lastName = data[0];
                String firstName = data[1];
                String middleName = data[2];
                Calendar calendar = new GregorianCalendar(Integer.parseInt(data[5]),
                        Integer.parseInt(data[4])-1,
                         Integer.parseInt(data[3]));
                person = new Person(firstName, middleName, lastName, calendar.getTime());
            }

            return  person;
        }

        @Override
        public void close() throws IOException {
            this.fileScanner.close();
        }
    }
}
