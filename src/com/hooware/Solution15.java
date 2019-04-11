package com.hooware;

import java.util.Stack;

/**
 * 输入一个链表，反转链表后，输出新链表的表头。
 */
public class Solution15 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Solution15 solution15 = new Solution15();
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);

        ListNode cur = solution15.ReverseList(listNode);
        while(cur != null){
            Thread.sleep(300);
            System.out.print(cur.val + " ");
            cur = cur.next;
        }

    }

    public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        ListNode cur = head;
        ListNode nex = head.next;
        // 防止头部两个节点形成循环链表
        head.next = null;
        ListNode node ;
        while (nex != null){
            node = nex.next;
            nex.next = cur;
            cur = nex;
            nex = node;
        }
        return cur;
    }

    /*public ListNode ReverseList(ListNode head) {
        if (head == null){
            return null;
        }
        Stack<ListNode> stack = new Stack<>();
        while (head != null){
            stack.push(head);
            head = head.next;
        }
        ListNode cur = stack.pop();
        head = cur;
        while (!stack.isEmpty()){
            cur.next = stack.pop();
            cur = cur.next;
        }
        return head;
    }*/
}
