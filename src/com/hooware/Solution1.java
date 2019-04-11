package com.hooware;

/**
 * 在一个二维数组中（每个一维数组的长度相同），每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class Solution1 {

    public static void main(String[] args) {
        int[][] array = {
                {1,2,3,4},
                {5,6,7,8},
                {9,10,11,12}
        };
        boolean flag = find(7,array);
        System.out.println(flag);
    }

    public static boolean find(int target, int [][] array) {
        if (array == null || array.length == 0 || array[0].length == 0)
            return false;
        int row = array.length;
        int col = array[0].length;
        int i = 0; int j = col - 1;
        int pivot = array[i][j];
        while (i < row && j >= 0){
            if (target == pivot) {
                return true;
            }
            else if (target > pivot){
                i++;
            }
            else { // target < pivot
                j--;
            }
            if (i<row && j > -1) {
                pivot = array[i][j];
            }
        }
        return false;
    }
}
