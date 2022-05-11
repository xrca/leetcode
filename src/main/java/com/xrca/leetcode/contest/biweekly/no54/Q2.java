package com.xrca.leetcode.contest.biweekly.no54;

import java.util.Arrays;

public class Q2 {
    public static void main(String[] args) {
        Q2 q = new Q2();
        //System.out.println(q.chalkReplacer(new int[]{5, 1, 5}, 22));
        //System.out.println(q.chalkReplacer(new int[]{3, 4, 1, 2}, 25));
        System.out.println(100000L * 100000L);
        System.out.println(Integer.MAX_VALUE);
        System.out.println(Long.MAX_VALUE);
    }

    /*public int chalkReplacer(int[] chalk, int k) {
        int oneLoopChalks = Arrays.stream(chalk).sum();
        k = k % oneLoopChalks;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > k) {
                return i;
            }
            k = k - chalk[i];
            if (i == chalk.length - 1) {
                i = -1;
            }
        }
        return 0;
    }*/

    public int chalkReplacer(int[] chalk, int k) {
        int leftChalks = k;
        for (int i = 0; i < chalk.length; i++) {
            if (chalk[i] > leftChalks) {
                return i;
            }
            leftChalks = leftChalks - chalk[i];
            if (i == chalk.length - 1) {
                leftChalks = leftChalks % (k - leftChalks);
                i = -1;
            }
        }
        return 0;
    }
}
