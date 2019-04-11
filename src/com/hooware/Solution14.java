package com.hooware;

/**
 * 输入一个链表，输出该链表中倒数第k个结点。
 */
public class Solution14 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    // 6,{1,2,3,4,5} ==> {}
    public ListNode FindKthToTail(ListNode head,int k) {
        ListNode cur = head;
        ListNode tail = head;
        for (int i = 0; i < k; i++) {
            if (tail != null) {
                tail = tail.next;
            } else {
                cur = null;
            }
        }
        while (tail != null){
            tail = tail.next;
            cur = cur.next;
        }
        return cur;
    }
}
