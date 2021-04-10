package com.xrca.geektime.week4;

import java.util.*;

// 滑动窗口的最大值 https://leetcode-cn.com/problems/hua-dong-chuang-kou-de-zui-da-zhi-lcof/
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(Arrays.toString(q2.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7}, 3)));
        //System.out.println(Arrays.toString(q2.maxSlidingWindow(new int[]{1}, 1)));
        ///System.out.println(Arrays.toString(q2.maxSlidingWindow(new int[]{1,-1}, 1)));
        ///System.out.println(Arrays.toString(q2.maxSlidingWindow(new int[]{9,11}, 2)));
        //System.out.println(Arrays.toString(q2.maxSlidingWindow(new int[]{4,-2}, 2)));
        //System.out.println(Arrays.toString(q2.maxSlidingWindow(new int[]{}, 1)));
    }

    // 堆排序
    public int[] maxSlidingWindow(int[] nums, int k) {
        if (nums.length == 0) {
            return new int[]{0};
        }
        TreeMap<Integer, Integer> treeMap = new TreeMap<>(Comparator.naturalOrder());
        int[] result = new int[nums.length - k + 1];
        int firstNum = nums[0], lastNum, currentNum, times;
        for (int i = 0; i < k; i++) {
            currentNum = nums[i];
            times = 1;
            if (treeMap.containsKey(currentNum)) {
                times = treeMap.get(currentNum) + 1;
            }
            treeMap.put(currentNum, times);
        }
        result[0] = treeMap.lastKey();
        // 从第二个开始
        for (int i = k; i < nums.length; i++) {
            // 移除第一个数
            times = treeMap.get(firstNum);
            if (times > 1) {
                treeMap.put(firstNum, times - 1);
            } else {
                treeMap.remove(firstNum);
            }
            // 重新设置最后一个数与第一个数
            firstNum = nums[i - k + 1];
            lastNum = nums[i];
            // 放入最后一个数
            times = 1;
            if (treeMap.containsKey(lastNum)) {
                times = treeMap.get(lastNum) + 1;
            }
            treeMap.put(lastNum, times);
            result[i - k + 1] = treeMap.lastKey();
        }
        return result;
    }

    // 优先队列
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int n = nums.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            public int compare(int[] pair1, int[] pair2) {
                return pair1[0] != pair2[0] ? pair2[0] - pair1[0] : pair2[1] - pair1[1];
            }
        });
        for (int i = 0; i < k; ++i) {
            pq.offer(new int[]{nums[i], i});
        }
        int[] ans = new int[n - k + 1];
        ans[0] = pq.peek()[0];
        for (int i = k; i < n; ++i) {
            pq.offer(new int[]{nums[i], i});
            while (pq.peek()[1] <= i - k) {
                pq.poll();
            }
            ans[i - k + 1] = pq.peek()[0];
        }
        return ans;
    }
}
