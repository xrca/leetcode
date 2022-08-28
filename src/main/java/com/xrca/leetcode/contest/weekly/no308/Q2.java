package com.xrca.leetcode.contest.weekly.no308;

import java.util.Stack;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(removeStars("leet**cod*e"));
    }

    public static String removeStars(String s) {
        Stack<Character> leftStack = new Stack<>();
        Stack<Character> rightStack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            leftStack.push(s.charAt(i));
        }
        while (!leftStack.isEmpty()) {
            Character pop = leftStack.pop();
            if (pop == '*') {
                Character peek = leftStack.peek();
                if (peek != '*') {
                    leftStack.pop();
                } else {
                    rightStack.push(pop);
                }
            } else {
                if (!rightStack.isEmpty()) {
                    if (rightStack.peek() == '*') {
                        rightStack.pop();
                    } else {
                        rightStack.push(pop);
                    }
                } else {
                    rightStack.push(pop);
                }

            }
        }
        StringBuffer sb = new StringBuffer();
        while (!rightStack.isEmpty()) {
            sb.append(rightStack.pop());
        }
        return sb.toString();
    }
}
