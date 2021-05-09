package com.xrca.daily.y2021.may;

// 数组异或操作 https://leetcode-cn.com/problems/xor-operation-in-an-array/
public class Day20210507 {
    public static void main(String[] args) {
        Day20210507 day = new Day20210507();
        System.out.println(day.xorOperation(10, 5));

        System.out.println((3 ^ (3 + 2)));
        System.out.println((3 ^ 3 + 3 ^ 2));
    }

    public int xorOperation(int n, int start) {
        int result = start + 2 * 0;
        //start ^ (start + 2 * 1) ^ (start + 2 * 2) ^ ... ^ (start + 2 * i)
        for (int i = 1; i < n; i++) {
            result = result ^ (start + 2 * i);
        }
        return result;
    }



}
