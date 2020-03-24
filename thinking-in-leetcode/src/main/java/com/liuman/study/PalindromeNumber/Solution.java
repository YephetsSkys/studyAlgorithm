package com.liuman.study.PalindromeNumber;

/**
 * https://blog.csdn.net/regemc/article/details/79698015
 * https://www.bilibili.com/video/BV1RJ411E7Y1?from=search&seid=2254766894588716839
 * @Author: liuman05
 * @Date: 2020-03-24 19:59
 *
 *
 *
 *
 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
 *
 * Example 1:          Input: 121            Output: true
 *
 * Example 2:          Input: -121          Output: false                Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
 *
 * Example 3:         Input: 10              Output: false                Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 *
 * Follow up: Coud you solve it without converting the integer to a string?
 */
public class Solution {

    public static void main(String[] args) {
        System.out.println("121:" + isPalindromeNumber(121));
        System.out.println("-121:" + isPalindromeNumber(-121));
        System.out.println("0:" + isPalindromeNumber(0));
        System.out.println("34543:" + isPalindromeNumber(34543));
        System.out.println("12133121:" + isPalindromeNumber(12133121));
    }

    /**
     * 判断是不是数字是不是回文串
     * 解题思路:
     * @return
     */
    public static boolean isPalindromeNumber(int x) {
        //x为0肯定是回文
        if (x == 0) {
            return true;
        }

        //如果x小于0有一个 - 号 肯定不会对称 就不是回文
        if (x < 0) {
            return  false;
        }

        //因为数字不能以0开头，如果该数字能够被10整除，那肯定是10的倍数，个位数就是0,不对称也不是回文
        if (x % 10 == 0) {
            return false;
        }

        //剩余的case就是把输入要校验的数字分成两半，bun变量是记录从个位反推的数字值
        int num = 0;
        while (num < x) {
            num = num * 10 + x % 10;
            x /= 10;
        }

        //num == x是输入验证的数字为偶数
        //num / 10是输入验证的数字是奇数
        return (num == x) || (num / 10 == x);
    }
}
