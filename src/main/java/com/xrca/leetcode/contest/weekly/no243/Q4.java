package com.xrca.leetcode.contest.weekly.no243;

import java.util.Arrays;

public class Q4 {
    public static void main(String[] args) {

    }


    public int minSkips(int[] dist, int speed, int hoursBefore) {
        int totalDist = Arrays.stream(dist).sum();
        if (totalDist > speed * hoursBefore) {
            return -1;
        } else if (totalDist == speed * hoursBefore) {
            int skipTimes = 0;
            for (int d : dist) {
                if (d % speed != 0) {
                    skipTimes++;
                }
            }
            return skipTimes;
        } else {
            int leftDist = speed * hoursBefore - totalDist;
            for (int i = 0; i < dist.length; i++) {
                if (dist[i] % speed == 0 || i == dist.length - 1) {
                    totalDist = totalDist - dist[i];
                }
            }
            return 0;
        }
    }

}
