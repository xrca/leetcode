package com.xrca.geektime.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

// 计算器 https://leetcode-cn.com/problems/calculator-lcci/
public class Q1 {
    public static void main(String[] args) {
        Q1 q1 = new Q1();
        //System.out.println(q1.calculate2("32+20*12"));
        //System.out.println(q1.calculate2(" 3/2 "));
        //System.out.println(q1.calculate2(" 3+5 / 2 "));
        System.out.println(q1.calculate2(" 3 + 12 / 5 + 30 -  20 / 2 * 31 "));
        //System.out.println(q1.calculate2("1+1"));
        System.out.println(q1.calculate2("1-1+1"));
        System.out.println(q1.calculate2("1*1*2"));
        //System.out.println(q1.calculate2("1*1"));
        //System.out.println(q1.calculate2("1/1"));
        //System.out.println(q1.calculate2("1"));
    }

    public int calculate2(String s) {
        char[] arr = s.toCharArray();
        // 将数字与操作符分开，数字的个数比操作数多一个
        List<Integer> numList = new ArrayList<>();
        List<Character> opList = new ArrayList<>();
        StringBuilder sb;
        for (int i = 0; i < arr.length;) {
            if (arr[i] == ' ') {
                i++;
            } else if (arr[i] == '+' || arr[i] == '-' || arr[i] == '*' || arr[i] == '/') {
                opList.add(arr[i]);
                i++;
            } else {
                sb = new StringBuilder();
                int j = i;
                for (; j < arr.length; j++) {
                    if ("0123456789".indexOf(arr[j]) >= 0) {
                        sb.append(arr[j]);
                    } else {
                        break;
                    }
                }
                i = j;
                numList.add(Integer.valueOf(sb.toString()));
            }
        }
        // 按照计算表从右到左推入栈中（从栈中取出的时候即为表达式正常顺序），并计算乘除法
        Stack<Integer> numStack = new Stack<>();
        Stack<Character> opStack = new Stack<>();
        Stack<Integer> leftNumStack = new Stack<>();
        Stack<Character> leftOpStack = new Stack<>();
        for (int i = numList.size() - 1; i >= 0; i--) {
            numStack.push(numList.get(i));
        }
        for (int i = opList.size() - 1; i >= 0; i--) {
            opStack.push(opList.get(i));
        }
        leftNumStack.push(numStack.pop());
        while (!opStack.isEmpty()) {
            Character op = opStack.pop();
            // 加减法，直接把数字和符号入栈
            if (op == '+' || op == '-') {
                leftNumStack.push(numStack.pop());
                leftOpStack.push(op);
            } else {
                // 乘除法，计算完成后，将计算结果入栈
                int result;
                if (op == '*') {
                    result = leftNumStack.pop() * numStack.pop();
                } else {
                    result = leftNumStack.pop() / numStack.pop();
                }
                leftNumStack.push(result);
            }
        }
        // 计算加减法，
        int result;
        if (!leftOpStack.isEmpty()) {
            // 反转栈中的元素，变成有序计算，因为有减法存在，所有不能逆序计算
            opStack.clear();
            numStack.clear();
            while (!leftOpStack.isEmpty()) {
                opStack.push(leftOpStack.pop());
            }
            while (!leftNumStack.isEmpty()) {
                numStack.push(leftNumStack.pop());
            }
            result = numStack.pop();
            while (!opStack.isEmpty()) {
                char op = opStack.pop();
                if (op == '+') {
                    result = numStack.pop() + result;
                } else {
                    result = result - numStack.pop();
                }
            }
        } else {
            result = leftNumStack.pop();
        }
        return result;
    }
}
