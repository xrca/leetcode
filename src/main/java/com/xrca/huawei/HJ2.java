package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/a35ce98431874e3a820dbe4b2d0508b1?tpId=37&tqId=21225&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String c = scanner.nextLine();

        int length = str.length();
        String upperCase = c.toUpperCase();
        String lowerCase = c.toLowerCase();

        str = str.replace(upperCase, "");
        str = str.replace(lowerCase, "");

        System.out.println(length - str.length());
    }
}
