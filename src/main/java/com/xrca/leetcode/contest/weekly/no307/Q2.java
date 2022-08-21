package com.xrca.leetcode.contest.weekly.no307;

import java.util.HashMap;
import java.util.Map;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(largestPalindromic("444947137"));
    }

    public static String largestPalindromic(String num) {
        char[] chars = num.toCharArray();
        int[] nums = new int[10];
        for (char c : chars) {
            Integer i = c - 48;
            nums[i]++;
        }
        StringBuffer prefixSB = new StringBuffer();
        StringBuffer suffixSB = new StringBuffer();
        StringBuffer middleSB = new StringBuffer();
        for (int i = 9; i >= 0; i--) {
            if (i == 0) {
                if (prefixSB.length() < 1) {
                    continue;
                }
            }
            if (nums[i] > 0) {
                while (nums[i] >= 2) {
                    prefixSB.append(i);
                    suffixSB.append(i);
                    nums[i] = nums[i] - 2;
                }
                if (nums[i] > 0 && middleSB.length() == 0) {
                    middleSB.append(i);
                }
            }
        }
        String s = prefixSB.append(middleSB).append(suffixSB.reverse()).toString();
        if (s.length() == 0) {
            s = "0";
        }
        return s;
    }
}
