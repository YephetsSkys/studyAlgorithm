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
public class Solution3 {

    public static void main(String[] args) {
        String[] s1 = {"flower","flow","flight"};
        String[] s2 = {"dog","racecar","car"};
        String[] s3 = {"c"};
        System.out.println("s1:" + longestCommonPrefix(s1));
        System.out.println("s2:" + longestCommonPrefix(s2));
        System.out.println("s3:" + longestCommonPrefix(s3));
    }

    /**
     * 解题思路:1、将整体拆分
     *         2、计算左右两边的结果（利用递归）
     *         3、计算左右两半部分结果的结果
     */
    public static String longestCommonPrefix(String[] strs) {
        //比较复杂 由于时间原因 后续再补充上 只是了解一下 看一下资料

        return "";
    }
}
