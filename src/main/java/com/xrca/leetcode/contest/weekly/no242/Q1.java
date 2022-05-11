package com.xrca.leetcode.contest.weekly.no242;

public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        /*
        "1101"
"111000"
"110100010"
         */
        System.out.println(q1.checkZeroOnes("1101"));
    }

    public boolean checkZeroOnes(String s) {
        if (s == null || s.length() == 0) {
            return false;
        }
        String[] zeroStrs = s.split("1");
        int maxZeroStrLength = this.maxLength(zeroStrs);

        String[] oneStrs = s.split("0");
        int maxOneStrLength = this.maxLength(oneStrs);

        return maxOneStrLength > maxZeroStrLength;
    }

    private int maxLength(String[] strs) {
        if (strs == null) {
            return 0;
        }
        int maxLength = 0;
        for (String str : strs) {
            maxLength = Math.max(str.length(), maxLength);
        }
        return maxLength;
    }
}
