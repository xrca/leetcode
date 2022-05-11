package com.xrca.leetcode.contest.weekly.no244;

import java.util.*;

public class Q2 {
    public static void main(String[] args) {
        Q2 q = new Q2();
        int[] nums = {1,1,2,2,3};
        System.out.println(q.reductionOperations(nums));
    }

    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new TreeSet<>();
        for (int num : nums) {
            set.add(num);
            if (!map.containsKey(num)) {
                map.put(num, 0);
            }
            int times = map.get(num);
            times++;
            map.put(num, times);
        }
        List<Integer> list = new ArrayList<>(set);
        int op = 0;
        for (int i = list.size() - 1; i > 0; i--) {
            int tmp = map.get(list.get(i));
            op = op + tmp * i;
        }
        return op;
    }
}
