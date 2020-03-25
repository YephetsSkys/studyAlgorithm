package com.liuman.study.RemoveDuplicatesFromSortedArray;

/**
 * Remove Duplicates from Sorted Array
 *
 * Example 1:
 *
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn’t matter what you leave beyond the returned length.
 *
 * Example 2:
 *
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn’t matter what values are set beyond the returned length.
 *
 * https://blog.csdn.net/xiaoguaihai/article/details/84434704
 * https://www.cnblogs.com/Anonym077/p/10527176.htmls
 * @Author: liuman05
 * @Date: 2020-03-25 20:55
 *
 * 记住快慢指针的使用
 */
public class Solution {

    public static void main(String[] args) {
        int[] nums = {0,0,1,1,1,2,2,3,3,4};
        int result = removeDuplicates(nums);

        System.out.println("--------------");
        System.out.println("result:" + result);
    }

    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        //当在慢指针所在下标的元素与快指针所在下标的元素值不相等的时候会移动一位即+1
        int slow = 0;
        //快指针每一次都会移动移位即+1
        int fast = 1;
        for (;fast<nums.length;fast++) {
            //如果快指针所在下标的值不等于慢指针所在下标的值
            if (nums[fast] != nums[slow]) {
                System.out.println("before:" + slow);
                //慢指针+1
                slow++;
                System.out.println("after:" + slow);
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
