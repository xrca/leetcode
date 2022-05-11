package com.xrca.leetcode.contest.weekly.no243;

public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.maxValue("-58754", 6));
    }

    public String maxValue(String n, int x) {
        char c;
        if (n.startsWith("-")) {
            for (int i = 1; i < n.length(); i++) {
                c = n.charAt(i);
                if (String.valueOf(x).charAt(0) < c) {
                    return insertIn(n, i, x);
                }
            }
        } else {
            for (int i = 0; i < n.length(); i++) {
                c = n.charAt(i);
                if (String.valueOf(x).charAt(0) > c) {
                    return insertIn(n, i, x);
                }
            }
        }
        return n + x;
    }

    private String insertIn(String n, int index, int x) {
        String prefix = n.substring(0, index);
        String suffix = n.substring(index);
        return prefix + x + suffix;
    }
}
