package com.xrca.huawei;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

// https://www.nowcoder.com/practice/eb94f6a5b2ba49c6ac72d40b5ce95f50?tpId=37&tqId=21233&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        char[] c = str.toCharArray();
        Set<Character> set = new HashSet<>(c.length);
        for (char cc : c) {
            set.add(cc);
        }
        System.out.println(set.size());
    }
}
