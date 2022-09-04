package com.xrca.leetcode.contest.biweekly.no86;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(isStrictlyPalindromic(4));
    }

    public static boolean isStrictlyPalindromic(int n) {
        for (int i = 2; i <= n - 2; i++) {
            String s = Integer.toString(n, i);
            if (!s.equals(new StringBuilder(s).reverse())) {
                return false;
            }
        }
        return true;
    }
}
