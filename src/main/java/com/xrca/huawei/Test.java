package com.xrca.huawei;

import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int month = scanner.nextInt();

            //1.初始时农场有一只年龄为0的兔子
            ArrayList<Rabbit> farm = new ArrayList<>();
            Rabbit rabbit = new Rabbit(0);
            farm.add(rabbit);

            //2.每过去一个月：在这一个月*里面*，满了两个月的兔子会生产，同时它们的年龄会增加
            for (int i = 0; i < month; i++) {
                int n = farm.size();
                for (int j = 0; j < n; j++) {
                    Rabbit rabbit1 = farm.get(j);
                    if (rabbit1.getAge() >= 2) {
                        farm.add(new Rabbit(1));//这里是1不是0，需要注意。因为这个月过去了小兔子也满一个月了
                    }
                    rabbit1.setAge(rabbit1.getAge() + 1);
                }
            }
            //得到兔子的总数
            int number = farm.size();
            System.out.println(number);
        }
    }

    /**
     * 兔子类
     */
    static class Rabbit {
        private int age;

        public Rabbit(int age) {
            this.age = age;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
