package com.hooware;

/**
 * 输入一个复杂链表（每个节点中有节点值，以及两个指针，一个指向下一个节点，
 * 另一个特殊指针指向任意一个节点），返回结果为复制后复杂链表的head。（注意，输出结果中请不要返回参数中的节点引用，否则判题程序会直接返回空）
 */
public class Solution25 {

    public class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }


    public static void main(String[] args) {

    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba

     1. 把复制的结点链接在原始链表的每一对应结点后面

     2. 把复制的结点的random指针指向被复制结点的random指针的下一个结点

     3. 拆分成两个链表，奇数位置为原链表，偶数位置为复制链表，注意复制链表的最后一个结点的next指针不能跟原链表指向同一个空结点None，next指针要重新赋值None(判定程序会认定你没有完成复制）

     *
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if(pHead == null) {
            return null;
        }

        RandomListNode currentNode = pHead;
        //1、复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
        while(currentNode != null){
            RandomListNode cloneNode = new RandomListNode(currentNode.label);
            RandomListNode nextNode = currentNode.next;
            currentNode.next = cloneNode;
            cloneNode.next = nextNode;
            currentNode = nextNode;
        }

        currentNode = pHead;
        //2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
        while(currentNode != null) {
            currentNode.next.random = currentNode.random==null?null:currentNode.random.next;
            currentNode = currentNode.next.next;
        }

        //3、拆分链表，将链表拆分为原链表和复制后的链表
        currentNode = pHead;
        RandomListNode pCloneHead = pHead.next;
        while(currentNode != null) {
            RandomListNode cloneNode = currentNode.next;
            currentNode.next = cloneNode.next;
            cloneNode.next = cloneNode.next==null?null:cloneNode.next.next;
            currentNode = currentNode.next;
        }

        return pCloneHead;
    }


    public RandomListNode Clone1(RandomListNode pHead)
    {
        if (pHead == null) return null;

        RandomListNode newNode = new RandomListNode(pHead.label);

        newNode.random = pHead.random;
        newNode.next = Clone1(pHead.next);

        return newNode;
    }


    /**
     * 链接：https://www.nowcoder.com/questionTerminal/f836b2c43afc4b35ad6adc41ec941dba

     1. 把复制的结点链接在原始链表的每一对应结点后面

     2. 把复制的结点的random指针指向被复制结点的random指针的下一个结点

     3. 拆分成两个链表，奇数位置为原链表，偶数位置为复制链表，注意复制链表的最后一个结点的next指针不能跟原链表指向同一个空结点None，next指针要重新赋值None(判定程序会认定你没有完成复制）

     *
     *解题思路：
     *1、遍历链表，复制每个结点，如复制结点A得到A1，将结点A1插到结点A后面；
     *2、重新遍历链表，复制老结点的随机指针给新结点，如A1.random = A.random.next;
     *3、拆分链表，将链表拆分为原链表和复制后的链表
     */
    public RandomListNode Clone2(RandomListNode pHead) {
        if (pHead == null){
            return null;
        }


        return null;
    }
}
