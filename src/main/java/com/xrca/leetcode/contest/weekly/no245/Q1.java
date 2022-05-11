package com.xrca.leetcode.contest.weekly.no245;

import java.util.HashMap;
import java.util.Map;

public class Q1 {
    public static void main(String[] args) {
        Q1 q = new Q1();
        System.out.println(q.makeEqual(new String[]{"ab", "a"}));
    }

    public boolean makeEqual(String[] words) {
        Map<Character, Integer> map = new HashMap<>(26);
        for (String word : words) {
            char[] arr = word.toCharArray();
            for (char c : arr) {
                if (map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                } else {
                    map.put(c, 1);
                }
            }
        }
        for (Integer val : map.values()) {
            if (val % words.length != 0) {
                return false;
            }
        }
        return true;
    }
}
