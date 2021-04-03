package com.xrca.huawei;

import java.util.Scanner;
import java.util.Stack;

// https://www.nowcoder.com/practice/9999764a61484d819056f807d2a91f1e?tpId=37&tqId=21273&rp=1&ru=%2Fta%2Fhuawei&qru=%2Fta%2Fhuawei%2Fquestion-ranking&tab=answerKey
public class HJ50 {
    //[‘0’-‘9’],‘+’,‘-’, ‘*’,‘/’ ,‘(’， ‘)’,‘[’, ‘]’,‘{’ ,‘}’
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        char[] expressionArray = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : expressionArray) {
            stack.push(c);
        }

        Stack<Character> outStack = new Stack<>();
        while (!stack.empty()) {
            char c = stack.pop();
            if ("([{".contains(String.valueOf(c))) {
                Stack<Character> calcStack = new Stack<>();
                while (!outStack.empty()) {
                    char cc = outStack.pop();
                    // 取出一个完整表达式
                    if (")]}".contains(String.valueOf(cc))) {
                        char[] charArr = calc(calcStack);
                        for (char ca : charArr) {
                            stack.push(ca);
                        }
                        calcStack.clear();
                        break;
                    } else {
                        calcStack.push(cc);
                    }
                }
            } else {
                outStack.push(c);
            }
        }
        if (outStack.size() == 1) {
            System.out.println(outStack.pop());
        } else {
            Stack<Character> calcStack = new Stack<>();
            while (!outStack.empty()) {
                calcStack.push(outStack.pop());
            }
            char[] result = calc(calcStack);
            System.out.println(result);
        }
    }

    // 计算无括号表达式
    public static char[] calc(Stack<Character> stack) {
        Stack<Character> outStack = new Stack<>();
        while (!stack.empty()) {
            char c = stack.pop();
            if ('*' == c || '/' == c) {
                int num1 = getNumber(stack, true);
                int num2 = getNumber(outStack, false);
                calcAndPush(num1, num2, outStack, c);
            } else {
                outStack.push(c);
            }
        }
        while (!outStack.empty()) {
            stack.push(outStack.pop());
        }
        while (!stack.empty()) {
            char c = stack.pop();
            if ('+' == c || '-' == c) {
                int num1 = getNumber(stack, true);
                int num2 = getNumber(outStack, false);
                calcAndPush(num1, num2, outStack, c);
            } else {
                outStack.push(c);
            }
        }
        char[] arr = new char[outStack.size()];
        int i = 0;
        while (!outStack.empty()) {
            arr[i] = outStack.pop();
            i++;
        }
        return arr;
    }

    // 计算并进栈
    public static void calcAndPush(int num1, int num2, Stack<Character> stack, char op) {
        int result = 0;
        if (op == '*') {
            result = num1 * num2;
        } else if (op == '/') {
            result = num1 / num2;
        } else if (op == '+') {
            result = num1 + num2;
        } else {
            result = num1 - num2;
        }
        char[] charArr = String.valueOf(result).toCharArray();
        for (int i = charArr.length - 1; i >= 0; i--) {
            stack.push(charArr[i]);
        }
    }

    // 从中获取一个完整的整数
    public static int getNumber(Stack<Character> stack, boolean out) {
        StringBuilder sb = new StringBuilder();
        while (!stack.empty()) {
            char c = stack.peek();
            if ("0123456789".contains(String.valueOf(c))) {
                sb.append(stack.pop());
            } else if ('-' == c) {
                stack.pop();
                if (stack.isEmpty() || "([{".contains(String.valueOf(stack.peek()))) {
                    sb.append('-');
                } else {
                    stack.push('-');
                }
            }else {
                break;
            }
        }
        if (out) {
            return Integer.valueOf(sb.reverse().toString());
        } else {
            return Integer.valueOf(sb.toString());
        }
    }
}
