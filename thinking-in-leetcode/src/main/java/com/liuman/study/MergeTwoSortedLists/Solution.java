package com.liuman.study.MergeTwoSortedLists;

import com.liuman.study.SingleLinkedList.ListNode;

/**
 * Merge Two Sorted Lists
 *
 * Merge two sorted linked lists and return it as a new list.
 * The new list should be made by splicing together the nodes of the first two lists.
 *
 * Example:
 *
 * Input: 1->2->4, 1->3->4
 * Output: 1->1->2->3->4->4
 * 和88. Merge Sorted Array类似，数据结构不一样，这里是合并链表。
 *
 * 由于是链表，不能像数组一样有从后面往前写的技巧。
 *
 * 解法1：dummy list，新建一个链表，然后两个链表中从头各取一个元素进行比较，小的写入新链表，直到结束，返回dummy.next。
 *
 * 解法2：recursion，代码简洁，但空间复杂度高O(n)
 * https://www.cnblogs.com/lightwindy/p/8503688.html
 * https://www.bilibili.com/video/BV1D7411Y7Cz?from=search&seid=2245307413881452572
 *
 * @Author: liuman
 * @Date: 2020-03-25 18:01
 */
public class Solution {

    public static void main(String[] args) {
        int[] datas1 = {1,2,4};
        int[] datas2 = {1,3,4};

        ListNode head1 = initList(datas1);
        System.out.print("head1:");
        printInfo(head1);

        System.out.println();

        ListNode head2 = initList(datas2);
        System.out.print("head2:");
        printInfo(head2);

        System.out.println();

        ListNode result = mergeTwoSortedLists(head1,head2);
        System.out.print("result:");
        printInfo(result);
    }

    public static void printInfo(ListNode head) {
        ListNode cur = head;
        while (cur != null) {
            if (cur.next != null) {
                System.out.print(cur.data + "->");
            } else {
                System.out.print(cur.data);
            }
            cur = cur.next;
        }
    }

    public static ListNode initList(int[] datas) {
        if (datas.length == 0) {
            return null;
        }
        ListNode head = new ListNode(datas[0]);
        ListNode cur = head;
        for (int i=1; i<datas.length;i++) {
            cur.next = new ListNode(datas[i]);
            cur = cur.next;
        }

        return head;
    }

    public static ListNode mergeTwoSortedLists(ListNode l1, ListNode l2) {
        //创建dummy结点 为了能够更方便的找到head结点
        ListNode dummy = new ListNode(0);
        //cur变量为了将两个链表关联起来
        ListNode cur = dummy;

        //链表1和链表2都不为空
        while (l1 != null && l2 != null) {
            //如果链表1当前的data值小于链表2的data值,那么值小的结点就要放在前面
            if (l1.data < l2.data) {
                //cur的下一个指针指向l1
                cur.next = l1;
                //cur指针向下移位一次
                cur = cur.next;
                //l1指针移位一次
                l1 = l1.next;
            } else {
                //当前结点指向此时l2指针指向的结点
                cur.next = l2;
                //cur指针移位一次
                cur = cur.next;
                //l2指针移位一次
                l2 = l2.next;
            }
        }

        while (l1 != null) {
            cur.next = l1;
            cur = cur.next;
            l1 = l1.next;
        }

        while (l2 != null) {
            cur.next = l2;
            cur = cur.next;
            l2 = l2.next;
        }

        return dummy.next;
    }
}
