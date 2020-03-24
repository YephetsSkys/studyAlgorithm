package com.liuman.study.StringToInteger;

/**
 * 理解: https://www.cnblogs.com/king-lps/p/10679121.html
 * https://www.bilibili.com/video/BV1mE411Z7jh?from=search&seid=592963087638018679
 *
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。
 * 如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
 *
 * 示例 1:
 *
 * 输入: "42"
 * 输出: 42
 * 示例 2:
 *
 * 输入: "   -42"
 * 输出: -42
 * 解释: 第一个非空白字符为 '-', 它是一个负号。
 *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
 * 示例 3:
 *
 * 输入: "4193 with words"
 * 输出: 4193
 * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
 * 示例 4:
 *
 * 输入: "words and 987"
 * 输出: 0
 * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
 *      因此无法执行有效的转换。
 * 示例 5:
 *
 * 输入: "-91283472332"
 * 输出: -2147483648
 * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
 *      因此返回 INT_MIN (−231)
 * @Author: liuman05
 * @Date: 2020-03-24 11:29
 */
public class Solution {

    public static void main(String[] args) {
        String s1 = "   -42";
        String s2 = "4193 with words";
        String s3 = "words and 987";
        String s4 = "-91283472332";
        System.out.println("s1:" + myAtoi(s1));
        System.out.println("s2:" + myAtoi(s2));
        System.out.println("s3:" + myAtoi(s3));
        System.out.println("s4:" + myAtoi(s4));
    }

    /**
     * 解题思路: 1、找到一个不是空白的字符
     *          2、如果第一个字符是 '+' 或者 '-'，记录下正负号
     *          3、查看每一位，如果是数字的话就记录下来，直到出现第一个不是数字的字符
     * Note:如果一上来就不是'+'或者'-'或者数字，返回0
     *      如果数字超过32位的话，返回INT_MAX或INT_MIN
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        //如果字符串为空 返回0
        if (str == null) return 0;

        //如果字符串不为空,把字符串的前后空格去掉
        str = str.trim();
        //去掉空格后的字符串如果长度为0则返回0
        if (str.length() == 0) return 0;

        //sign变量是为了记录正负号(1：+ 或者 -1：-)
        int sign = 1;

        //index从0开始迭代字符串每一个字符
        int index = 0;

        //第一个字符如果是 + 号开始
        if (str.charAt(index) == '+') {
            //index++往后移动一位
            index++;
        } else if (str.charAt(index) == '-') { //第一个字符如果是 - 号开始
            //-1 表示是负数
            sign = -1;
            //index++往后移动一位
            index++;
        }

        //long的取值范围比int要大很多，这样可以判断出输入的字符串数字是否超过了int的取值范围
        long num = 0;

        //开始从非 + 或者 - 的字符迭代
        for(; index < str.length();index++) {
            //当第一个字符就不是数字的时候，直接跳出循环
            if (str.charAt(index) < '0' || str.charAt(index) > '9') break;

            //如果扫描的字符是数字的话就开始，这个公式就是计算数字字符串如果变成对应的数字类型的公式，一定要记住
            num = num * 10 + (str.charAt(index) - '0');

            //如果通过迭代公式获得数字大于Integer的最大值,则需要终止循环
            if (num > Integer.MAX_VALUE) break;
        }

        //边界判断
        if (num * sign > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num * sign < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else {
            //long的num强转成int获得结果
            return (int)num * sign;
        }
    }
}
