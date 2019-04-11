package com.hooware;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历的结果。
 * 如果是则输出Yes,否则输出No。假设输入的数组的任意两个数字都互不相同。
 */
public class Solution23 {

    public static void main(String[] args) {
        int[] a = {4,2,1,3,6,5,7};
        int[] b = {1,3,2,5,7,6,4};
        System.out.println(VerifySquenceOfBST(a));
        System.out.println(VerifySquenceOfBST(b));
    }


    /**
     * 思路：找住二叉查找树的特点：左子树<根<=右子树  使用分治思想
     * @param sequence
     * @return
     */
    public static boolean VerifySquenceOfBST(int [] sequence) {
        if(sequence.length == 0){
            return false;
        }
        if(sequence.length == 1){
            return true;
        }
        return judge(sequence,0,sequence.length-1);
    }
    public static boolean judge(int[] a,int start,int end){
        if(start >= end){
            return true;
        }
        int i = start;
        while(a[i] < a[end]){
            ++i;
        }
        for(int j=i;j<end;j++){
            if(a[j] < a[end]){
                return false;
            }
        }
        return judge(a,start,i-1) && judge(a,i,end-1);
    }

    /** 5,6,7
     *  前序遍历序列{4,2,1,3,6,5,7}和中序遍历序列{1,2,3,4,5,6,7},后序遍历{1,3,2,5,7,6,4}
     *           4
     *        /   \
     *      2      6
     *     / \   /  \
     *    1  3  5   7
     * @param sequence
     * @return
        思路：
        已知条件：后序序列最后一个值为root；二叉搜索树左子树值都比root小，右子树值都比root大。
        1、确定root；
        2、遍历序列（除去root结点），找到第一个大于root的位置，则该位置左边为左子树，右边为右子树；
        3、遍历右子树，若发现有小于root的值，则直接返回false；
        4、分别判断左子树和右子树是否仍是二叉搜索树（即递归步骤1、2、3）。
     */
    public static boolean verifysquenceofbst1(int [] sequence) {

        int len = sequence.length;
        if (len < 1){
            return true;
        }
        int root = sequence[len-1];
        int index = 0;
        for (int i = 0; i < len; i++) {
            if (sequence[i] < root){
                index++;
            }else {
                break;
            }
        }
        int[] left = new int[index];
        for (int i = 0; i < index; i++) {
            left[i] = sequence[i];
            if (sequence[i] > root){
                return false;
            }
        }
        int[] right = new int[len - index];
        for (int i = index, j = 0; i < len; i++) {
            right[j++] = sequence[i];
            if (sequence[i] < root){
                return false;
            }
        }
        return verifysquenceofbst1(left) && verifysquenceofbst1(right);
    }
}
