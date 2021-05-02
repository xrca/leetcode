package com.xrca.geektime.week8;

import java.util.*;

// LRU缓存 https://leetcode-cn.com/problems/lru-cache-lcci/
//LRU 最近最久未使用; LFU  最近最少使用（最不常用）
public class Q1 {
    public static void main(String[] args) {
        LRUCache cache = new LRUCache(2);
        System.out.println(cache.get(2));
        cache.put(2, 6);
        System.out.println(cache.get(1));
        cache.put(1, 5);
        cache.put(1, 2);
        System.out.println(cache.get(1));
        System.out.println(cache.get(2));
        //System.out.println(cache.get(3));
        //System.out.println(cache.get(4));
    }

    static class LRUCache {
        private Map<Integer, Integer> cache;
        private List<Integer> deque;
        private int capaticy;

        public LRUCache(int capacity) {
            cache = new HashMap<>(capacity);
            deque = new LinkedList<>();
            this.capaticy = capacity;
        }

        public int get(int key) {
            Integer val = cache.get(key);
            if (val == null) {
                val = -1;
            } else {
                // 提到队列头部
                deque.remove(Integer.valueOf(key));
                deque.add(Integer.valueOf(key));
            }
            return val;
        }

        public void put(int key, int value) {
            this.remove(key);
            if (cache.size() >= capaticy) {
                Integer removeKey = deque.remove(0);
                cache.remove(removeKey);
            }
            cache.put(key, value);
            deque.add(Integer.valueOf(key));
        }

        private boolean remove(int key) {
            if (cache.containsKey(key)) {
                cache.remove(key);
                deque.remove(Integer.valueOf(key));
                return true;
            }
            return false;
        }
    }
}
