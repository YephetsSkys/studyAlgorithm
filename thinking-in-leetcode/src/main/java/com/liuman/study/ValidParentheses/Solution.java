package com.liuman.study.ValidParentheses;

import java.util.Stack;

/**
 * Valid Parentheses
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 *
 * 示例 1:
 *
 * 输入: "()"
 * 输出: true
 * 示例 2:
 *
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 *
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 *
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 *
 * 输入: "{[]}"
 * 输出: true
 *
 * @Author: liuman
 * @Date: 2020-03-25 17:10
 */
public class Solution {

    public static void main(String[] args) {
        String s1 = "()";
        System.out.println("s1:" + isValid(s1));

        String s2 = "()[]{}";
        System.out.println("s2:" + isValid(s2));

        String s3 = "(]";
        System.out.println("s3:" + isValid(s3));

        String s4 = "([)]";
        System.out.println("s4:" + isValid(s4));

        String s5 = "{[]}";
        System.out.println("s5:" + isValid(s5));

    }

    public static boolean isValid(String s) {
        //将该字符串专程字符数组
        char[] chars = s.toCharArray();
        //创建一个栈类，先进后出
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            //当前字符如果括号的左半边，则放入栈中
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                //如果栈是空的，说明起始的时候入栈字符没有左半括号，肯定是不符合规则的
                if (stack.isEmpty()) {
                    return false;
                }

                //自己画图演示最容易理解了
                if (c == ')' && stack.pop() != '(') {
                    return false;
                }

                if (c == ']' && stack.pop() != '[') {
                    return false;
                }

                if (c == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        //栈的元素匹配的话就会全部弹出
        return stack.isEmpty();
    }
}
