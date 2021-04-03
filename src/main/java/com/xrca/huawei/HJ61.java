package com.xrca.huawei;

import java.util.Scanner;

// https://www.nowcoder.com/practice/bfd8234bb5e84be0b493656e390bdebf?tpId=37&tqId=21284&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ61 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNextInt()) {
            int apple = scanner.nextInt();
            int plate = scanner.nextInt();
            System.out.println(calc(apple, plate));
        }
    }

    public static int calc(int apple, int plate) {
        if (apple == 0 || plate == 1) {
            return 1;
        }
        int result = 0;
        for (int i = 0; i <= apple; i++) {
            result = result + calc(apple - i, plate - 1);
        }
        return result;


        /*if (apple == 0 || plate == 1) {
            return 1;
        } else if (plate > apple) {
            return calc(apple, apple);
        } else {
            return calc(apple, plate - 1) + calc(apple - plate, plate);
        }*/
    }
}
