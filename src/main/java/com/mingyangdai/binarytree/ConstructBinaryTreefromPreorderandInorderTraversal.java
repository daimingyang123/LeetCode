package com.mingyangdai.binarytree;

import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2018/3/30
 */
public class ConstructBinaryTreefromPreorderandInorderTraversal {
    private HashMap<Integer, Integer> map;
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    private TreeNode buildTree(int[] preorder, int ps, int pe, int is, int ie) {
        if (ps < 0 || ps > pe) return null;
        
        int val = preorder[ps];
        TreeNode root = new TreeNode(val);
        int i = map.get(val);
        int left = i - is;
        root.left = buildTree(preorder, ps + 1, ps + left - 1, is,  i - 1);
        root.right = buildTree(preorder, ps + left, pe, i + 1, ie);
        return root;
    }
    
    public static void main(String[] args) {
        ConstructBinaryTreefromPreorderandInorderTraversal traversal = new ConstructBinaryTreefromPreorderandInorderTraversal();
        int[] preorder = new int[]{3,9,20,15,7};
        int[] inorder = new int[]{9,3,15,20,7};
        TreeNode root = traversal.buildTree(preorder, inorder);
        TreeNode.traverse(root);
    }
}
