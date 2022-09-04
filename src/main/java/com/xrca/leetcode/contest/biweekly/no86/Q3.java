package com.xrca.leetcode.contest.biweekly.no86;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {

    }

    public static int maximumRows(int[][] mat, int cols) {
        if (cols == mat[0].length) {
            return mat.length;
        }
        int[] rowSum = new int[mat.length];
        for (int i = 0; i < mat.length; i++) {
            int sum = Arrays.stream(mat[i]).sum();
            rowSum[i] = sum;
        }
        return 0;
    }
}
