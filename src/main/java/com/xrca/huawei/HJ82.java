package com.xrca.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.nowcoder.com/practice/e0480b2c6aa24bfba0935ffcca3ccb7b?tpId=37&tqId=21305&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ82 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<String> inputs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputs.add(scanner.nextLine());
        }
        for (String str : inputs) {
            calc(str);
        }
    }
    public static void calc(String str) {
        String[] arr = str.split("/");
        int m = Integer.valueOf(arr[0]);
        int n = Integer.valueOf(arr[1]);
        List<String> list = new ArrayList<>();
        int x = 1, y = 1;
        while (m > 0) {
            if (n % m == 0) {
                y = n / m;
            } else {
                y = n / m + 1;
            }
            m = m * y - n;
            n = n * y;
            list.add(x + "/" + y);
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            if (i != 0) {
                sb.append("+");
            }
            sb.append(list.get(i));
        }
        System.out.println(sb);
    }
}
