package com.liuman.study.SingleLinkedList;

/**
 * 结点工具类
 * @Author: liuman
 * @Date: 2020-03-22 22:23
 */
public final class ListNodeUtil {

    public static void printLinkByNode(ListNode node) {
        ListNode curNode = node;
        while (curNode != null) {
            System.out.print(curNode.data + " ");
            curNode = curNode.next;
        }
    }

    /**
     * 反转链表，在反转指针前一定要保存下个结点的指针
     * @param node
     */
    public static ListNode reverseLinkByNode(ListNode node) {
        if (node == null || node.next == null) {
            return node;
        }
        //当前头结点
        ListNode curNode = node;

        //前一个结点
        ListNode preNode = null;
        //下一个结点
        ListNode nextNode = null;

        while (curNode != null) {
            //保留下一个结点
            nextNode = curNode.next;
            //指针反转
            curNode.next = preNode;
            //前结点后移
            preNode = curNode;
            //当前结点后移
            curNode = nextNode;
        }
        return preNode;
    }
}
