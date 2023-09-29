package com.julian.catalogservice.domain;

public class Test {
    public static void main(String[] args) {

        long count = "julian".chars().filter(ch -> ch == '1').count();
        System.out.println(count);
    }
}
