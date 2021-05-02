package com.xrca.leetcode.contest.biweekly.no51;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

// 座位预约管理系统 https://leetcode-cn.com/contest/biweekly-contest-51/problems/seat-reservation-manager/
public class Q2 {
    public static void main(String[] args) {
        SeatManager seatManager = new SeatManager(5); // 初始化 SeatManager ，有 5 个座位。
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(2); // 将座位 2 变为可以预约，现在可预约的座位为 [2,3,4,5] 。
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        System.out.println(seatManager.reserve());
        seatManager.unreserve(5); // 将座位 5 变为可以预约，现在可预约的座位为 [5] 。
    }

    static class SeatManager {
        private Queue<Integer> queue;

        public SeatManager(int n) {
            queue = new PriorityQueue<>();
            for (int i = 1; i <= n; i++) {
                queue.add(i);
            }
        }

        public int reserve() {
            return queue.poll();
        }

        public void unreserve(int seatNumber) {
            queue.add(seatNumber);
        }
    }
}
