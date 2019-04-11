package com.hooware;

/**
 * 给定一个double类型的浮点数base和int类型的整数exponent。
 * 求base的exponent次方。
 */
public class Solution12 {
    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        System.out.println(solution12.Power(2.3, -1));
        System.out.println(solution12.Power(2.3, 0));
        System.out.println(solution12.Power(2.3, 5));

    }

    public double Power(double base, int exponent) {
        if (exponent == 0){
            return 1;
        }
        int count = Math.abs(exponent);
        double mul = 1.0;
        for (int i = 0; i < count; i++) {
            mul *= base;
        }
        if (exponent < 0){
            mul = 1.0 / mul;
        }
        return mul;
    }
}
