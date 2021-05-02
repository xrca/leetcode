package com.xrca.daily;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

//  青蛙过河 https://leetcode-cn.com/problems/frog-jump/
// TODO
public class Day20210429 {
    public static void main(String[] args) {
        Day20210429 day = new Day20210429();
        //int[] stones = new int[] {0,1,3,5,6,8,12,17};
        //int[] stones = new int[] {0,1,2,3,4,8,9,11};
        int[] stones = new int[] {0,1,2,3,4,5,6,9};
        System.out.println(day.canCross(stones));
    }

    public boolean canCross(int[] stones) {
        if (stones.length <= 2) {
            return stones[1] - stones[0] <= 1 ? true : false;
        }
        List<Integer> list = Arrays.stream(stones).boxed().collect(Collectors.toList());
        // 逆推，保证最后一跳的步长为1
        Collections.reverse(list);
        int firstStone = list.remove(0);
        boolean can = false;
        List<Integer> leftStone = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            leftStone.clear();
            leftStone.addAll(list.subList(i, list.size()));
            can = jump(leftStone, firstStone - list.get(i));
            if (can) {
                return true;
            }
        }
        return can;
    }

    public boolean jump(List<Integer> stones, int lastStep) {
        //System.out.println("本次：" + stones + " " + lastStep);
        // 最后一步，步数必须为1
        if (stones.size() <= 1 && lastStep == 1) {
            return true;
        }
        if (stones.size() == 2 && lastStep == 2) {
            return stones.get(0) - stones.get(1) <= 1 ? true : false;
        }
        // 下一步只能为 firstStep +_1
        int currentStone = stones.remove(0);
        int nextStone = currentStone - (lastStep + 1);

        List<Integer> leftStone = new ArrayList<>();
        if (stones.contains(nextStone)) {
            // 移除所有小于nextstone的值
            int index = stones.indexOf(nextStone);
            leftStone.clear();
            leftStone.addAll(stones.subList(index, stones.size()));
            boolean can = jump(leftStone, lastStep + 1);
            System.out.println(lastStep + 1 + " " + can);
            if (can) {
                return true;
            }
        }
        nextStone = currentStone - lastStep;
        if (stones.contains(nextStone)) {
            // 移除所有小于nextstone的值
            int index = stones.indexOf(nextStone);
            leftStone.clear();
            leftStone.addAll(stones.subList(index, stones.size()));
            boolean can = jump(leftStone, lastStep);
            System.out.println(lastStep - 1 + " " + can);
            if (can) {
                return true;
            }
        }
        nextStone = currentStone - (lastStep - 1);
        if (stones.contains(nextStone)) {
            // 移除所有小于nextstone的值
            int index = stones.indexOf(nextStone);
            leftStone.clear();
            leftStone.addAll(stones.subList(index, stones.size()));
            boolean can = jump(leftStone, lastStep - 1);
            System.out.println(lastStep - 1 + " " + can);
            if (can) {
                return true;
            }
        }
        return false;
    }

}


