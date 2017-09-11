package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/9/6
 */
public class TrimaBinarySearchTree {
    public TreeNode trimBST(TreeNode root, int L, int R) {
        if (root == null) return root;
        while (root != null) {
            if (root.val < L) root = root.right;
            else if (root.val > R) root = root.left;
            else break;
        }
        root.left = trimBST(root.left, L, R);
        root.right = trimBST(root.right, L, R);
        return root;
    }
    
    private TreeNode helper(TreeNode root, int L, int R) {
        if (root == null) return root;
        if (root.val < L) {
            return root.right;
        } else if (root.val > R) {
            return root.left;
        }
        return root;
    }
}
