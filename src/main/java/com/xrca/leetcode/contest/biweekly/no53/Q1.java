package com.xrca.leetcode.contest.biweekly.no53;

import java.util.HashSet;
import java.util.Set;

public class Q1 {

    public static void main(String[] args) {

    }


    public int countGoodSubstrings(String s) {
        if (s == null || s.length() < 3) {
            return 0;
        }
        char[] arr = s.toCharArray();
        int count = 0;
        Set<Character> set = new HashSet<>();
        for (int i = 0; i + 2 < s.length(); i++) {
            set.clear();
            set.add(arr[i]);
            set.add(arr[i + 1]);
            set.add(arr[i + 2]);
            if (set.size() == 3) {
                count++;
            }
        }
        return count;
    }
}
