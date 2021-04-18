package com.xrca.geektime.week6;

import java.util.Arrays;

// 接雨水 https://leetcode-cn.com/problems/trapping-rain-water/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        int [] height = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        //int [] height = new int[]{4,2,1,3,2,5};
        //int [] height = new int[]{4, 2, 3};
        //int [] height = new int[]{9,6,8,8,5,6,3};
        System.out.println(q1.trap(height));
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int result = 0;
        // 左右两边无法接到雨水，判断每个位置的雨水能达到的最大高度：即左右两侧的最高的柱子中较小的柱子决定了最大高度
        for (int i = 1; i < height.length; i++) {
            int maxleft = 0, maxRight = 0;
            for (int left = 0; left < i; left++) {
                maxleft = maxleft > height[left] ? maxleft : height[left];
            }
            for (int right = i + 1; right < height.length; right++) {
                maxRight = maxRight > height[right] ? maxRight : height[right];
            }
            int waterHeight = (maxleft > maxRight ? maxRight : maxleft) - height[i];
            result = result + (waterHeight >= 0 ? waterHeight : 0);
        }
        return result;
    }

    public int trap0(int[] height) {
        int ans = 0;
        int size = height.length;
        for (int i = 1; i < size - 1; i++) {
            int max_left = 0, max_right = 0;
            for (int j = i; j >= 0; j--) { //Search the left part for max bar size
                max_left = Math.max(max_left, height[j]);
            }
            for (int j = i; j < size; j++) { //Search the right part for max bar size
                max_right = Math.max(max_right, height[j]);
            }
            ans += Math.min(max_left, max_right) - height[i];
        }
        return ans;
    }

    public int trap1(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int maxVal = Arrays.stream(height).max().getAsInt();
        int minVal = Arrays.stream(height).min().getAsInt();
        int result = 0;
        for (int i = maxVal; i > minVal; i--) {
            int start = 0, currentVal = 0;
            for (int j = 0; j < height.length; j++) {
                int v = height[j] - i >= 0 ? 1 : 0;
                if (v == 1) {
                    if (start == 1) {
                        result = result + currentVal;
                        currentVal = 0;
                    } else {
                        start = 1;
                        currentVal = 0;
                    }
                } else {
                    if (start == 1) {
                        currentVal++;
                    }
                }
            }
        }
        return result;
    }

    public int trap2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int rowNum = Arrays.stream(height).max().getAsInt();
        int minVal = Arrays.stream(height).min().getAsInt();
        int colNum = height.length;
        int[] [] matrix = new int[rowNum - minVal][colNum];
        for (int i = 0; i < colNum; i++) {
            int val = height[i];
            int fillVal = 0;
            for (int j = 0; j < rowNum - minVal; j++) {
                if (fillVal == 0 && j >= rowNum - val) {
                    fillVal = 1;
                }
                matrix[j][i] = fillVal;
            }
        }
        int result = 0;
        for (int[] arr : matrix) {
            int start = 0, currentVal = 0;
            for (int v : arr) {
                if (v == 1) {
                    if (start == 1) {
                        result = result + currentVal;
                        currentVal = 0;
                    } else {
                        start = 1;
                        currentVal = 0;
                    }
                } else {
                    if (start == 1) {
                        currentVal++;
                    }
                }
            }
        }
        return result;
    }
}


