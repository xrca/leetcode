package com.xrca.leetcode.contest.biweekly.no85;

import java.util.Arrays;

public class Q3 {
    public static void main(String[] args) {

        System.out.println(shiftingLetters("dztz", new int[][]{{0,0,0}, {1,1,1}}));
    }

    public static String shiftingLetters(String s, int[][] shifts) {
        int[] result = new int[s.length()];
        for (int[] arr : shifts) {
            int diff = arr[2] == 0 ? -1 : 1;
            for (int i = arr[0]; i <= arr[1]; i++) {
                result[i] = result[i] + diff;
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (result[i] == 0) {
                continue;
            }
            chars[i] = (char) (97 + (chars[i] - 97 + (result[i] % 26) + 26) % 26);
        }
        return new String(chars);
    }


    public static String shiftingLetters2(String s, int[][] shifts) {
        int[] result = new int[s.length()];
        for (int[] arr : shifts) {
            int diff = arr[2] == 0 ? -1 : 1;
            for (int i = arr[0]; i <= arr[1]; i++) {
                result[i] = result[i] + diff;
            }
        }
        char[] chars = s.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            chars[i] = (char) (97 + (chars[i] - 97 + (result[i] % 26) + 26) % 26);
        }
        return new String(chars);
    }
}
