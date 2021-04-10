package com.xrca.geektime.week4;

import java.util.LinkedList;
import java.util.List;

// 队列的最大值 https://leetcode-cn.com/problems/dui-lie-de-zui-da-zhi-lcof/
public class Q1 {
    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(15);
        maxQueue.push_back(9);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}

class MaxQueue {
    private List<Integer> list;

    public MaxQueue() {
        list = new LinkedList<>();
    }

    public int max_value() {
        int maxVal = -1;
        for (int i : list) {
            if (i > maxVal) {
                maxVal = i;
            }
        }
        return maxVal;
    }

    public void push_back(int value) {
        list.add(value);
    }

    public int pop_front() {
        if (list.size() > 0) {
            return list.remove(0);
        }
        return -1;
    }
}
