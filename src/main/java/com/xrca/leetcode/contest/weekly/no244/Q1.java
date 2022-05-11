package com.xrca.leetcode.contest.weekly.no244;

public class Q1 {
    public static void main(String[] args) {
        Q1 q = new Q1();
        int[][] mat = new int[][]{{0, 1}, {1, 0}};
        int[][] target = new int[][]{{1, 0}, {0, 1}};
        System.out.println(q.findRotation(mat, target));
    }

    public boolean findRotation(int[][] mat, int[][] target) {
        if (this.isEqual(mat, target)) {
            return true;
        }
        for (int i = 0; i < 3; i++) {
            mat = this.spin(mat);
            if (this.isEqual(mat, target)) {
                return true;
            }
        }
        return false;
    }

    private int[][] spin(int[][] temp) {
        int len = temp.length;
        int b [][] = new int [len][len];
        for (int i = 0; i < len; i++) {
            for(int j = 0; j < len; j++) {
                b[j][len-1-i] = temp[i][j];
            }
        }
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                temp[i][j] = b[i][j];
            }
        }
        return temp;
    }

    private boolean isEqual(int[][] a, int[][] b) {
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                if (a[i][j] != b[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
