package com.liuman.study.LongSubString;

import java.util.HashMap;

/**
 * @Author: liuman
 * @Date: 2020-03-23 10:52
 */
public class Solution2 {

    public static void main(String[] args) {
//        String s = "abcmd";
//        String s = "abamd";
        String s = "abcdeahm";

        System.out.println(lengthOfLongestSubString(s));
    }

    public static int lengthOfLongestSubString(String s) {
        HashMap<Character,Integer> cache = new HashMap<>();
        int max = 0;
        int j = 0;
        for (int i=0; i< s.length(); i++) {
            //如果包含该字符,说明该index下出现重复的数字了
            char temp = s.charAt(i);
            if (cache.containsKey(temp)) {
                //当出现重复字符的时候，就要通过这个巧妙的公式向前移动一位。
                //从而可以获得一个新的子字符串
                j = Math.max(cache.get(temp)+1,j);
            }

            //比对每次获得的字串的长度
            max = Math.max(i-j+1,max);
            cache.put(temp,i);
        }

        return max;
    }

}
