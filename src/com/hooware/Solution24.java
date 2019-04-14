package com.hooware;

import java.util.ArrayList;
import java.util.List;

/**
 * 输入一颗二叉树的跟节点和一个整数，打印出二叉树中结点值的和为输入整数的所有路径。
 * 路径定义为从树的根结点开始往下一直到叶结点所经过的结点形成一条路径。(注意: 在返回值的list中，数组长度大的数组靠前)
 */
public class Solution24 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
        public TreeNode() {
        }
    }

    public static void main(String[] args) {

    }

    /**
     * {10,5,12,4,7},22
         对应输出应该为:
         [[10,5,7],[10,12]]
     */
    private ArrayList<ArrayList<Integer>> lists = new ArrayList<>();
    private ArrayList<Integer> list = new ArrayList<>();
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        if (root == null){
            return lists;
        }

        list.add(root.val);
        // 边界条件
        if (root.val == target && root.left == null && root.right == null){
            // 重点,必须添加一个新的列表,否则只是传递了一个list引用,在递归修改的过程中数据会被修改
            lists.add(new ArrayList<>(list));
        }
        // 递归条件
        FindPath(root.left,target-root.val);
        FindPath(root.right,target-root.val);
        // 回溯法,回退删除不符合的节点
        list.remove(list.size()-1);
        return lists;
    }

    /**
     *  // 参考网友
     private ArrayList<ArrayList<Integer>> listAll = new ArrayList<ArrayList<Integer>>();
     private ArrayList<Integer> list = new ArrayList<Integer>();
     public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
         if(root == null) return listAll;
         list.add(root.val);
         target -= root.val;
         if(target == 0 && root.left == null && root.right == null)
            listAll.add(new ArrayList<Integer>(list));
         FindPath(root.left, target);
         FindPath(root.right, target);
         list.remove(list.size()-1);
         return listAll;
     }
     */

     /**
     非递归法：后序遍历
         1.进栈时候，把值同时压入路径的向量数组，修正路径的和
         2.出栈时候，先判断和是否相等，且该节点是否是叶节点，
         判断完成后保持和栈一致，抛出路径，修改路径的和
         3.向量数组和栈的操作要保持一致
     */

    /**
    public class Solution {
        ArrayList<ArrayList<Integer>> res = new ArrayList<>();
        ArrayList<Integer> path = new ArrayList<>();
        public ArrayList<ArrayList<Integer>> FindPath(TreeNode root,int target) {
            if (root == null) {
                return res;
            }
            findPath(root, target);
            return res;
        }

        public void findPath(TreeNode root, int target) {
            //因为FindPath中和 下面程序中都进行了判null操作，root绝对不可能为 null
            path.add(root.val);
            //已经到达叶子节点，并且正好加出了target
            if (root.val == target && root.left == null && root.right == null) {
                //将该路径加入res结果集中
                res.add(new ArrayList(path));
            }
            //如果左子树非空，递归左子树
            if (root.left != null) {
                findPath(root.left, target - root.val);
            }
            //如果右子树非空，递归右子树
            if (root.right != null) {
                findPath(root.right, target - root.val);
            }
            //无论当前路径是否加出了target，必须去掉最后一个，然后返回父节点，去查找另一条路径，最终的path肯定为null
            path.remove(path.size() - 1);
            return;
        }

    }
     */

}
