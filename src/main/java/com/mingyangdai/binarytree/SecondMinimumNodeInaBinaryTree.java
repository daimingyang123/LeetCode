package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/9/19
 */
public class SecondMinimumNodeInaBinaryTree {
    public int findSecondMinimumValue(TreeNode root) {
        if (root == null || root.left == null) return -1;
        if (root.left.val == root.right.val) {
            int left = findMax(root.left);
            int right = findMax(root.right);
            if (left == root.val || right == root.val) return Math.max(left, right);
            return Math.min(left, right);
        }
        return Math.max(root.left.val, root.right.val);
    }
    
    private int findMax(TreeNode root) {
        if (root.left == null) return -1;
        if (root.left.val == root.right.val) return Math.min(findMax(root.left), findMax(root.right));
        return Math.max(root.left.val, root.right.val);
    }
    
    public static void main(String[] args) {
        SecondMinimumNodeInaBinaryTree tree = new SecondMinimumNodeInaBinaryTree();
        
    }
}
