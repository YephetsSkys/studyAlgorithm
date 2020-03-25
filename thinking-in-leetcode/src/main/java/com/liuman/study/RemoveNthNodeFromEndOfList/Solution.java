package com.liuman.study.RemoveNthNodeFromEndOfList;

import com.liuman.study.SingleLinkedList.ListNode;

/**
 * https://www.bilibili.com/video/BV1U7411Y7Ux?from=search&seid=9618121920203660895
 * @Author: liuman
 * @Date: 2020-03-25 16:33
 *
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class Solution {

    public static void main(String[] args) {
        int[] datas = {1,2,3,4,5};
        int n = 2;
        ListNode orginalHeadNode = initListNodeList(datas);
        System.out.print("original info:" );
        printInfo(orginalHeadNode);

        System.out.println();

        ListNode newHeadNode = removeNthFromEnd(orginalHeadNode,n);
        System.out.print("new info:" );
        printInfo(newHeadNode);
    }

    /**
     * 打印信息
     * @param headNode
     */
    private static void printInfo(ListNode headNode) {
        ListNode currentNode = headNode;
        while (currentNode != null) {
            if (currentNode.next != null) {
                System.out.print(currentNode.data + "->");
            } else {
                System.out.print(currentNode.data);
            }
            currentNode = currentNode.next;
        }
    }

    /**
     * dummy 结点的概念就是为了创建一个指向head结点的空结点，目的是为了当要删除head结点的时候比较方便
     * @param head
     * @param n
     * @return
     */
    public static ListNode removeNthFromEnd(ListNode head,int n) {
        //创建空结点dummy
        ListNode dummy = new ListNode(0);
        //指向头结点
        dummy.next = head;
        //要是使用快慢指针，快指针先走n步，随后慢指针开始和快指针一起走，
        //当快指针走到结尾的时候，慢指针就定位到倒数第n个结点了
        ListNode slow = dummy;
        ListNode fast = dummy;

        //快指针先走n步
        for (int i=0; i<n; i++) {
            fast = fast.next;
        }

        //快慢指针一起走,一直循环到fast走到结尾
        while (fast.next != null) {
            fast = fast.next;
            slow = slow.next;
        }

        //移除结点
        slow.next = slow.next.next;

        //防止删除的是head结点
        return dummy.next;
    }

    /**
     * 根据数组初始化一个单链表
     * @param datas
     * @return
     */
    private static ListNode initListNodeList(int[] datas) {
        System.out.println("length if datas:" + datas.length);
        if (datas == null || datas.length == 0) {
            return null;
        }
        ListNode head = new ListNode(datas[0]);
        ListNode currentNode = head;

        for (int i=1; i<datas.length;i++) {
            currentNode.next = new ListNode(datas[i]);
            currentNode = currentNode.next;
        }
        return head;
    }
}
