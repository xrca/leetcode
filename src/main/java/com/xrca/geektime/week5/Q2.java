package com.xrca.geektime.week5;

import java.util.*;

// 排序链表 https://leetcode-cn.com/problems/sort-list/
public class Q2 {

    public static void main(String[] args) {
        Q2 q2 = new Q2();
        ListNode node = new ListNode(4);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(1);
        ListNode node4 = new ListNode(3);
        node.next = node2;
        node2.next = node3;
        node3.next = node4;

        ListNode rnode = new ListNode(4);
        ListNode rnode2 = new ListNode(2);
        ListNode rnode3 = new ListNode(1);
        ListNode rnode4 = new ListNode(3);
        rnode.next = rnode2;
        rnode2.next = rnode3;
        rnode3.next = rnode4;
        ListNode result = q2.sortList2(node);
        System.out.println(result);
    }

    public ListNode sortList(ListNode head) {
        List<ListNode> list = new ArrayList<>();
        while (head != null) {
            list.add(head);
            head = head.next;
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.val));
        ListNode resultNode = null, lastNode = null;
        for (ListNode node : list) {
            node.next = null;
            if (lastNode == null) {
                resultNode = node;
            } else {
                lastNode.next = node;
            }
            lastNode = node;
        }
        return resultNode;
    }

    public ListNode sortList2(ListNode head) {
        return mergeSort(head);
    }

    // 归并排序
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode slow = head, fast = head.next.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = mergeSort(slow.next);
        // 断开连接
        slow.next = null;
        ListNode left = mergeSort(head);
        return mergeList(left, right);
    }

    // 合并list
    public ListNode mergeList(ListNode left, ListNode right) {
        ListNode tmpHead = new ListNode(), currentHead = tmpHead;
        while (left != null && right != null) {
            if (left.val <= right.val) {
                currentHead.next = left;
                currentHead = left;
                left = left.next;
            } else {
                currentHead.next = right;
                currentHead = right;
                right = right.next;
            }
        }
        if (left != null) {
            currentHead.next = left;
        }
        if (right != null) {
            currentHead.next = right;
        }
        return tmpHead.next;
    }

    // 节点
    public static class ListNode {
        int val;

        ListNode next;

        ListNode() {}

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val; this.next = next;
        }

        @Override
        public String toString() {
            return this.val + (next == null ? "" : " -> " + next.toString());
        }
    }
}
