package com.mingyangdai.binarytree;

import java.util.HashMap;

/**
 * @author mingyang.dai
 * @since 2017/8/21
 */
public class MaximumBinaryTree {
    private HashMap<Integer, Integer> map;
    
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        if (nums.length == 0) return null;
        map = new HashMap<>();
        for (int i=0; i<nums.length; i++) {
            map.put(nums[i], i);
        }
        
        return buildTree(nums, 0, nums.length);
    }
    
    private TreeNode buildTree(int[] nums, int start, int end) {
        if (start >= end) return null;
        int max = getMax(nums, start, end);
        TreeNode root = new TreeNode(max);
        
        int index = map.get(max);
        buildLeft(nums, start, index, root);
        buildRight(nums, index+1, end, root);
        return root;
    }
    
    private void buildLeft(int[] nums, int start, int end, TreeNode root) {
        TreeNode node = buildTree(nums, start, end);
        root.left = node;
    }
    
    private void buildRight(int[] nums, int start, int end, TreeNode root) {
        TreeNode node = buildTree(nums, start, end);
        root.right = node;
    }
    
    private int getMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i=start; i<end; i++) {
            max = Math.max(max, nums[i]);
        }
        return max;
    }
    
    public static void main(String[] args) {
        MaximumBinaryTree tree = new MaximumBinaryTree();
        int[] nums = {3,2,1,6,0,5};
        TreeNode root = tree.constructMaximumBinaryTree(nums);
        TreeNode.traverse(root);
    }
}
