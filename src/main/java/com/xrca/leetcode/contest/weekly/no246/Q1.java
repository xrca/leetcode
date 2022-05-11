package com.xrca.leetcode.contest.weekly.no246;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.largestOddNumber("12345"));
    }

    public String largestOddNumber(String num) {
        for (int i = num.length() - 1; i >= 0; i--) {
            char c = num.charAt(i);
            if (Integer.valueOf(String.valueOf(c)) % 2 != 0) {
                return num.substring(0, i + 1);
            }
        }
        return "";
    }
}
