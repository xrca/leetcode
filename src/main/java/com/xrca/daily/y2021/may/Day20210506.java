package com.xrca.daily.y2021.may;

import java.util.Arrays;

// 解码异或后的数组 https://leetcode-cn.com/problems/decode-xored-array/
public class Day20210506 {
    public static void main(String[] args) {
        Day20210506 day = new Day20210506();
        int[] encoded = new int[]{6,2,7,3};
        System.out.println(Arrays.toString(day.decode(encoded, 4)));
    }

    public int[] decode(int[] encoded, int first) {
        int[] result = new int[encoded.length + 1];
        result[0] = first;
        for (int i = 1; i < result.length; i++) {
            result[i] = result[i - 1] ^ encoded[i - 1];
        }
        return result;
    }
}
