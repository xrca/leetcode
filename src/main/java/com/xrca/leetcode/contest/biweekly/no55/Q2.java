package com.xrca.leetcode.contest.biweekly.no55;

public class Q2 {
    public static void main(String[] args) {

    }

    public String removeOccurrences(String s, String part) {
        while (s.contains(part)) {
            s = s.replaceFirst(part, "");
        }
        return s;
    }
}
