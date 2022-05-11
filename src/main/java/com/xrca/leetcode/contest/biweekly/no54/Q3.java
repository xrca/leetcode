package com.xrca.leetcode.contest.biweekly.no54;

public class Q3 {
    public static void main(String[] args) {
        int[][] grid = {{7,1,4,5,6},{2,5,1,6,4},{1,5,4,3,2},{1,2,7,3,4}};
        /*System.out.println(grid.length);
        System.out.println(grid[0].length);
        System.out.println(grid[2][3]);// 3*/
        System.out.println(new Q3().largestMagicSquare(grid));
    }

    // 任意幻方矩阵的和为 S = n (n^2 + 1) / 2
    public int largestMagicSquare(int[][] grid) {
        // 多少行
        int m = grid.length;
        // 多少列
        int n = grid[0].length;
        int maxSquare = Math.min(m, n);
        while (maxSquare > 1) {
            if (canFindMagic(grid, maxSquare)) {
                return maxSquare;
            }
            maxSquare--;
        }
        return 1;
    }

    /**
     * @param grid 矩阵
     * @param square 魔方大小
     * @return
     */
    private boolean canFindMagic(int[][] grid, int square) {
        int squareSum = square * (square * square + 1);
        for (int i = 0; i < grid.length - square + 1; i++) {
            int sum = 0;
            for (int index = 0; index < square - 1; index++) {
                sum = sum + grid[i][index];
            }
            for (int j = 0; j < grid[i].length - square + 1; j++) {
                sum = sum + grid[i][j + square - 1];
                if (j > 0) {
                    sum = sum - grid[i][j - 1];
                }
                if (2 * sum == squareSum) {
                    if (this.isMagic(grid, i, j, square)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    private boolean isMagic(int[][] grid, int row, int col, int square) {
        int squareSum = square * (square * square + 1);
        // 横向
        for (int i = row; i < row + square; i++) {
            int sum = 0;
            for (int j = col; j < col + square; j++) {
                sum = sum + grid[i][j];
            }
            if (2 * sum != squareSum) {
                return false;
            }
        }

        for (int i = col; i < col + square; i++) {
            int sum = 0;
            for (int j = row; j < row + square; j++) {
                col = col + grid[j][i];
            }
            if (2 * sum != squareSum) {
                return false;
            }
        }
        int sum = 0;
        for (int i = 0; i < square; i++) {
            sum = sum + grid[row + i][col + i];
        }
        if (2 * sum != squareSum) {
            return false;
        }

        sum = 0;
        for (int i = 0; i < square; i++) {
            sum = sum + grid[row + i][col + square - 1 - i];
        }
        return true;
    }
}
