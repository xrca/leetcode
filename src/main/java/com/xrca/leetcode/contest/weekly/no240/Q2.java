package com.xrca.leetcode.contest.weekly.no240;

public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        int[] nums1 = new int[]{2,2,2};
        int[] nums2 = new int[]{10,10,1};
        System.out.println(q2.maxDistance(nums1, nums2));
    }

    public int maxDistance(int[] nums1, int[] nums2) {
        int maxDistance = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = i + maxDistance + 1; j < nums2.length; j++) {
                if (nums1[i] <= nums2[j]) {
                    maxDistance = Math.max(maxDistance, j - i);
                } else {
                    break;
                }
            }
        }
        return maxDistance;
    }
}

