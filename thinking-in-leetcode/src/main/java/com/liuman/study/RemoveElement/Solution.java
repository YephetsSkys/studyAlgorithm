package com.liuman.study.RemoveElement;

/**
 * Remove Element
 *
 * 题目
 * Given an array nums and a value val, remove all instances of that value in-place and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 * **Example1: **
 *   Given nums = [3,2,2,3], val = 3,
 *   Your function should return length = 2, with the first two elements of nums being 2.
 *   It doesn't matter what you leave beyond the returned length.
 * **Example2: **
 *   Given nums = [0,1,2,2,3,0,4,2], val = 2,
 *   Your function should return length = 5, with the first five elements of nums containing 0, 1, 3, 0, and 4.
 *   Note that the order of those five elements can be arbitrary.
 *   It doesn't matter what values are set beyond the returned length.
 *
 * 思路
 * 题目要求不使用额外的空间，移除所有数值等于val的元素，返回新数组的长度，于是想到使用替换的方法。
 * 将数组中数值等于val的元素与数组最后一个元素互换，再将最后一个元素删除。这样就完成了一个删除数值等于val元素的操作
 *
 * @Author: liuman
 * @Date: 2020-03-26 17:31
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {1,3,2,2,3};
        int val = 3;
        int result = removeElement(nums,val);

        System.out.println("result:" + result);
    }

    public static int removeElement(int[] nums,int val) {
        int i = 0;
        int j = 0;
        //一定要注意数组越界问题
        while (i < nums.length && j < nums.length) {
            //如果i下标从0开始,一直移动到!=要移除的元素的下标
            while (i < nums.length && nums[i] != val) {
                //指针i++
                i++;
            }

            while(j < nums.length && (j<=i || nums[j] == val)) {
                j++;
            }

            if (i < nums.length && j < nums.length) {
                swap(nums,i,j);
            }
        }

        return i;
    }

    private static void swap(int[] nums,int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
