package com.xrca.leetcode.contest.weekly.no243;

import java.util.*;

public class Q3 {
    public static void main(String[] args) {
        Q3 q3 = new Q3();
        System.out.println(q3.assignTasks(new int[10], new int[20]));
    }

    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] ans = new int[tasks.length];
        // 待处理任务（task待处理时间）
        List<Integer> todoTaskQueue = new LinkedList<>();
        // 下一个待分配的任务下标
        int taskIndex = 0;
        // 比较器
        Comparator<Server> serverComparator = new Comparator<Server>() {
            @Override
            public int compare(Server o1, Server o2) {
                return Integer.valueOf(o1.weight).compareTo(Integer.valueOf(o2.weight));
            }
        };
        HashMap<Integer, List<Server>> serverMap = new HashMap<>();
        List<Server> serverList = new LinkedList<>();
        for(int i = 0; i < servers.length; i++) {
            Server s = new Server(i, servers[i], 0);
            serverList.add(s);
        }
        Collections.sort(serverList, serverComparator);
        serverMap.put(0, serverList);

        for (int second = 0; second < tasks.length || !todoTaskQueue.isEmpty() ; second++) {
            // 减少时间
            this.process(serverMap, serverComparator);
            // 分配任务
            if (second < tasks.length) {
                todoTaskQueue.add(tasks[second]);
            }

            List<Server> emptyServers = serverMap.get(0);
            List<Server> targetServers;
            while (emptyServers.size() > 0 && todoTaskQueue.size() > 0) {
                Server ss = emptyServers.remove(0);
                int task = todoTaskQueue.remove(0);
                ans[taskIndex] = ss.getNo();
                targetServers = serverMap.get(task);
                if (targetServers == null) {
                    targetServers = new LinkedList<>();
                }
                targetServers.add(ss);
                serverMap.put(task, targetServers);
                taskIndex++;
            }
        }
        return ans;
    }

    private void process(HashMap<Integer, List<Server>> serverMap, Comparator comparator) {
        List<Integer> list = new ArrayList<>(serverMap.keySet());
        Collections.sort(list);
        List<Server> serverList, preList;
        for (Integer integer : list) {
            if (integer == 0) {
                continue;
            }
            serverList = serverMap.get(integer);
            if (serverList == null) {
                continue;
            }
            preList = serverMap.get(integer - 1);
            if (preList == null) {
                serverList = new LinkedList<>();
            }
            preList.addAll(serverList);
            Collections.sort(preList, comparator);
            serverMap.put(integer - 1, preList);
            serverMap.remove(integer);
        }
    }

    class Server {
        private int no;

        private int weight;

        private int leftProcessTime;

        public boolean isBusy() {
            return leftProcessTime > 0;
        }

        public void process() {
            if (leftProcessTime > 0) {
                leftProcessTime--;
            }
        }

        public void assignTask(int taskTime) {
            leftProcessTime = taskTime;
        }

        public int getNo() {
            return no;
        }

        public int getWeigt() {
            return weight;
        }
        public Server(int no, int weight, int leftProcessTime) {
            this.no = no;
            this.weight = weight;
            this.leftProcessTime = leftProcessTime;
        }
    }
}
