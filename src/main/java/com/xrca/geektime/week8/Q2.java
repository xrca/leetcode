package com.xrca.geektime.week8;

import java.util.LinkedList;
import java.util.List;

// 剑指 Offer 68 - II. 二叉树的最近公共祖先 https://leetcode-cn.com/problems/er-cha-shu-de-zui-jin-gong-gong-zu-xian-lcof/
public class Q2 {
    public static void main(String[] args) {
        TreeNode node0 = new TreeNode(0);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        node3.left = node5;
        node3.right = node1;
        node5.left = node6;
        node5.right = node2;
        node2.left = node7;
        node2.right = node4;
        node1.left = node0;
        node1.right = node8;
        Q2 q2 = new Q2();
        System.out.println(q2.lowestCommonAncestor(node3, node5, node4).val);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        List<TreeNode> pParentList = new LinkedList<>();
        List<TreeNode> qParentList = new LinkedList<>();
        this.findNode(root, p, pParentList);
        this.findNode(root, q, qParentList);
        TreeNode sameParentNode = root;
        // 找到深度最大的公共父节点
        for (int i = pParentList.size() - 1, j = qParentList.size() - 1; i >= 0 && j >= 0; i--, j--) {
            if (pParentList.get(i).val == qParentList.get(j).val) {
                sameParentNode = pParentList.get(i);
            }
        }
        return sameParentNode;
    }

    // 寻找目标node的所有父节点
    private boolean findNode(TreeNode root, TreeNode target, List<TreeNode> nodeList) {
        if (root.val == target.val) {
            nodeList.add(root);
            return true;
        }
        if (root.left != null && this.findNode(root.left, target, nodeList)) {
            nodeList.add(root);
            return true;
        }
        if (root.right != null && this.findNode(root.right, target, nodeList)) {
            nodeList.add(root);
            return true;
        }
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }
}
