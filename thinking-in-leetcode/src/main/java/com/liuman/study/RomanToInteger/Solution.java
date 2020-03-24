package com.liuman.study.RomanToInteger;

import java.util.HashMap;
import java.util.Map;

/**
 * Example 1:
 *
 * Input: "III"
 * Output: 3
 * Example 2:
 *
 * Input: "IV"
 * Output: 4
 * Example 3:
 *
 * Input: "IX"
 * Output: 9
 * Example 4:
 *
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 *
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 *
 * https://blog.csdn.net/qq_33411180/article/details/82956238
 * https://www.bilibili.com/video/BV1XJ411z7CW?from=search&seid=9464146690964893016
 *
 * @Author: liuman
 * @Date: 2020-03-24 08:40
 *  * Symbol       Value         Symbol       Value         Symbol       Value
 *  * I             1            VI            6              IV           4
 *  * V             5            XI           11              IX           9
 *  * X             10           LX           60              XL           40
 *  * L             50           CX           110             XC           90
 *  * C             100          DC           600             CD           400
 *  * D             500          MC           1100            CM           900
 *  * M             1000
 */
public class Solution {

    public static void main(String[] args) {
//        String s = "III";
//        String s = "LVIII";
        //1000 - 100 + 1000 -10 + 100 - 1 + 5 = 1900 + 94 = 1994
        String s = "MCMXCIV";
        System.out.println(romanToInt(s));
    }

    /**
     * 解题思路：
     *       1、key-value键值对 HashMap将基础字符存储起来(或者尝试二维数组存储)
     *       2、数学运算，也就是算法的核心 也就是分析是做加法还是做减法
     *       3、计算最后一位，因为两两字符做相邻比较的时候，整个字符串的最后一位没有后续的字符了，没有办法做比较了，
     *          所以要单独计算最后一位是多少
     *       4、输出结果
     * @param s
     * @return
     */
    public static int romanToInt(String s) {
        int result = 0;

        Map<Character,Integer> cache = new HashMap<>();
        cache.put('I',1);
        cache.put('V',5);
        cache.put('X',10);
        cache.put('L',50);
        cache.put('C',100);
        cache.put('D',500);
        cache.put('M',1000);

        if (s.length() == 0) {
            return 0;
        }

        char[] arr = s.toCharArray();
        int i=0,j=1;
        for(;i<arr.length-1;i++,j++) {
            if (cache.get(arr[i]) >= cache.get(arr[j])) {
                result += cache.get(arr[i]);
            } else {
                result -= cache.get(arr[i]);
            }
        }
        System.out.println("final value of i:" + i);
        result += cache.get(arr[i]);

        return result;
    }
}
