package com.hooware;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 * 所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 */
public class Solution13 {
    public static void main(String[] args) {
        int [] array = {1,8,2,6,3,5,4,9,7};
        Solution13 solution13 = new Solution13();
        solution13.reOrderArray(array);
        System.out.println(Arrays.toString(array));
    }

  /*  public void reOrderArray(int [] array) {

    }

    private void swap(int a, int b){
        int temp = b;
        b = a;
        a= temp;
    }*/

   public void reOrderArray(int [] array) {
        int[] arr = new int[array.length];
        int index = 0;
        for (int i = 0; i < array.length; i++) {
            // 奇数
            if ((array[i] & 1 ) == 1){
                arr[index++] = array[i];
            }
        }
        for (int i = 0; i < array.length; i++) {
            // 偶数
            if ((array[i] & 1 ) == 0){
                arr[index++] = array[i];
            }
        }

       for (int i = 0; i < arr.length; i++) {
           array[i] = arr[i];
       }
        //array = Arrays.copyOf(arr,arr.length);
        //System.out.println(Arrays.toString(array));
    }
}
