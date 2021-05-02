package com.xrca.leetcode.contest.biweekly.no51;

import java.util.HashMap;
import java.util.HashSet;
import java.util.PriorityQueue;

// 最近的房间 https://leetcode-cn.com/contest/biweekly-contest-51/problems/closest-room/
// TODO
public class Q4 {
    public static void main(String[] args) {
        int[][] rooms = new int[][]{{1,4}, {2,3}, {3,5}, {4,1}, {5,2}};
        int[][] queries = new int[][]{{2,3}, {2,4}, {5,2}};
        Q4 q4 = new Q4();
        System.out.println(q4.closestRoom(rooms, queries));
    }

    public int[] closestRoom(int[][] rooms, int[][] queries) {
        PriorityQueue<int[]> queue = new PriorityQueue<>((o1, o2) -> {
            int v = Integer.valueOf(o1[1]).compareTo(Integer.valueOf(o2[1]));
            if (v == 0) {
                return Integer.valueOf(o1[0]).compareTo(Integer.valueOf(o2[0]));
            }
            return v;
        });
        for (int[] room : rooms) {
            queue.add(room);
        }

        return null;
    }
}
