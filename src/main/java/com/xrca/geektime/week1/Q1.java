package com.xrca.geektime.week1;

// https://leetcode-cn.com/problems/string-to-url-lcci/
public class Q1 {

    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.replaceSpaces("               ", 5));
    }

    public String replaceSpaces(String S, int length) {
        // 先排除空串或实际长度为0的情况
        if (S == null || S.length() == 0 || length == 0) {
            return "";
        }
        // 将字符串转化为字符数组，然后遍历数组，遇到空格时添加%20
        char[] arr = S.toCharArray();
        StringBuilder sb = new StringBuilder();
        int strLength = 0;
        for (char c : arr) {
            if (c == ' ') {
                sb.append("%20");
            } else {
                sb.append(c);
            }
            strLength++;
            if (strLength >= length) {
                break;
            }
        }
        return sb.toString();
    }
}
