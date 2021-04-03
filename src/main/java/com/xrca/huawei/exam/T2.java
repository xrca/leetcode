package com.xrca.huawei.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 给定一个序列数，再给定一个sum数，求子序列之和为sum的序列中，最长为多少，若不存在则返回-1
public class T2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 序列
        String str = in.nextLine();
        // sum
        String sumStr = in.nextLine();

        String[] arr = str.split(",");
        List<Integer> list = new ArrayList<>(arr.length);
        for (String s : arr) {
            list.add(Integer.valueOf(s));
        }
        int sum = Integer.valueOf(sumStr);
        int maxSubListLength = -1;
        for (int i = 0; i < list.size(); i++) {
            int tmpSum = 0;
            for (int j = i; j < list.size(); j++) {
                tmpSum = tmpSum + list.get(j);
                if (sum == tmpSum) {
                    maxSubListLength = maxSubListLength > (j - i + 1) ? maxSubListLength : (j - i + 1);
                } else if (tmpSum > sum) {
                    break;
                }
            }
        }
        System.out.println(maxSubListLength);
    }
}
