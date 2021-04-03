package com.xrca.huawei;

import java.util.ArrayList;
import java.util.Scanner;

// https://www.nowcoder.com/practice/8f3df50d2b9043208c5eed283d1d4da6?tpId=37&tqId=21228&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<String> inputs = new ArrayList<>();
        while (scanner.hasNextLine()) {
            inputs.add(scanner.nextLine());
        }
        for (String str : inputs) {
            System.out.println(Long.valueOf(str.substring(2), 16));
        }
    }
}
