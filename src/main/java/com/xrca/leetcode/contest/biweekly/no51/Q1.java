package com.xrca.leetcode.contest.biweekly.no51;

// 将所有数字用字符串替换 https://leetcode-cn.com/contest/biweekly-contest-51/problems/replace-all-digits-with-characters/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        System.out.println(q1.replaceDigits("a1b2c3d4e"));
    }

    public String replaceDigits(String s) {
        char[] charArr = s.toCharArray();
        char[] newArr = new char[charArr.length];
        for (int i = 0; i < charArr.length; i = i + 2) {
            newArr[i] = charArr[i];
            if (i + 1 < charArr.length) {
                newArr[i + 1] = shift(charArr[i], Integer.valueOf(String.valueOf(charArr[i + 1])));
            }
        }
        return new String(newArr);
    }

    private char shift(char c, int x) {
        int cVal = c;
        int newVal = c + x;
        return (char)newVal;
    }
}
