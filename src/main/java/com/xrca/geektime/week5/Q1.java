package com.xrca.geektime.week5;

import java.util.ArrayList;
import java.util.List;

// 汉诺塔问题 https://leetcode-cn.com/problems/hanota-lcci/
public class Q1 {

    public static void main(String[] args) {
        List<Integer> A = new ArrayList<>();
        A.add(3);
        A.add(2);
        A.add(1);
        List<Integer> B = new ArrayList<>();
        List<Integer> C = new ArrayList<>();
        Q1 q1 = new Q1();
        q1.hanota(A, B, C);
    }

    public void hanota(List<Integer> A, List<Integer> B, List<Integer> C) {
        move(A.size(), A, B, C);
    }

    public void move(int n, List<Integer> A, List<Integer> B, List<Integer> C) {
        // 如果只有一个盘子，则直接移动到C
        if (n == 1) {
            C.add(A.remove(A.size() - 1));
            return;
        } else {
            // 将A上 1 至 n - 1的盘子移动到B，以C为辅助
            move(n - 1, A, C, B);
            //将A上的n号盘子移动到C
            C.add(A.remove(A.size() - 1));
            // 将B上的盘子移到C，以A为辅助
            move(n - 1, B, A, C);
        }
    }
}
