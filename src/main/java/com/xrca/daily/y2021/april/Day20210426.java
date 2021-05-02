package com.xrca.daily.y2021.april;

import java.util.Arrays;

//  在D天内送达包裹的能力 https://leetcode-cn.com/problems/capacity-to-ship-packages-within-d-days/
public class Day20210426 {
    public static void main(String[] args) {
        Day20210426 day = new Day20210426();
        int[] weights = new int[] {1,2,3,4,5,6,7,8,9,10};
        //int[] weights = new int[] {10,10,10,10,10};
        //int[] weights = new int[] {3,2,2,4,1,4};
        //int[] weights = new int[] {1,2,3,1,1};
        System.out.println(day.shipWithinDays(weights, 5));
    }

    public int shipWithinDays(int[] weights, int D) {
        // 最重货物
        int lowWeight = Arrays.stream(weights).max().getAsInt();
        int highWeight = Arrays.stream(weights).sum();
        //maxWeight <= capacity <= sumWeight
        int capacity = highWeight;
        // 二分查找
        while (lowWeight < highWeight) {
            boolean canShip = canShip(weights, D, (lowWeight + highWeight) / 2);
            if (canShip) {
                capacity = (lowWeight + highWeight) / 2;
                highWeight = capacity;
            } else {
                if (lowWeight < (lowWeight + highWeight) / 2) {
                    lowWeight = (lowWeight + highWeight) / 2;
                } else {
                    break;
                }
            }
        }
        return capacity;
    }

    public boolean canShip(int[] weights, int D, int capacity) {
        int oneDayWeight = 0, i;
        for (i = 0; i < weights.length && D >= 1; i++) {
            if (oneDayWeight + weights[i] < capacity) {
                oneDayWeight = oneDayWeight + weights[i];
            } else if (oneDayWeight + weights[i] == capacity) {
                D--;
                oneDayWeight = 0;
            } else {
                D--;
                oneDayWeight = weights[i];
            }
        }
        return i == weights.length && (D > 0 || oneDayWeight == 0);
    }
}


