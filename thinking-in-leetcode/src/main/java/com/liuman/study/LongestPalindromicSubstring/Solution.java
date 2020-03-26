package com.liuman.study.LongestPalindromicSubstring;

/**
 * https://www.bilibili.com/video/BV124411X7Ly?from=search&seid=9784874144549537460
 * https://www.bilibili.com/video/BV19J411H7Zn/?spm_id_from=trigger_reloads
 * @Author: liuman05
 * @Date: 2020-03-26 15:23
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "abababa";
//        String s = "abcddcb";
//        String s = "abbc";
        String s = "abcb";
        System.out.println(longestPalindrome(s));
    }

    /**
     * @param s
     * @return
     */
    public static String longestPalindrome(String s) {
        if (s == null || s.length()<1) return "";
        //start end 两个指针坐标都是字符串第一个字符

        //回文字符串的起始位置
        int start = 0;
        //回文字符串的终止位置
        int end = 0;

        for (int i=0; i<s.length();i++) {
            //分情况讨论
            //以一个字符为中心点
            int len1 = expandAroundCenter(s,i,i);

            //以当前的字符下标和它的下一个坐标点 两个下标为中心
            int len2 = expandAroundCenter(s,i,i + 1);

            int len = Math.max(len1,len2);
            //如果最新回文字符串的长度大于之前定位的回文字符串的长度
            if (len > end-start) {
                //len-1就是判断这个回文字符串是通过一个点为中心还是以两个点为中心,len-1可以很巧妙的解决这个问题
                start = i - (len - 1)/2;
                end = i + len/2;
            }
        }

        return s.substring(start,end+1);
    }

    private static int expandAroundCenter(String s, int left, int right) {
        //一定要注意好边界问题，对称相等是回文字符串的特征,这个中心点概念真的很关键
        while (left>=0 && right<s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        //ababa
        return right - left - 1;
    }
}
