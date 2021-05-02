package com.xrca.leetcode.contest.weekly.no239;

// 将字符串拆分为递减的连续值 https://leetcode-cn.com/problems/splitting-a-string-into-descending-consecutive-values/
// TODO
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.splitString("66050000430000000000"));
    }

    public boolean splitString(String s) {
        long lastVal;
        for (int i = 0; i < s.length() / 2 + 1; i++) {
            lastVal = Long.valueOf(s.substring(0, i + 1));
            if (lastVal == 0) {
                continue;
            }
            int j;
            for (j = i + 1; j < s.length();) {
                int result = this.recursion(lastVal, s, j);
                if (result < 0) {
                    break;
                } else if (result > 0) {
                    if (result + 1 >= s.length()) {
                        return true;
                    } else {
                        lastVal =  Long.valueOf(s.substring(j, result + 1));
                        j = result + 1;
                    }
                }
            }
        }
        return false;
    }

    // 剩余当中能否找到
    private int recursion(long lastVal, String s, int start) {
        long target = lastVal - 1;
        for (int i = start; i < s.length(); i++) {
            long tmp = Long.valueOf(s.substring(start, i + 1));
            if (tmp == target) {
                return i;
            }
            if (tmp > target) {
                return -1;
            }
        }
        return -1;
    }
}
