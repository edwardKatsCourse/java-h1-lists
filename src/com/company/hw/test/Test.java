package com.company.hw.test;


import com.company.hw.model.MyLinkedListImpl;

public class Test {

    public static void main(String[] args) {

        MyLinkedListImpl<String> lli = new MyLinkedListImpl<>();

        lli.add("a");
        lli.add("b");
        lli.add("c");

        System.out.println(lli.toString());

//        lli.removeLast();
//        System.out.println(lli.toString());

        lli.remove("a");
        lli.removeLast();

        System.out.println(lli.toString());

    }

}
