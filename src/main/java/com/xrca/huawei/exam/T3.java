package com.xrca.huawei.exam;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

// 给定一个字符串（只包含数字与所有大小写字母），查找符合要求的最大子串（本身也是子串）
// 子串需满足：除含有一个字母外，均为数字
// 若子串只包含数字或自包含字母，则返回-1
public class T3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        // 字符串
        String str = in.nextLine();

        char[] arr = str.toCharArray();
        List<Integer> list = new ArrayList<>(arr.length);
        // 将字符转化为数值
        // a = 97; z = 122;
        // A = 65; Z = 90;
        // 0 = 48; 1= 49; 2 = 50; 3 = 51; 4 = 52; 5 = 53; 6 = 54; 7 = 55; 8 = 56;9 = 57
        boolean hasNum = false;
        boolean hasCharacter = false;
        for (char c : arr) {
            int num = c;
            if (!hasNum && (num >= 48 && num <= 57)) {
                hasNum = true;
            }
            if (!hasCharacter && ((num >= 65 && num <= 90) || (num >= 97 && num <= 122))) {
                hasCharacter = true;
            }
            list.add(num);
        }
        if (!hasNum || !hasCharacter) {
            System.out.println(-1);
            return;
        }
        // 寻找最大子串
        int maxLength = 2;
        for (int i = 0; i < list.size(); i++) {
            int currentLength = 0;
            boolean containsChar = false;
            for (int j = i; j < list.size(); j++) {
                int num = list.get(j);
                // 当前为字母
                if ((num >= 97 && num <= 122) || (num >= 65 && num <= 90)) {
                    if (containsChar) {
                        break;
                    } else {
                        containsChar = true;
                        currentLength++;
                    }
                } else {
                    // 为数字
                    currentLength++;
                }
            }
            if (maxLength < currentLength) {
                maxLength = currentLength;
            }
        }
        System.out.println(maxLength);
    }
}
