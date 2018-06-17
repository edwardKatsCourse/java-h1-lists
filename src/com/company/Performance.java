package com.company;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Performance {

    public static void main(String[] args) {

        insertToTheMiddle(new ArrayList<>());
    }

    private static void insertToTheMiddle(List<String> list) {
        for (int i = 0; i < 1_000_000; i++) {
            list.add("a");
            //AL должен изменить индексы начиная с 500,000 -> 500,001..1,000,000
            //LL должен "перебрать" индексы по 500,000 и изменить ссылки (кто за кем)
        }
        System.out.println("Starting to insert to the middle");
        long start = new Date().getTime();
        for (int i = 0; i < 10_000; i++) {
            int middleIndex = list.size() / 2;
            list.add(middleIndex, "a");
        }
        long end = new Date().getTime();

        System.out.println("Inserting 10K to the middle: " + (end - start));
        //Insert for ArrayList 10K times - 1744 milliseconds (1.7 seconds)
        //Insert for LinkedList 10K times - 19307 milliseconds (19 seconds)

    }

    private static void insertToTheBeginning(List<String> list) {
        //Изначальные данные
        for (int i = 0; i < 1_000_000; i++) {
            list.add("a");
        }
        System.out.println("Starting to insert");
        long start = new Date().getTime();
        for (int i = 0; i < 100_000; i++) {
            list.add(0, "a");
        }
        long end = new Date().getTime();
        System.out.println("Inserting 100K to the beginning: " + (end - start));
        //Insert for ArrayList 100K times - 39 000 milliseconds (39 SECONDS)
        //Insert for LinkedList 100K times - 6 milliseconds (0.006 seconds)

    }

    private static void testAdd() {
        List<String> list = new LinkedList<>();

        long start = new Date().getTime(); // .getTime() - время в милисекундах (1000 ms - 1 секунда)
        add(list);
        long end = new Date().getTime();
        System.out.println("Adding 10M elements: " + (end - start));
        //ArrayList = 0.2 seconds
        //LinkedList = 4.9 seconds
    }

    private static void add(List<String> list) {
        for (int i = 0; i < 10_000_000; i++) {
            list.add("a");
        }
    }


}
