package com.xrca.daily.y2021.april;


import java.util.HashMap;
import java.util.Map;

//  平方数之和 https://leetcode-cn.com/problems/sum-of-square-numbers/
public class Day20210428 {
    public static void main(String[] args) {
        Day20210428 day = new Day20210428();
        System.out.println(day.judgeSquareSum(16));
    }

    //
    public boolean judgeSquareSum(int c) {
        int low = 0;
        int high = ((int)Math.sqrt(c + 0.0)) + 1;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = low; i < high; i++) {
            if (map.containsKey(c - i * i) || i * i * 2 == c) {
                return true;
            }
            map.put(i * i, i);
        }
        return false;
    }

}


