package com.xrca.leetcode.contest.weekly.no309;

public class Q1 {
    public static void main(String[] args) {
        System.out.println(checkDistances("", null));
    }

    public static boolean checkDistances(String s, int[] distance) {
        for (int i = 'a'; i <= 'z'; i++) {
            int first = s.indexOf((char) i);
            int last = s.lastIndexOf((char) i);
            if (first == -1 || last == -1) {
                continue;
            }
            if (last - first - 1 != distance[i - 97]) {
                return false;
            }
        }
        return true;
    }
}
