package com.hooware;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {

    public static void main(String[] args) {
        int n = -1;//2147483647;// -2147483648;
        Solution11 solution11 = new Solution11();
        int number = solution11.NumberOf1(n);
        System.out.println(number);
        System.out.println("======================");
        System.out.println(solution11.NumberOf2(-1));
        System.out.println(solution11.NumberOf2(2147483647));
        System.out.println(solution11.NumberOf2(-2147483648));
    }

    public int NumberOf1(int n) {
        int count = 0;
        if (n < 0){
            n = (Integer.MAX_VALUE - Math.abs(n)) + 1;
            count = 1;
        }

        while (n > 0){
            int flag = n & 1;
            n = n >> 1;
            count += flag;
        }
        return count;
    }

    public int NumberOf2(int n) {
        int count = 0;
        boolean negative = false;
        if (n < 0){
            n = Math.abs(n+1);
            negative = true;
        }

        while (n > 0){
            int flag = n & 1;
            n = n >> 1;
            count += flag;
        }
        return negative?(32-count):count;
    }
}
