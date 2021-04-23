package com.xrca.geektime.week7;

// 寻找峰值 https://leetcode-cn.com/problems/find-peak-element/
public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int[] nums = new int[]{1,2,1,3,5,6,4};
        System.out.println(q1.findPeakElement(nums));
    }

    public int findPeakElement(int[] nums) {
        if (nums.length == 1) {
            return 0;
        }
        boolean flag = false;
        for (int i = 0; i < nums.length; i++) {
            if (i != 0 && i != nums.length - 1) {
                // 中间数
                flag = nums[i] > nums[i - 1] && nums[i] > nums[i + 1];
            } else if (i == 0) {
                // 第一个数
                flag = nums[i] > nums[i + 1];
            } else if (i == nums.length - 1) {
                // 最后一个数
                flag = nums[i] > nums[i - 1];
            }
            if (flag) {
                return i;
            }
        }
        return -1;
    }
}
