package com.xrca.leetcode.contest.weekly.no240;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] nums = new int[]{1,2,3,2};
        System.out.println(q3.maxSumMinProduct(nums));
    }

    //
    public int maxSumMinProduct(int[] nums) {
        long maxVal = 0;
        for (int i = 2; i <= nums.length; i++) {
            long sumVal = 0;
            int min = nums[0];
            PriorityQueue<Integer> queue = new PriorityQueue<>();
            for (int j = 0; j < i; j++) {
                min = Math.min(min, nums[j]);
                sumVal = sumVal + nums[j];
                queue.offer(nums[j]);
            }
            maxVal = sumVal * min;
            for (int j = i; j < nums.length; j++) {
                //queue.
                sumVal = sumVal - nums[j - i] + nums[j];
                maxVal = Math.max(maxVal, sumVal * min);
            }
        }
        long result = maxVal % (1000000007L);
        return (int) result;
    }
}
