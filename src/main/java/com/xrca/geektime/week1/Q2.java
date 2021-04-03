package com.xrca.geektime.week1;

// https://leetcode-cn.com/problems/shuffle-string/
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        System.out.println(q2.restoreString("codeleet", new int[]{4, 5, 6, 7, 0, 2, 1, 3}));
        System.out.println(q2.restoreString("abc", new int[]{0, 1, 2}));
        System.out.println(q2.restoreString("aiohn", new int[]{3, 1, 4, 2, 0}));
        System.out.println(q2.restoreString("aaiougrt", new int[]{4, 0, 2, 6, 7, 3, 1, 5}));
        System.out.println(q2.restoreString("art", new int[]{1, 0, 2}));
    }


    public String restoreString(String s, int[] indices) {
        char[] arr = s.toCharArray();
        char[] newStrArr = new char[arr.length];
        for (int i = 0; i < indices.length; i++) {
            newStrArr[indices[i]] = arr[i];
        }
        return new String(newStrArr);
    }
}
