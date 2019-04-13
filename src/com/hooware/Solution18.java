package com.hooware;

/**
 * 题目描述
         操作给定的二叉树，将其变换为源二叉树的镜像。
         输入描述:
         二叉树的镜像定义：源二叉树
              8
            /  \
           6   10
          / \  / \
         5  7 9 11
         镜像二叉树
              8
            /  \
           10   6
          / \  / \
         11 9 7  5
 */
public class Solution18 {

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

    /**
     *
     * 用例:
         {8,6,10,5,7,9,11}

         对应输出应该为:

         {8,10,6,11,9,7,5}

         你的输出为:

        {8,10,10,11,11,11,11}
     * @param root
     */
    public void Mirror(TreeNode root) {
        root = reverseNode(root);
    }

    private TreeNode reverseNode(TreeNode root) {
        if (root == null){
            return null;
        }
        TreeNode left = root.left;
        TreeNode right = root.right;
        root.left = right;
        root.right = left;

        reverseNode(root.left);
        reverseNode(root.right);

        return root;
    }


}
