package com.xrca.huawei;

import java.util.Scanner;

//https://www.nowcoder.com/practice/3ab09737afb645cc82c35d56a5ce802a?tpId=37&tqId=21230&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ7 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        double value = in.nextDouble();
        int number = (int) value;
        double suffix = value - number;
        if (suffix >= 0.5) {
            System.out.println(number + 1);
        } else {
            System.out.println(number);
        }
    }
}
