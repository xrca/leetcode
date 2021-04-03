package com.xrca.huawei.exam;

import java.util.Scanner;
import java.util.Stack;

// 给定一个只包含( [ { } ] )的字符串，请判断是否是合法括号格式，若不合法返回-1,；若合法，返回括号的最大深度
public class T1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = in.nextLine();

        char[] arr = str.toCharArray();
        if (arr.length == 0 || arr.length % 2 != 0) {
            System.out.println(0);
            return;
        }
        //将字符串入栈
        Stack<String> stack = new Stack<>();
        for (char c : arr) {
            stack.push(String.valueOf(c));
        }
        Stack<String> outStack = new Stack<>();
        // 先拿出一个
        outStack.push(stack.pop());
        String top = null;
        int maxDepth = 1;
        while (!stack.isEmpty()) {
            top = stack.pop();
            if (!outStack.isEmpty() && "()[]{}".contains(top + outStack.peek())) {
                outStack.pop();
            } else {
                outStack.push(top);
            }
            // 判断出栈元素达到的最大深度
            if (outStack.size() > maxDepth) {
                maxDepth = outStack.size();
            }
        }
        if (!stack.isEmpty() || !outStack.isEmpty()) {
            System.out.println(0);
        } else {
            System.out.println(maxDepth);
        }
    }
}
