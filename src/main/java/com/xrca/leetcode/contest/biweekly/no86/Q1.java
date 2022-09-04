package com.xrca.leetcode.contest.biweekly.no86;

import java.util.HashSet;
import java.util.Set;

public class Q1 {
    public static void main(String[] args) {

    }

    public static boolean findSubarrays(int[] nums) {
        Set<Integer> sumSet = new HashSet<>();
        for (int i = 0; i < nums.length - 1; i++) {
            int sum = nums[i] + nums[i + 1];
            if (sumSet.contains(sum)) {
                return true;
            } else {
                sumSet.add(sum);
            }
        }
        return false;
    }
}
