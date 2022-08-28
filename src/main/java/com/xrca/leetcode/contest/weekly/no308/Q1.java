package com.xrca.leetcode.contest.weekly.no308;

import java.util.Arrays;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(answerQueries(new int[]{4,5,2,1}, new int[]{3, 10, 21}));
    }

    public static int[] answerQueries(int[] nums, int[] queries) {
        // 排序
        Arrays.sort(nums);
        int[] result = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int sum = 0;
            for (int j = 0; j < nums.length; j++) {
                sum = sum + nums[j];
                if (sum > queries[i]) {
                    result[i] = j;
                    break;
                } else if (sum == queries[i]) {
                    result[i] = j + 1;
                    break;
                } else {
                    result[i] = j + 1;
                }
            }
        }
        return result;
    }
}
