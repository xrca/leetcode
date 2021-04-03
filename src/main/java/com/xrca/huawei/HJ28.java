package com.xrca.huawei;

import java.util.*;

// https://www.nowcoder.com/practice/b9eae162e02f4f928eac37d7699b352e?tpId=37&tqId=21251&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ28 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<List<Integer>> inputs = new ArrayList<>();
        while (scanner.hasNextInt()) {
            int nums = scanner.nextInt();
            List<Integer> list = new ArrayList<>(nums);
            for (int i = 0; i < nums; i++) {
                list.add(scanner.nextInt());
            }
            Collections.sort(list);
            inputs.add(list);
        }
        System.out.println(inputs);
    }

    public static int calc(List<Integer> list) {
        List<Pair> pairs = new ArrayList<>();
        for (int i = 0; i< list.size(); i++) {
            for (int j = i + 1; j < list.size(); j++) {
                if (isSuShu(i + j)) {
                    pairs.add(new Pair(i, j));
                }
            }
        }
        if (pairs.size() == 0) {
            return 0;
        }
        Map<Integer, List<Pair>> map = new HashMap<>();
        for (Pair pair : pairs) {
            if (!map.containsKey(pair.num1)) {
                map.put(pair.num1, new ArrayList<>());
            }
            if (!map.containsKey(pair.num2)) {
                map.put(pair.num2, new ArrayList<>());
            }
            map.get(pair.num1).add(pair);
            map.get(pair.num2).add(pair);
        }

        Map<Integer, Integer> treeMap = new TreeMap<>(Comparator.naturalOrder());
        for (Map.Entry<Integer, List<Pair>> entry : map.entrySet()) {
            treeMap.put(entry.getValue().size(), entry.getKey());
        }
        Set<Pair> pairSet = new HashSet<>(map.size());
        for (Map.Entry<Integer, Integer> entry : treeMap.entrySet()) {
            //pairSet.
        }
        return 0;
    }

    public static boolean isSuShu(int num) {
        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }

    static class Pair {
        Pair(int num1, int num2) {
            if (num1 <= num2) {
                this.num1 = num1;
                this.num2 = num2;
            } else {
                this.num1 = num2;
                this.num2 = num1;
            }
        }

        int num1;
        int num2;

        @Override
        public boolean equals(Object obj) {
            Pair p = (Pair) obj;
            if (p.num1 == this.num1 && p.num2 == this.num2) {
                return true;
            }
            return false;
        }

        @Override
        public int hashCode() {
            return Integer.valueOf(num1).hashCode() + Integer.valueOf(num2).hashCode();
        }
    }
}
