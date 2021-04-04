package com.xrca.geektime.week3;

import java.util.*;

// 每日温度 https://leetcode-cn.com/problems/daily-temperatures/
public class Q2 {
    public static void main(String[] args) {
        //int[] arr = new int[] {73, 74, 75, 71, 69, 72, 76, 73};
        int[] arr = new int[] {34,80,80,34,34,80,80,80,80,34};
        Q2 q2 = new Q2();
        System.out.println(Arrays.toString(q2.dailyTemperatures(arr)));
        System.out.println(Arrays.toString(q2.dailyTemperatures2(arr)));
    }

    // temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
    public int[] dailyTemperatures(int[] T) {
        // 思路：暴力求解，依次遍历整个数组，为求出下次的高温，再依次遍历后面的所有温度
        int currentVal = 0, tmpVal = 0;
        int[] result = new int[T.length];
        for (int i = 0; i < T.length - 1; i++) {
            currentVal = T[i];
            for (int j = i + 1; j < T.length; j++) {
                tmpVal = T[j];
                if (tmpVal > currentVal) {
                    result[i] = j - i;
                    break;
                }
            }
        }
        return result;
    }

    // 逆向遍历，使用跳跃的形式
    public int[] dailyTemperatures2(int[] T) {
        int[] result = new int[T.length];
        for (int i = T.length - 1; i >= 0; i--) {
            for (int j = i + 1; j < T.length;) {
                // 如果找到等于或者大于当前值的情况，则直接跳跃
                if (T[i] < T[j]) {
                    result[i] = j - i;
                    break;
                } else if (T[i] == T[j]) {
                    if (result[j] > 0) {
                        result[i] = j - i + result[j];
                    }
                    break;
                } else {
                    // T[i] > T[j]的情况，如果存在比T[j]大的值，则直接跳跃到该值；如果不存在比T[j]大的值，那么一定不存在比T[i]大的值
                    if (result[j] > 0) {
                        j = j + result[j];
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }

    public int[] dailyTemperatures3(int[] T) {
        int length = T.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = 0; i < length; i++) {
            int temperature = T[i];
            while (!stack.isEmpty() && temperature > T[stack.peek()]) {
                int prevIndex = stack.pop();
                ans[prevIndex] = i - prevIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
