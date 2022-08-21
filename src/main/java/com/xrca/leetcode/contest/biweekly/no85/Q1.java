package com.xrca.leetcode.contest.biweekly.no85;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(minimumRecolors("BWWBB", 6));
    }

    public static int minimumRecolors(String blocks, int k) {
        int min = k;
        for (int i = 0; i <= blocks.length() - k; i++) {
            String temp = blocks.substring(i, i + k);
            int cur = temp.replaceAll("B", "").length();
            min = Math.min(cur, min);
        }
        return min;
    }
}
