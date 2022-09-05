package com.xrca.leetcode.contest.weekly.no309;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(longestNiceSubarray(new int[]{3,1,5,11,13}));
    }

    public static int longestNiceSubarray(int[] nums) {
        if (nums.length == 1) {
            return 1;
        }
        int[][] matrix = new int[nums.length][];
        for (int i = 0; i < nums.length; i++) {
            int[] rows = new int[nums.length];
            for (int j = 0; j < nums.length; j++) {
                if (i == j) {
                    rows[j] = 0;
                } else {
                    rows[j] = nums[i] & nums[j];
                }
            }
            matrix[i] = rows;
        }

        return 0;
    }
}
