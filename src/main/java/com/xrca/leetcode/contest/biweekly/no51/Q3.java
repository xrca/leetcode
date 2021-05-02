package com.xrca.leetcode.contest.biweekly.no51;

import java.util.Arrays;
import java.util.Collections;

// 减小和重新排列数组后的最大元素 https://leetcode-cn.com/contest/biweekly-contest-51/problems/maximum-element-after-decreasing-and-rearranging/
public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        int[] arr = new int[]{2,2,1,2,1};
        System.out.println(q3.maximumElementAfterDecrementingAndRearranging(arr));
    }

    public int maximumElementAfterDecrementingAndRearranging(int[] arr) {
        return Arrays.stream(opArr(arr)).max().getAsInt();
    }

    private int[] opArr(int[] arr) {
        Arrays.sort(arr);
        if (arr[0] != 0) {
            arr[0] = 1;
        }
        int diff;
        for (int i = 1; i < arr.length; i++) {
            diff = arr[i] - arr[i - 1];
            if (diff > 1) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr;
    }
}
