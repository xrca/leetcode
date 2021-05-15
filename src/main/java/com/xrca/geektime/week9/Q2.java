package com.xrca.geektime.week9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


// 特定深度节点链表 https://leetcode-cn.com/problems/list-of-depth-lcci/
public class Q2 {
    public static void main(String[] args) {
        Q2 q2 = new Q2();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);

        node1.left = node2;
        node1.right = node3;

        node2.left = node4;
        node2.right = node5;

        node4.left = node8;

        node3.right = node7;


        System.out.println(q2.listOfDepth(node1));
    }

    public ListNode[] listOfDepth(TreeNode tree) {
        if (tree == null) {
            return new ListNode[0];
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        this.recursion(map, tree, 1);
        ListNode[] listNode = new ListNode[map.size()];
        for (int i = 1; i <= map.size(); i++) {
            List<Integer> list = map.get(i);
            if (list == null) {
                break;
            }
            ListNode root = new ListNode(-1);
            ListNode curr = root;
            for (Integer node : list) {
                curr.next = new ListNode(node);
                curr = curr.next;
            }
            listNode[i - 1] = root.next;
        }
        return listNode;
    }

    public void recursion(Map<Integer, List<Integer>> map, TreeNode root, int depth) {
        List<Integer> list = map.get(depth);
        if (list == null) {
            list = new ArrayList<>();
            map.put(depth, list);
        }
        list.add(root.val);
        depth++;
        if (root.left != null) {
            this.recursion(map, root.left, depth);
        }
        if (root.right != null) {
            this.recursion(map, root.right, depth);
        }
    }


    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {

        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
