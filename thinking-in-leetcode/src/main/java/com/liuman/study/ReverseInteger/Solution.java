package com.liuman.study.ReverseInteger;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 * Example 2:
 * Input: -123
 * Output: -321
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231, 231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @Author: liuman05
 * @Date: 2020-03-23 12:20
 */
public class Solution {

    public static void main(String[] args) {
        //2147483647
        System.out.println(Integer.MAX_VALUE / 10);

        //-2147483648
        System.out.println(Integer.MIN_VALUE / 10);


        System.out.println(-9%10);

        System.out.print("获取x的末尾数:");
        System.out.print(-123 % 10);

        System.out.println();
        int result = reverse(120);
        System.out.println("result:" + result);
    }

    /**
     * int的解释: https://zhidao.baidu.com/question/256678932.html
     * https://www.bilibili.com/video/av70120999?from=search&seid=10981046731083302151
     * 解题思路：1、拿出原数字的最后一位
     *         2、放在新数字的最前面
     * Note:当新数字在[-2^31——2^31-1]范围之外时,返回0
     * 也就是“-2147483648”到“2147483647”；
     */

    public static int reverse(int x) {
        //定义返回值变量，初始为0
        int rev = 0;
        //当x=0是反转也是0，所以只需迭代x!=0的情况
        while (x != 0) {
            //拿出最末尾的数
            int pop = x % 10;
            //原来的数x➗10 eg:120除以10 = 12
            x /= 10;
            //此时判断有没有越界
            if ((rev > Integer.MAX_VALUE /10) || (rev == Integer.MAX_VALUE / 10 && pop > 7)) {
                return 0;
            }

            if ((rev < Integer.MIN_VALUE / 10) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
                return 0;
            }

            rev = rev * 10 + pop;
        }
        return rev;
    }
}
