package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/e45e078701ab4e4cb49393ae30f1bb04?tpId=37&tqId=21235&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        StringBuilder sb = new StringBuilder(str);
        System.out.println(sb.reverse().toString());
    }
}
