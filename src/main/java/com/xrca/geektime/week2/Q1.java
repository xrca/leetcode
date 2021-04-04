package com.xrca.geektime.week2;

// 两数相加 https://leetcode-cn.com/problems/add-two-numbers/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        ListNode node1 = new ListNode(2);
        ListNode cnode = node1;
        ListNode node2 = new ListNode(5);
        System.out.println(q1.addTwoNumbers(node1, node2));
    }

    // 思路：首先想到的是，按v1 * 1 + v2 * 10 + v3 * 100 + ...去计算每一个数的值，但是其值可能超过long的最大值，所以不能使用此方式，这也是为什么题目最后要求使用listnode输出的原因
    // 那就按照最基础的思路去做，按照小学两数相加去做，从低位计算，超过十就进一位
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // 记录当前两个node的和
        int nodeSum = 0;
        // 记录上次两个node的和是否超过10
        int gt10 = 0;
        ListNode rootNode = new ListNode();
        ListNode currentNode = rootNode;
        while (l1 != null || l2 != null) {
            // 两数之和 + 前两位数之和的进位
            nodeSum = (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0) + gt10;
            // 记录上次两个node的和是否超过10
            gt10 = nodeSum >= 10 ? 1 : 0;
            currentNode.next = new ListNode(nodeSum % 10);
            currentNode = currentNode.next;
            l1 = l1 != null ? l1.next : null;
            l2 = l2 != null ? l2.next : null;
        }
        // 判断全部计算结束后是否还有进位的数
        if (gt10 > 0) {
            currentNode.next = new ListNode(gt10);
        }
        return rootNode.next;
    }
}
