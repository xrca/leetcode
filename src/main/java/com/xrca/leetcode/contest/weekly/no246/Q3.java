package com.xrca.leetcode.contest.weekly.no246;

public class Q3 {
    public static void main(String[] args) {

    }


    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int[][] result = new int[grid1.length][grid1[0].length];
        for (int i = 0; i < grid1.length; i++) {
            for (int j = 0; j < grid1[i].length; j++) {
                result[i][j] = (grid1[i][j] == 1 ? 2 : 0) - grid2[i][j];
            }
        }
        return 0;
    }
}
