package com.xrca.leetcode.contest.biweekly.no85;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(secondsToRemoveOccurrences("0110101"));
    }

    public static int secondsToRemoveOccurrences(String s) {
        if (!s.contains("01")) {
            return 0;
        }
        int times = 0;
        while (s.contains("01")) {
            s = s.replaceAll("01", "10");
            times++;
        }
        return times;
    }
}
