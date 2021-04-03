package com.xrca.huawei;

// https://www.nowcoder.com/practice/74c493f094304ea2bda37d0dc40dc85b?tpId=37&tqId=21295&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ72 {
    public static void main(String[] args) {
        int money = 100;
        for (int x = 0; x <= 100 / 5; x++) {
            for (int y = 0; y <= 33; y++) {
                for (int z = 0; z <= 300; z = z + 3) {
                    if (x + y + z == 100 && 5 * x + 3 * y + z / 3 == 100) {
                        System.out.println(x + " " + y + " " + z);
                    }
                }
            }
        }
    }
}
