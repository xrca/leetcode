package com.xrca.leetcode.contest.weekly.no240;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        //int[][] logs = new int[][]{{1993,1999},{2000,2010}};
        int[][] logs = new int[][]{{1950,1961},{1960,1971},{1970,1981}};
        System.out.println(q1.maximumPopulation(logs));
    }

    public int maximumPopulation(int[][] logs) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int[] log : logs) {
            for (int year = log[0]; year < log[1]; year++) {
                int pNums = 0;
                if (map.containsKey(year)) {
                    pNums = map.get(year);
                }
                pNums++;
                map.put(year, pNums);
            }
        }
        int year = 2050;
        int num = 0;
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() > num || (entry.getValue() == num && entry.getKey() < year)) {
                num = entry.getValue();
                year = entry.getKey();
            }
        }
        return year;
    }
}
