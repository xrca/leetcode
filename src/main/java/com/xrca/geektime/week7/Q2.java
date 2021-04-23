package com.xrca.geektime.week7;

// 寻找旋转排序数组中的最小值 https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        //int[] nums = new int[]{3,4,5,1,2};
        int[] nums = new int[]{11};

        System.out.println(q2.findMin(nums));
    }

    public int findMin(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int maxIndex = -1;
        for (int i = 0; i < nums.length - 1;i ++) {
            if (nums[i] > nums[i + 1]) {
                maxIndex = i;
                break;
            }
        }
        if (maxIndex < nums.length - 1) {
            return nums[maxIndex + 1];
        } else {
            return nums[0];
        }
    }
}
