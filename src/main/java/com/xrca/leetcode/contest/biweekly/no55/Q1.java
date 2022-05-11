package com.xrca.leetcode.contest.biweekly.no55;

public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.canBeIncreasing(new int[]{1,2,10,5,7}));
    }

    public boolean canBeIncreasing(int[] nums) {
        int index = -1;
        int last = nums[0];
        boolean remove = false;
        for (int i = 1; i < nums.length; i++) {
            int num = nums[i];
            // 出现非严格递增情况
            if (num <= last) {
                if (remove) {
                    return false;
                } else {
                    index = i;
                    remove = true;
                }
            }
            last = nums[i];
        }
        if (remove && index < nums.length - 1) {
            if (index > 1) {
                if ((nums[index + 1] - nums[index - 1] < 0) && (nums[index] - nums[index - 2] < 0)) {
                    return false;
                }
            } else {
                if (nums[index + 1] - nums[index - 1] < 0 && nums[index + 1] - nums[index] < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
