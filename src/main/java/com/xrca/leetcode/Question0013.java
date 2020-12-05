package com.xrca.leetcode;

/**
* @author xrca
*/
public class Question0013 {
    public int romanToInt(String s) {
        int sum = 0;
        if (s != null && s.length() > 0) {
            if (s.contains("IV")) {
                s = s.replaceFirst("IV", "  ");
                sum += 4;
            }
            if (s.contains("IX")) {
                s = s.replaceFirst("IX", "  ");
                sum += 9;
            }
            if (s.contains("XL")) {
                s = s.replaceFirst("XL", "  ");
                sum += 40;
            }
            if (s.contains("XC")) {
                s = s.replaceFirst("XC", "  ");
                sum += 90;
            }
            if (s.contains("CD")) {
                s = s.replaceFirst("CD", "  ");
                sum += 400;
            }
            if (s.contains("CM")) {
                s = s.replaceFirst("CM", "  ");
                sum += 900;
            }
            char[] charArr = s.toCharArray();
            String cStr;
            for (char c : charArr) {
                cStr = String.valueOf(c);
                if (cStr.equals("I")) {
                    sum += 1;
                } else if (cStr.equals("V")) {
                    sum += 5;
                } else if (cStr.equals("X")) {
                    sum += 10;
                } else if (cStr.equals("L")) {
                    sum += 50;
                } else if (cStr.equals("C")) {
                    sum += 100;
                } else if (cStr.equals("D")) {
                    sum += 500;
                } else if (cStr.equals("M")) {
                    sum += 1000;
                }
            }
        }
        return sum;
    }
}
