package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/440f16e490a0404786865e99c6ad91c9?tpId=37&tqId=21238&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        String binaryStr = Integer.toBinaryString(input);
        String remove1Str = binaryStr.replace("1", "");
        System.out.println(binaryStr.length() - remove1Str.length());
    }
}
