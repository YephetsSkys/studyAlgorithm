package com.liuman.study.ImplementStrStr;

/**
 * 28. Implement strStr()
 * 题意：找出子串在给定字符串的起始位置
 * 双指针的应用要记牢
 * @Author: liuman05
 * @Date: 2020-03-26 21:37
 */
public class Solution {

    public static void main(String[] args) {
        String haystack = "addffaa";
        String needle = "dff";
        int result = strStr(haystack,needle);
        System.out.println("result:" + result);
    }

    public static int strStr(String haystack,String needle) {
        //特殊情况判断
        if (needle.length() == 0) return 0;
        if (haystack == null || haystack.length() == 0) return -1;

        //cur1指针指向haystack字符串的字符index
        int cur1 = 0;
        //cur2指针指向needle字符串的字符index
        int cur2 = 0;

        //编写算法第一步就是要写出限定条件，防止越界
        while (cur1 < haystack.length()) {
            //当有一个字符相等时,abcde / ab这种一直进入if判断的是一种情况
            if (haystack.charAt(cur1) == needle.charAt(cur2)) {
                //cur1指针+1，索引下标指向下一个元素
                cur1++;
                //cur2指针+1，索引下标指向下一个元素
                cur2++;
                if (cur2 == needle.length()) {
                    return cur1 - cur2;
                }
            } else {
                //两种情况： 1、一直都没有一个字符相等
                //          2、前面有字符相等，但是此时的指针不相等了
                //一旦定位到有字符不相同的情况，cur1的指针继续右移
                cur1++;
                cur1 = cur1 - cur2;
                //一旦定位到有字符不相同的情况，cur2的指针要重置为index=0
                cur2 = 0;
            }
        }

        return -1;
    }
}
