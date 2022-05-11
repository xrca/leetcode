package com.xrca.leetcode.contest.weekly.no243;

public class Q1 {
    public static void main(String[] args) {

    }

    public boolean isSumEqual(String firstWord, String secondWord, String targetWord) {
        Integer firstVal = this.getValue(firstWord);
        Integer secondVal = this.getValue(secondWord);
        Integer targetVal = this.getValue(targetWord);
        return firstVal + secondVal == targetVal;
    }

    private Integer getValue(String word) {
        char[] arr = word.toCharArray();
        StringBuilder sb = new StringBuilder();
        for (char c : arr) {
            sb.append(c - 97);
        }
        return Integer.valueOf(sb.toString());
    }
}
