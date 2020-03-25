package com.liuman.study.LongestCommonPrefix;

/**
 * 解析：https://www.bilibili.com/video/BV1oJ411q7Fx?from=search&seid=16876098776176501996
 * @Author: liuman05
 * @Date: 2020-03-24 22:14
 *
 *
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string "".
 *
 * Example 1:
 *
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 *
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 *
 * Example 3:
 * Input: ["c"]
 * Output: "c"
 *
 * Explanation: There is no common prefix among the input strings.
 * Note:
 *
 * All given inputs are in lowercase letters a-z.
 */
public class Solution2 {

    public static void main(String[] args) {
        String[] s1 = {"flower","flow","flight"};
        String[] s2 = {"dog","racecar","car"};
        String[] s3 = {"c"};
        System.out.println("s1:" + longestCommonPrefix(s1));
        System.out.println("s2:" + longestCommonPrefix(s2));
        System.out.println("s3:" + longestCommonPrefix(s3));
    }

    /**
     * 解题思路:1、处理特殊情况(如果为空或者一个字符串元素) 直接返回
     *         2、从后往前，比较第一个前缀字符串和后面是否相等
     *         3、输出结果
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        String first = strs[0];
        for (int i=1; i<strs.length; i++) {
            while (strs[i].indexOf(first) != 0) {
                first = first.substring(0,first.length() - 1);
                if (first.isEmpty()) {
                    return "";
                }
            }
        }
        return first;
    }
}
