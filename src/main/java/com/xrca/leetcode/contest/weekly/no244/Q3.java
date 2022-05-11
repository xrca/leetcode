package com.xrca.leetcode.contest.weekly.no244;

public class Q3 {
    public static void main(String[] args) {
        Q3 q = new Q3();
        String s = "0123";
        System.out.println(s.substring(0, 2));
        System.out.println(s.substring(2));

        String ss = new String("01234");
        System.out.println(ss.substring(0, 2));
        System.out.println(ss.substring(3));

        System.out.println(q.minFlips("111000"));
    }

    public int minFlips(String s) {
        int times = this.flips(s);
        if (times == 0) {
            return 0;
        }
        String prefix = String.valueOf(s.charAt(0));
        String s2 = prefix + s.substring(1);
        int times2 = this.flips(s2);
        return Math.min(times, times2);
    }

    private int flips(String s) {
        int length = s.length();
        if (length % 2 == 0) {
            String prefix = s.substring(0, length / 2);
            String suffix = s.substring(length / 2);
        } else {

        }
        return 0;
    }
}
