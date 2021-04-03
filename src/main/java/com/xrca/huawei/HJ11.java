package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/ae809795fca34687a48b172186e3dafe?tpId=37&tqId=21234&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ11 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Integer value = in.nextInt();
        StringBuilder sb = new StringBuilder(value.toString());
        System.out.println(sb.reverse().toString());

    }
}
