package com.xrca.geektime.week9;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

// 剑指Offer 34.二叉树中和为某一值的路径 https://leetcode-cn.com/problems/er-cha-shu-zhong-he-wei-mou-yi-zhi-de-lu-jing-lcof/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        TreeNode root = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        TreeNode node8 = new TreeNode(8);
        TreeNode node11 = new TreeNode(11);
        TreeNode node13 = new TreeNode(13);
        TreeNode node44 = new TreeNode(4);
        TreeNode node7 = new TreeNode(7);
        TreeNode node2 = new TreeNode(2);
        TreeNode node5 = new TreeNode(5);
        TreeNode node1 = new TreeNode(1);

        root.left = node4;
        root.right = node8;
        node4.left = node11;
        node11.left = node7;
        node11.right = node2;

        node8.left = node13;
        node8.right = node44;
        node44.left = node5;
        node44.right = node1;


        System.out.println(q1.pathSum(root, 22));
    }

    public List<List<Integer>> pathSum(TreeNode root, int target) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> list = this.recursion(root);
        Iterator<List<Integer>> it = list.iterator();
        while (it.hasNext()) {
            List<Integer> path = it.next();
            int sum = path.stream().mapToInt(Integer::intValue).sum();
            if (sum != target) {
                it.remove();
            } else {
                Collections.reverse(path);
            }
        }
        return list;
    }

    public List<List<Integer>> recursion(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if (root.left == null && root.right == null) {
            List<Integer> path = new ArrayList<>();
            list.add(path);
        } else {
            if (root.left != null) {
                list.addAll(this.recursion(root.left));
            }
            if (root.right != null) {
                list.addAll(this.recursion(root.right));
            }
        }
        for (List<Integer> path : list) {
            path.add(root.val);
        }
        return list;
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
}
