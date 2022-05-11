package com.xrca.leetcode.contest.biweekly.no53;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {

    }

    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int maxSum = 0;
        for (int i = 0; i < nums.length / 2; i++) {
            maxSum = Math.max(maxSum, nums[i] + nums[nums.length - i - 1]);
        }
        return maxSum;
    }
}
