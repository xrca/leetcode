package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/22948c2cad484e0291350abad86136c3?tpId=37&tqId=21331&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ108 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num1 = scanner.nextInt();
        int num2 = scanner.nextInt();
        int result = 1;
        int value = 1;
        do {
            num1 = num1 / value;
            num2 = num2 / value;
            value = recurit(num1, num2);
            result = result * value;
        } while (value != 1);
        System.out.println(result * num1 * num2);
    }

    public static int recurit(int num1, int num2) {
        for (int i = 2; i <= num1 && i <= num2; i++) {
            if (num1 % i == 0 && num2 % i == 0) {
                return i;
            }
        }
        return 1;
    }
}
