package com.liuman.study.SingleLinkedList;

/**
 * https://www.cnblogs.com/bjh1117/p/8335108.html
 * 单链表结点定义
 * @Author: liuman
 * @Date: 2020-03-22 21:17
 */
public class ListNode {

    /**
     * 下一个节点
     */
    public ListNode next = null;

    /**
     * 节点数据
     */
    public int data;

    public ListNode(int data) {
        this.data = data;
    }
}
