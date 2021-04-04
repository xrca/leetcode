package com.xrca.geektime.week2;

import java.util.List;

//反转链表 https://leetcode-cn.com/problems/reverse-linked-list/
public class Q2 {
    public static void main(String[] args) {
        ListNode rootNode = new ListNode(1);
        ListNode currentNode = rootNode;
        currentNode.next = new ListNode(2);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(3);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(4);
        currentNode = currentNode.next;
        currentNode.next = new ListNode(5);
        Q2 q2 = new Q2();
        System.out.println(q2.reverseList(rootNode));
    }

    public ListNode reverseList(ListNode head) {
        ListNode lastNode = null, currentNode = null;
        while (head != null) {
            // 上一个节点为上一次的当前节点
            lastNode = currentNode;
            currentNode = head;
            // 向后移动
            head = head.next;
            // 当前节点的下个节点应该变为上一个节点
            currentNode.next = lastNode;
        }
        return currentNode;
    }

}
