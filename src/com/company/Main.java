package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {

    /**
     * 1. ArrayList vs LinkedList
     * 2. LinkedList
     * 3. Performance ArrayList vs LinkedList
     *
     * 4. final
     *
     */
    public static void main(String[] args) {
        String [] array = new String[10];
        array[9] = "";
        array[2] = "a";
        array[0] = "asdasd";

    }

    private static void linkedList() {
        LinkedList<String> linkedList = new LinkedList<>();

        //      push(A) ->  [A, b, c, d] -> pop() -> returns d - все это называется Stack
        //      Queue (очередь) -> [A, b, c, d] - можно добавлять в начало и можно добавлять в конец

        //      linked list     [first, n, n, n, n, a, b, c, n, n, n, n, n, n, last]

        linkedList.add("a");
        linkedList.add("b");
//        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("b");
        linkedList.add("e");

        System.out.println("Initial LL");
        System.out.println(linkedList);

        linkedList.removeFirstOccurrence("b");
        System.out.println("After removing first occurrence of \"b\"");
        System.out.println(linkedList);

        //reverting the initial state
        linkedList.add(1, "b");

        System.out.println("After removing last occurrence of \"b\"");
        linkedList.removeLastOccurrence("b");
        System.out.println(linkedList);
    }

    private static void listMethods() {

        List<String> letters = new ArrayList<>();
        letters.add("a");
        letters.add("b");
        System.out.println(letters);
        //Output: a, b

        List<String> moreLetters = new ArrayList<>();
        moreLetters.add("z");
        moreLetters.add("x");

        letters.addAll(moreLetters);
        System.out.println(letters);
        ;
        //Output: a, b, z, x

        System.out.println(letters.size());
        //Output: 4

        System.out.println(letters.get(0));
        //Output: a

        /*
        remove(Object value) -> "a" -> returns boolean: deleted or not deleted
        problem: что если у нас две буквы а в листе??

        remove(int index) -> [0 - "a"] -> returns "a"
         */

        boolean isDeleted = letters.remove("a");
        System.out.println(isDeleted);
        //Output: true

        System.out.println(letters);
        //b, z, x

        letters.add("a");
        letters.add("a");

        System.out.println("Before removing letter 'a' twice");
        System.out.println(letters);
        letters.remove("a");
        System.out.println("After removing letter 'a' twice");
        System.out.println(letters);
        //Output: b, z, x, a

        //Set - присвоить значение конкретному индексу
        letters.set(0, "c");
        System.out.println(letters);
        //Output: c, z, x, a
        //0, 1, 2, 3

        letters.add(0, "b"); //Insert - Add by index
        //Output: b, c, z, x, a
        //        0, 1, 2, 3, 4

        letters.add(0, "a");
        //Output: a, b, c, z, x, a
        //        0, 1, 2, 3, 4, 5
        System.out.println(letters);

        System.out.println(".contains(\"a\")");
        System.out.println(letters.contains("a"));

        List<String> subList = letters.subList(0, 3);
        System.out.println("subList");
        System.out.println(subList);

        //subList = [a, b, c]
        //letters = [a, b, c, z, x, a]
        System.out.println("letters.containsAll(subList)");
        System.out.println(letters.containsAll(subList));
        //Output: true


        System.out.println("subList.containsAll(letters)");
        System.out.println(subList.containsAll(letters));
        //Output: false

        System.out.println("letters.indexOf(\"a\")");
        System.out.println(letters);
        System.out.println(letters.indexOf("a"));
        //Output: 0 [index]

        System.out.println("letters.lastIndexOf(\"a\")");
        System.out.println(letters);
        System.out.println(letters.lastIndexOf("a")); //начинай искать [по значению] с конца!



        /*

        */
    }

    private static void intro() {

        List<String> originalList = new ArrayList<>();


        List<String> russianAlphabet = new ArrayList<>();
        russianAlphabet.add("а");
        russianAlphabet.add("б");
        russianAlphabet.add("в");
        russianAlphabet.add("г");

        List<String> englishAlphabet = new ArrayList<>();
        englishAlphabet.add("a");
        englishAlphabet.add("b");
        englishAlphabet.add("c");
        englishAlphabet.add("d");

        /*for (String letter : russianAlphabet) {
            originalList.add(letter);
        }

        for (String letter : englishAlphabet) {
            originalList.add(letter);
        }*/
        originalList.addAll(russianAlphabet);
        originalList.addAll(englishAlphabet);
        System.out.println(originalList);

        List<String> arrayList = new ArrayList<>();
        arrayList.get(100);

        List<String> linkedList = new LinkedList<>();
        linkedList.get(100); //0, 1, 2, 3 .... 100
    }
}
