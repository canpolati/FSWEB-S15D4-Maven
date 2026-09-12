package org.example;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        System.out.println(checkForPalindrome("I did, did I?"));           // true
        System.out.println(checkForPalindrome("Racecar"));                 // true
        System.out.println(checkForPalindrome("hello"));                   // false
        System.out.println(checkForPalindrome("Was it a car or a cat I saw ?")); // true

        System.out.println(convertDecimalToBinary(5));  // 101
        System.out.println(convertDecimalToBinary(6));  // 110
        System.out.println(convertDecimalToBinary(13)); // 1101
    }

    public static boolean checkForPalindrome(String input) {
        Deque<Character> deque = new ArrayDeque<>();

        for (char c : input.toCharArray()) {
            if (Character.isLetterOrDigit(c)) {
                deque.addLast(Character.toLowerCase(c));
            }
        }

        while (deque.size() > 1) {
            char first = deque.pollFirst();
            char last = deque.pollLast();
            if (first != last) {
                return false;
            }
        }

        return true;
    }

    public static String convertDecimalToBinary(int number) {
        if (number == 0) return "0";

        Stack<Integer> stack = new Stack<>();
        int n = number;

        while (n > 0) {
            stack.push(n % 2);
            n /= 2;
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}