package com.liuman.study.SingleLinkedList;

/**
 * https://www.cnblogs.com/bjh1117/p/8335108.html
 * 单链表常见操作
 * @Author: liuman
 * @Date: 2020-03-22 21:18
 */
public class MyLinkedList {

    /**
     * 链表的头结点
     */
    ListNode head = null;

    /**
     * 链表添加结点
     * 找到链表的末尾结点,把新添加的数据作为末尾结点的后续结点
     * @param data
     */
    public void addNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            return;
        }

        ListNode temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }

    public boolean deleteNode(int index) {
        //待删除结点不存在
        if (index < 1 || index > length()) {
            return false;
        }

        //删除头结点
        if (index == 1) {
            head = head.next;
        }

        ListNode preNode = head;
        ListNode curNode = head.next;
        int i = 2;
        while (curNode != null) {
            //寻找待删除结点
            if (i == index) {
                preNode.next = curNode.next;
                return true;
            }
            preNode = preNode.next;
            curNode = curNode.next;
            i++;
        }

        return false;
    }

    public int length() {
        int length = 0;
        ListNode curNode = head;
        while (curNode != null) {
            length++;
            curNode = curNode.next;
        }

        return length;
    }

    /**
     * 打印链表结点信息
     */
    public void printLink() {
        ListNode curNode = head;
        while (curNode != null) {
            if (curNode.next != null) {
                System.out.print(curNode.data + "->");
            } else {
                System.out.print(curNode.data);
            }
            curNode = curNode.next;
        }

        System.out.println();
    }

    public ListNode getFirstNode() {
        return head;
    }

    public static void main(String[] args) {
        MyLinkedList l1 = new MyLinkedList();
        l1.addNode(3);
        l1.addNode(0);
        l1.addNode(4);
        l1.addNode(5);
        l1.printLink();

        System.out.println("length:" + l1.length());
    }
}
