package com.hooware;

import java.util.ArrayList;
import java.util.Stack;

/**
 * 输入一个链表，按链表值从尾到头的顺序返回一个ArrayList。
 */
public class Solution3 {

    public class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {

    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> list = new ArrayList<>();
            Stack<Integer> stack = new Stack<>();
            while (listNode != null) {
                stack.push(listNode.val);
                listNode = listNode.next;
            }
            while (!stack.isEmpty()) {
                list.add(stack.pop());
            }
        return list;
    }
}
