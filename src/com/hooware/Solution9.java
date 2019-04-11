package com.hooware;

import java.util.ArrayList;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。
 * 求该青蛙跳上一个n级的台阶总共有多少种跳法。
 */
public class Solution9 {
    private  ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        int number = solution9.JumpFloorII(26);
        System.out.println(number);
        System.out.println(solution9.list);
    }

    public int JumpFloorII(int target) {
        if (list.size() > target){
            return list.get(target);
        }

        if (target == 0 || target == 1){
            list.add(1);
            return 1;
        }

        int count = 0;
        for (int i = 0; i < target; i++) {
            count += JumpFloorII(i);
        }
        list.add(count);
        return count;
    }

}
