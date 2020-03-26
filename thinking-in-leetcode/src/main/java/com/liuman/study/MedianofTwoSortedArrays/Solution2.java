package com.liuman.study.MedianofTwoSortedArrays;

/**
 * @Author: liuman
 * @Date: 2020-03-26 11:39
 */
public class Solution2 {

    public static void main(String[] args) {
//        int[] nums1 = {1,3};
//        int[] nums2 = {2};

//        int[] nums1 = {1,2};
//        int[] nums2 = {3,4};

//        int[] nums1 = {1,2,5};
//        int[] nums2 = {3,4};

//        int[] nums1 = {1,2,5,7,9};
//        int[] nums2 = {3,4};

        int[] nums1 = {3,4};
        int[] nums2 = {1,2,5,7,9};
        //1,2,3,4,5,7,9
        double result = findMedianSortedArrays(nums1,nums2);
        System.out.println("result:" + result);
    }

    private static double findMedianSortedArrays(int[] nums1,int[] nums2) {
        int size1 = nums1.length;
        int size2 = nums2.length;
        //假如nums1的数组长度大于nums2的数组长度,那么要置换查找方法参数的位置
        if (size1 > size2) {
            return findMedianSortedArrays(nums2,nums1);
        }

        int low = 0;
        //数组长度端的值
        int high = nums1.length;
        //=很重要
        while (low <=high) {
            int i = (low+high)/2;
            int j = (size1+size2+1)/2 - i;
            if (i>0 && nums1[i-1]>nums2[j]) {
                high = i - 1;
            } else if (i<size1 && nums2[j-1]>nums1[i]) {
                low = i + 1;
            } else {
                int l,r;
                //如果i=0，说明该数组只有1个元素
                if (i == 0) {
                    l = nums2[j-1];
                } else if (j==0) {
                    l = nums1[i-1];
                } else {
                    l = Math.max(nums1[i-1],nums2[j-1]);
                }

                //一共是奇数个
                if ((size1 + size2) % 2 == 1) {
                    //中间数字就是中位数
                    return l;
                }

                if (i==size1) {
                    r = nums2[j];
                } else if (j == size2) {
                    r = nums1[i];
                } else {
                    r = Math.min(nums1[i],nums2[j]);
                }

                return (l + r) * 1.0 /2;
            }
        }

        return -1;
    }
}
