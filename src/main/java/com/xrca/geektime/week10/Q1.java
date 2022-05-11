package com.xrca.geektime.week10;

import java.util.ArrayList;
import java.util.List;

// 路径总和3 https://leetcode-cn.com/problems/path-sum-iii/
public class Q1 {
    public static void main(String[] args) {

    }

    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }

        return 0;
    }

    private List<TreeNode> getAllPaths(TreeNode node) {
        List<TreeNode> allChildrenNodes = new ArrayList<>();
        if (node.left != null) {
            allChildrenNodes.addAll(this.getAllPaths(node.left));
        }
        if (node.right != null) {
            allChildrenNodes.addAll(this.getAllPaths(node.right));
        }
        List<TreeNode> nodes = new ArrayList<>(allChildrenNodes.size());
        for (TreeNode n : allChildrenNodes) {
            TreeNode tn = new TreeNode(node.val);
            tn.right = n;
            nodes.add(tn);
        }
        return nodes;
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {}

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}