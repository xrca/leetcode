package com.xrca.leetcode.contest.weekly.no308;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {
        System.out.println(garbageCollection(new String[]{"G","P","GP","GG"}, new int[]{2, 4, 3}));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int sumM = 0, sumP = 0, sumG = 0;
        int tempM = 0, tempP = 0, tempG = 0;
        for (int i = 0; i < garbage.length; i++) {
            int m = 0, p = 0, g = 0;
            for (int j = 0; j < garbage[i].length(); j++) {
                if (garbage[i].charAt(j) == 'M') {
                    m++;
                } else if (garbage[i].charAt(j) == 'P') {
                    p++;
                } else if (garbage[i].charAt(j) == 'G') {
                    g++;
                }
            }
            if (i >= 1) {
                tempM = tempM + travel[i - 1];
                tempP = tempP + travel[i - 1];
                tempG = tempG + travel[i - 1];
            }
            if (m > 0) {
                sumM = sumM + m + tempM;
                tempM = 0;
            }

            if (p > 0) {
                sumP = sumP + p + tempP;
                tempP = 0;
            }

            if (g > 0) {
                sumG = sumG + g + tempG;
                tempG = 0;
            }
        }
        return sumM + sumP + sumG;
    }
}
