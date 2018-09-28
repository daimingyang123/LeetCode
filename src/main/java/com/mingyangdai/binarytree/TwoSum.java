package com.mingyangdai.binarytree;

import java.util.HashSet;

/**
 * @author mingyang.dai
 * @since 2017/8/29
 */
public class TwoSum {
    public boolean findTarget(TreeNode root, int k) {
        if (root == null) return false;
        return inorder(root, k, new HashSet<>());
    }
    
    private boolean inorder(TreeNode root, int k, HashSet<Integer> set) {
        if (root.left != null && inorder(root.left, k, set)) return true;
        if (set.contains(k-root.val)) return true;
        set.add(root.val);
        if (root.right != null && inorder(root.right, k, set)) return true;
        return false;
    }
    
    public static void main(String[] args) {
    }
}
