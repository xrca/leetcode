package com.xrca.daily;

// 递增顺序搜索树 https://leetcode-cn.com/problems/increasing-order-search-tree/
public class Day20210425 {
    public static void main(String[] args) {
        Day20210425 day = new Day20210425();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(8);
        TreeNode node9 = new TreeNode(9);

        node5.left = node3;
        node5.right = node6;
        node3.left = node2;
        node3.right = node4;
        node2.left = node1;
        node5.right = node6;
        node6.right = node8;
        node8.left = node7;
        node8.right = node9;
        TreeNode result = day.increasingBST(node5);
        System.out.println();
    }

    public TreeNode increasingBST(TreeNode root) {
        TreeNode result = new TreeNode();
        this.leftNode(root, result);
        return result.right;
    }

    // 中序遍历(Inorder Traversal (LDR))；先遍历当前节点的左子树，再遍历当前节点，再遍历当前节点的右子树（注意节点成环问题）
    public TreeNode leftNode(TreeNode node, TreeNode resultNode) {
        if (node == null) {
            return null;
        }
        // 遍历左子树
        if (node.left != null) {
            resultNode = this.leftNode(node.left, resultNode);
        }
        // 遍历当前节点
        resultNode.right = node;
        // 去除右节点指针
        node.left = null;
        resultNode = resultNode.right;
        // 遍历右子树
        if (node.right != null) {
            resultNode = this.leftNode(node.right, resultNode);
        }
        return resultNode;
    }

    public static class TreeNode {
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


