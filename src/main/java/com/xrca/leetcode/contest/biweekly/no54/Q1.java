package com.xrca.leetcode.contest.biweekly.no54;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public static void main(String[] args) {

    }

    public boolean isCovered(int[][] ranges, int left, int right) {
        Set<Integer> set = new HashSet<>(right - left + 1);
        for (int i = left; i <= right; i++) {
            set.add(i);
        }
        for (int[] arr : ranges) {
            for (int val = arr[0]; val < arr[1]; val++) {
                set.remove(val);
            }
        }
        return set.size() == 0;
    }
}
