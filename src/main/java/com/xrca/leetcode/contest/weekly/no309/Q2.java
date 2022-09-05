package com.xrca.leetcode.contest.weekly.no309;

public class Q2 {
    public static void main(String[] args) {
        System.out.println(Integer.MAX_VALUE);
        System.out.println(1000000007);
    }

    public static int numberOfWays(int startPos, int endPos, int k) {
        return recursion(startPos, endPos, k, 0);
    }

    public static int recursion(int currentPos, int targetPos, int k, int totalWay) {
        if (k <= 1) {
            if (currentPos + 1 == targetPos || currentPos - 1 == targetPos) {
                totalWay = totalWay + 1;
                totalWay = totalWay % 1000000007;
                return totalWay;
            } else {
                return totalWay;
            }
        } else {
            totalWay = recursion(currentPos - 1, targetPos, k - 1, totalWay) + recursion(currentPos + 1, targetPos, k - 1, totalWay);
            totalWay = totalWay % 1000000007;
        }
        return totalWay;
    }
}
