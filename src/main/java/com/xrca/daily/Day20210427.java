package com.xrca.daily;


//  二叉搜索树的范围 https://leetcode-cn.com/problems/range-sum-of-bst/
public class Day20210427 {
    public static void main(String[] args) {
        Day20210427 day = new Day20210427();
        TreeNode node3 = new TreeNode(3);
        TreeNode node5 = new TreeNode(5);
        TreeNode node7 = new TreeNode(7);
        TreeNode node10 = new TreeNode(10);
        TreeNode node15 = new TreeNode(15);
        TreeNode node18 = new TreeNode(18);

        node10.left = node5;
        node10.right = node15;

        node5.left = node3;
        node5.right = node7;

        node15.right = node18;


        System.out.println(day.rangeSumBST(node10, 7, 15));
    }


    public int rangeSumBST(TreeNode root, int low, int high) {
        return this.inorderTraversal2(root, low, high);
    }

    public int inorderTraversal(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        if (root.left != null) {
            sum = this.inorderTraversal(root.left, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum = sum + root.val;
        }
        if (root.right != null) {
            sum = sum + this.inorderTraversal(root.right, low, high);
        }
        return sum;
    }

    // 避免无效递归
    public int inorderTraversal2(TreeNode root, int low, int high) {
        if (root == null) {
            return 0;
        }
        int sum = 0;
        // 如果当前值大于最小值，才继续遍历左子树，否则左子树上的节点值肯定均小于low，为无效遍历
        if (root.val >= low) {
            if (root.left != null) {
                sum = sum + this.inorderTraversal2(root.left, low, high);
            }
        }
        if (root.val >= low && root.val <= high) {
            sum = sum + root.val;
        }
        // 同样，如果当前的值小于最大值，遍历右子树才有意义，否则右子树均为大于high的值，为无效遍历
        if (root.val <= high) {
            if (root.right != null) {
                sum = sum + this.inorderTraversal2(root.right, low, high);
            }
        }
        return sum;
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


