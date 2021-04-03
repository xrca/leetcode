package com.xrca.huawei;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

// https://www.nowcoder.com/practice/1221ec77125d4370833fd3ad5ba72395?tpId=37&tqId=21260&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ37 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while(scanner.hasNextInt()) {
            int month = scanner.nextInt();
            List<Rabbit> rabbits = new ArrayList<>();
            rabbits.add(new Rabbit(0));

            for (int m = 1; m <= month; m++) {
                for (Rabbit rabbit : rabbits) {
                    rabbit.grow();
                }
                List<Rabbit> children = new ArrayList<>();
                Iterator<Rabbit> it = rabbits.iterator();
                while (it.hasNext()) {
                    Rabbit child = it.next().born();
                    if (child != null) {
                        children.add(child);
                    }
                }
                rabbits.addAll(children);
            }
            System.out.println(rabbits.size());
        }

    }

    static class Rabbit {
        int age = 1;

        Rabbit(int age) {
            this.age = age;
        }

        public Rabbit born() {
            if (age >= 3) {
                return new Rabbit(1);
            } else {
                 return null;
            }
        }

        public void grow() {
            age++;
        }
    }
}
