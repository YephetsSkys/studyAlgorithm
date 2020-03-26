package com.liuman.study.MedianofTwoSortedArrays;

/**
 * https://www.bilibili.com/video/BV1VE411D7k1?from=search&seid=15346769065666534573
 *
 * [LeetCode] 4. Median of Two Sorted Arrays 两个有序数组的中位数
 *
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 * @Author: liuman05
 * @Date: 2020-03-25 23:05
 */
public class Solution {

    public static void main(String[] args) {
//        int[] nums1 = {1,3};
//        int[] nums2 = {2};

//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};

        int[] nums1 = {1,2,5};
        int[] nums2 = {3,4};
        double result = findMidianSortedArrays(nums1,nums2);
        System.out.println("result:" + result);
    }

    /**
     * 这个有问题 暂时不考虑
     * 解题思路:Binary Search(二分法) O(log(n))
     *
     */
    private static double findMidianSortedArrays(int[] nums1,int[] nums2) {
        int length = nums1.length + nums2.length;
        //如果两个数组里的数的总个数(length)为奇数
        if (length % 2 == 1) {
            int mid = length / 2 + 1;
            return findKthSmallest(mid,nums1,nums2);
        } else {//如果两个数组里的数的总个数(length)为偶数
            int mid1 = length/2;
            int mid2 = length/2 + 1;
            return (findKthSmallest(mid1,nums1,nums2) + findKthSmallest(mid2,nums1,nums2))/2.0;
        }
    }

    /**
     * 找到两个排好序的数组中的第k小的数
     * @param k
     * @param nums1
     * @param nums2
     * @return
     */
    private static int findKthSmallest(int k, int[] nums1,int[] nums2) {
        if (nums1.length == 0) return nums2[k-1];
        if (nums2.length == 0) return nums1[k-1];
        //两个array中的最小值
        int start = Math.min(nums1[0],nums2[0]);
        //两个array中的最大值
        int end = Math.max(nums1[nums1.length-1],nums2[nums2.length-1]);

        while (start+1 < end) {
            int mid = start + (end - start)/2;
            if (countSmallOrEqual(mid,nums1) + countSmallOrEqual(mid,nums2) < k) {
                start = mid;
            } else {
                end = mid;
            }
        }
        if (countSmallOrEqual(start,nums1) + countSmallOrEqual(start,nums2) >=k) {
            return start;
        } else {
            return end;
        }
    }

    private static int countSmallOrEqual(int num,int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start + 1 < end) {
            int mid = start + (start-end)/2;
            if (arr[mid] <= num) start = mid;
            else end = mid;
        }
        if (arr[start] > num) return start;
        if (arr[end] > num) return end;
        return arr.length;
    }

}
