package com.liuman.study.AddTwoNumbers;

import com.liuman.study.SingleLinkedList.ListNode;

/**
 * 分析地址：https://www.jianshu.com/p/06cc824ba9e2
 * bilibili: https://www.bilibili.com/video/av69981223?from=search&seid=14482174967194859252
 * csdn讲解地址:https://blog.csdn.net/blioo/article/details/62050967?utm_source=app
 *
 * S = 链表1 + 链表2 + 进位
 * 新链表的点 = S % 10
 * 进位 = S / 10
 *
 * 示例：
 * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
 * 输出：7 -> 0 -> 8
 * 原因：342 + 465 = 807
 *
 * @Author: liuman 这次需要自己完全默写出来 两数相加和单链表反转的算法
 * @Date: 2020-03-22 20:52
 */
public class Solution2 {

    public static ListNode addTwoNumbers(ListNode l1,ListNode l2) {
        //定义指向结果链表的头结点的一个结点 即dummy.next就是
        ListNode dummy = new ListNode(0);
        ListNode currentNode = dummy;
        int carry = 0;

        while (l1 != null || l2 != null || 0 != carry) {
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
            carry = value / 10;
            value = value % 10;
            ListNode newNode = new ListNode(value);
            currentNode.next = newNode;
            currentNode = currentNode.next;
        }

        return dummy.next;
    }

    public static ListNode initListNode(int[] datas) {
        //datas:{2,4,3} (2 -> 4 -> 3)
        //datas:{5,6,4} (5 -> 6 -> 4)
        ListNode head = new ListNode(datas[0]);
        ListNode currenNode = head;
        for (int i=1; i<datas.length;i++) {
            ListNode nextNode = new ListNode(datas[i]);
            currenNode.next = nextNode;
            currenNode = currenNode.next;
        }
        return head;
    }

    public static void main(String[] args) {
        int[] datas1 = {2,4,3};
        int[] datas2 = {5,6,4};
        ListNode l1 = initListNode(datas1);
        ListNode l2 = initListNode(datas2);
        System.out.print("链表1:");
        printListNodeInfo(l1);

        System.out.print("链表2:");
        printListNodeInfo(l2);

        ListNode result = addTwoNumbers(l1,l2);
        System.out.print("求和结果:");
        printListNodeInfo(result);

        ListNode reverseResult = reverseListNode(result);
        System.out.print("反转链表结果:");
        printListNodeInfo(reverseResult);
    }

    /**
     * 反转链表
     * @param node  起始结点
     * @return
     */
    public static ListNode reverseListNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        ListNode currentNode = node;
        ListNode preNode = null;
        ListNode nextNode;

        while (currentNode != null) {
            //保存下一个结点
            nextNode = currentNode.next;
            //断开原有结点的指向
            currentNode.next = preNode;
            //preNode表示了要反指结点的变量
            preNode = currentNode;
            //currentNode表示了原有单链表断开指向后的第一个结点,方便下次循环时反指向原来前一个结点
            currentNode = nextNode;
        }
        return preNode;
    }

    public static void printListNodeInfo(ListNode node) {
        if (node == null) {
            return;
        }

        ListNode currentNode = node;
        while (currentNode != null) {
            if (currentNode.next != null) {
                System.out.print(currentNode.data + "->");
            } else {
                System.out.print(currentNode.data);
            }
            currentNode = currentNode.next;
        }

        System.out.println();
    }
}
