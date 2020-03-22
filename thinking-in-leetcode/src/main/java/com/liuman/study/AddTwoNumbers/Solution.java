package com.liuman.study.AddTwoNumbers;

import com.liuman.study.SingleLinkedList.ListNodeUtil;
import com.liuman.study.SingleLinkedList.MyLinkedList;
import com.liuman.study.SingleLinkedList.ListNode;

/**
 * @author liuman
 *
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * 2. Add Two Numbers
 * 题意：两个链表，节点上的数逆序组成一个数字，求和，返回链表
 * 难度：Medium
 * 分类：Linked List, Math
 * 算法：两个链表一起遍历，按位加，注意进位
 * Tips：不要遍历完一个链表保存为变量，求变量和再转化为链表。因为链表可能很长，变量无法保存下来；
 *       注意考虑两个链表长度不一致的问题
 */
public class Solution {

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        l1.addNode(2);
        l1.addNode(4);
        l1.addNode(3);
        System.out.println("l1 info:");
        l1.printLink();

        MyLinkedList l2 = new MyLinkedList();
        l2.addNode(5);
        l2.addNode(6);
        l2.addNode(4);
        System.out.println("l2 info:");
        l2.printLink();

        ListNode result1 = addTwoNumbers(l1.getFirstNode(),l2.getFirstNode());
        ListNode result = ListNodeUtil.reverseLinkByNode(result1);
        ListNodeUtil.printLinkByNode(result);
    }

    /**
     *  * S = 链表1 + 链表2 + 进位
     *  * 新链表的点 = S % 10
     *  * 进位 = S / 10
     * @param l1 链表1
     * @param l2 链表2
     * @return
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode dummy = new ListNode(0);
        ListNode curt = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || carry !=0) {
            int value1 = 0;
            int value2 = 0;

            if (l1 != null) {
                value1 = l1.data;
                l1 = l1.next;
            }

            if (l2 != null) {
                value2 = l2.data;
                l2 = l2.next;
            }

            int value = value1 + value2 + carry;
            //获得进位
            carry = value / 10;
            //
            value = value % 10;
            ListNode node = new ListNode(value);
            curt.next = node;
            curt = curt.next;
        }

        return dummy.next;
    }

}
