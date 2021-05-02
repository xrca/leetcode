package com.xrca.leetcode.contest.weekly.no239;

// 到目标元素的最小距离 https://leetcode-cn.com/problems/minimum-distance-to-the-target-element/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] nums = new int[]{1,2,3,4,5};
        System.out.println(q1.getMinDistance(nums, 5, 3));
    }

    public int getMinDistance(int[] nums, int target, int start) {
        int i = start, j = start;
        for (; i >= 0 || j < nums.length; i--, j++) {
            if (i >= 0 && nums[i] == target) {
                return Math.abs(i - start);
            }
            if (j < nums.length && nums[j] == target) {
                return Math.abs(j - start);
            }
        }
        return -1;
    }
}
