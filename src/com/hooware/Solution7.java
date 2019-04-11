package com.hooware;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * 大家都知道斐波那契数列，现在要求输入一个整数n，
 * 请你输出斐波那契数列的第n项（从0开始，第0项为0）。n<=39
 * 1,1,2,3,5,8,13,21,34
 */
public class Solution7 {
    public static void main(String[] args) {
        Solution7 solution7 = new Solution7();
        int num = solution7.Fibonacci(44);
        System.out.println(num);
    }

    public int Fibonacci(int n) {
        if (n == 0)
            return 0;
        if (n == 1)
            return 1;
        return Fibonacci(n-1)+Fibonacci(n-2);
        /*Map<Integer,Integer> map = new HashMap<>();
        if (map.containsKey(n)){
            return map.get(n);
        }
        if (n == 1 || n == 2){
            return 1;
        }

        int count = Fibonacci(n-1)+Fibonacci(n-2);
        map.put(n,count);

        return count;*/
    }
}
