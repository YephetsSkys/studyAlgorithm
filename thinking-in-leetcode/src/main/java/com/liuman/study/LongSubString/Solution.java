package com.liuman.study.LongSubString;

/**
 * 分析：https://www.iteye.com/blog/kainever7-2219238
 * https://www.bilibili.com/video/av10327259?from=search&seid=13472319614821732280
 * @Author: liuman
 * @Date: 2020-03-23 10:04
 */

/**
Given a string, find the length of the longest substring without repeating characters.
        Example 1：
         Input："abcabcbb"
          Output：3
         Explanation：The answer is "abc",with the length of 3.
        Example 2：
         Input："bbbb"
         Output：1
         Explanation：The answer is "b",with the length of 1.
        Example 3：
         Input："pwwkew"
         Output：3
         Explanation：The answer is "wke",with the length of 3.
                   Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "aklgsdgsdg";
//        String s = "abcabcbb";
//        String s = "bbbb";
//        String s = "pwwkew";
//        String s = "abcgaa";
        String s = "abcdeahm";
        System.out.println(lengthOfLongestSubString(s));
    }

    public static int lengthOfLongestSubString(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        int left=0,right=0;
        int n = s.length();
        //大小写字母对应的ASCII是0-127  a-z：97-122，A-Z：65-90，0-9：48-57。
        boolean[] used = new boolean[128];
        //最终的结果
        int max = 0;
        //从0开始扫过每一个字符
        while (right < n) {
            //如果当前访问的元素没有在子字符串中出现过
            if (used[s.charAt(right)] == false) {
                //访问过后，设置为true
                used[s.charAt(right)] = true;
                //指针右移即移动right指针
                right++;
            } else {//假如访问的当前元素在曾经的子字符串出现过,那么当前元素前面的right-left个字符就组成了一个子字符串
                //出现重复的字符后,即可以确定一个子字串,从而比较该字串的最大长度与当前的max做比较获得当前最大数max
                max = Math.max(max,right-left);
                //移动left指针，直到指向和right指针指向的元素一样才停止
                while (left < right && s.charAt(right) != s.charAt(left)) {
                    used[s.charAt(left)] = false;
                    left++;
                }
                //因为right指针当前指向的元素是下一个字串中的一个元素,left和right指针指向的元素是同一个的时候,开始各自右移一位
                left++;
                right++;
            }
        }
        max = Math.max(max,right-left);
        return max;
    }
}
