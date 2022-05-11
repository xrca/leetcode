package com.xrca.leetcode.contest.weekly.no240;

import java.util.HashMap;
import java.util.Map;

public class Q4 {
    public static void main(String[] args) {
        Q4 q4 = new Q4();
        String colors = "abaca";
        int[][] edges = new int[][]{{0,1},{0,2},{2,3},{3,4}};
        System.out.println(q4.largestPathValue(colors, edges));
    }
    public int largestPathValue(String colors, int[][] edges) {
        // 判断是否有环
        Map<Integer, int[]> map = new HashMap<>();
        for (int[] edge : edges) {

        }

        return -1;
    }
}
