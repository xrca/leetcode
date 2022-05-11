package com.xrca.leetcode.contest.weekly.no242;

import java.math.BigDecimal;
import java.util.Arrays;

public class Q2 {

    public static void main(String[] args) {
        int[] dist = new int[] {1, 3, 2};
        Q2 q2 = new Q2();
        //System.out.println(Math.ceil(0.5));
        //System.out.println(q2.minSpeedOnTime(dist, 2.1));
        System.out.println(q2.minSpeedOnTime(dist, 6));
    }


    public int minSpeedOnTime(int[] dist, double hour) {
        if (hour < dist.length - 1) {
            return -1;
        }
        int minSpeed = 1;
        int maxDist = Arrays.stream(dist).max().getAsInt();
        int maxSpeed = (int) Math.ceil(maxDist / (hour - Math.floor(hour)));
        int speed = maxSpeed;
        // 二分查找
        while (minSpeed < maxSpeed) {
            if (this.canReache(dist, (minSpeed + maxSpeed) / 2, hour)) {
                maxSpeed = (minSpeed + maxSpeed) / 2;
                speed = maxSpeed;
            } else {
                minSpeed = (minSpeed + maxSpeed) / 2 + 1;
            }
        }
        return speed;
    }

    private boolean canReache(int[] dist, int speed, double hour) {
        double totalHour = 0;
        for (int i = 0; i < dist.length - 1; i++) {
            totalHour = totalHour + Math.ceil((dist[i] + 0.0) / speed);
        }
        if (totalHour >= hour) {
            return false;
        }
        double leftDist = hour * speed - totalHour * speed;
        if (leftDist > dist[dist.length - 1]) {
            return false;
        }
        return true;
    }
}
