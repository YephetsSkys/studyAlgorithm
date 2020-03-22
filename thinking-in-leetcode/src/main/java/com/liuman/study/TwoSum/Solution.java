package com.liuman.study.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * @author liuman
 * 1. Two Sum
 * 题意：返回数组中和为给定数的下标
 * 难度：Easy
 * 分类：Array, HashTable
 * 算法：题目说明了数组中一定有解，且解唯一，所以用哈希表记录已遍历的元素即可
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums = {2,7,11,15};
//        int[] nums = {1,7,11,8};
        int[] nums = {2,1,8,15};
        int target = 9;
        int[] result = twoSum(nums,target);
        System.out.println(result[0] + "," + result[1]);
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer,Integer> cache = new HashMap<>();

        int currentNum;
        for (int i=0; i<nums.length; i++) {
            currentNum = nums[i];
            int temp = target - currentNum;
            //如果HashMap缓存中存在 temp,说明之前迭代数据的时候已经存入 key->num的一个元素,value->为index下表值
            if (cache.containsKey(temp)) {
                    result[0] = cache.get(temp);
                    result[1] = i;

                    return result;
            }
            cache.put(currentNum,i);
        }

        return result;
    }
}
