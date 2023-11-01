package com.julian.catalogservice.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.TreeSet;
import java.util.stream.Collectors;

public class Test {

    public static String removeDuplicates(String S) {

        StringBuilder sb = new StringBuilder();

        Stack<Character> stack = new Stack<>();

        for (char c : S.toCharArray()) {
            if (stack.size() > 0 && stack.peek() == c) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }
        Iterator<Character> it = stack.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
        }

        return sb.toString();
    }

    public static String removeDuplicates1(String string) {
        if (string == null) {
            return null;
        }
        char[] chars = string.toCharArray();
        char previous = ' ';
        int i = 0;
        for (char c : chars) {
            if (c != previous) {
                chars[i++] = c;
                previous = c;
            }
        }
        return new String(chars).substring(0, i);
    }

    public static String removeDuplicates2(String string) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < string.length(); i++) {

            char c = string.charAt(i);

            if (stack.size() > 0) {
                if (c != stack.peek()) {
                    stack.add(c);
                } else {
                    while (stack.size() > 0 && stack.peek() == c) {
                        stack.pop();
                    }
                }
            } else {
                stack.add(c);
            }

        }
        Iterator<Character> it = stack.iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            sb.append(it.next());
        }
        return sb.toString();
    }

    public static void main(String[] args) {

        // SSystem.out.println(Test.removeDuplicates("nniioh"));

    }

}
