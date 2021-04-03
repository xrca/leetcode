package com.xrca.huawei;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// https://www.nowcoder.com/practice/fe298c55694f4ed39e256170ff2c205f?tpId=37&tqId=21245&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ22 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        while (scanner.hasNextLine()) {
            Integer n = Integer.valueOf(scanner.nextLine());
            list.add(n);
        }
        for (int i : list) {
            if (i > 0) {
                System.out.println(calc(i));
            }
        }
    }

    public static int calc(int totalEmpty) {
        if (totalEmpty == 2) {
            return 1;
        } else if (totalEmpty < 2) {
            return 0;
        } else {
            int m = totalEmpty / 3;
            return m + calc(m + (totalEmpty - m * 3));
        }
    }
}
