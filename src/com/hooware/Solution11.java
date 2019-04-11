package com.hooware;

/**
 * 输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
 */
public class Solution11 {

    public static void main(String[] args) {
        int n = 2147483647;// -2147483648;
        Solution11 solution11 = new Solution11();
        int number = solution11.NumberOf1(n);
        System.out.println(number);
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
}
