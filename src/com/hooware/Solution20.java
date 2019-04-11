package com.hooware;

/**
 * 定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
import java.util.Stack;

public class Solution20 {

    private Stack<Integer> stack = new Stack<>();
    private Integer min ;

    public void push(int node) {
        if (min == null || min > node){
            min = node;
        }
        stack.push(node);
    }

    public void pop() {
        int value = stack.pop();
        if (value == min){
            Stack<Integer> tempStack = new Stack<>();
            min = stack.peek();
            while (!stack.isEmpty()){
                int pop = stack.pop();
                if (min > pop){
                    min = pop;
                }
                tempStack.push(pop);
            }
            while (!tempStack.isEmpty()){
               stack.push(tempStack.pop());
            }
        }
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return min;
    }
}
