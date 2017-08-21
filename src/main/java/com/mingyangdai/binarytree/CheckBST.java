package com.mingyangdai.binarytree;

import java.util.*;

/**
 * @author mingyang.dai
 * @since 2017/8/19
 */
public class CheckBST {
    class Node {
        int data;
        Node left;
        Node right;
    
        public Node(int data) {
            this.data = data;
        }
    }
    
    public Node generate(int[] nums) {
        Node root = new Node(nums[0]);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        
        generate(queue, nums, 1);
        return root;
    }
    
    private void generate(Queue<Node> queue, int[] nums, int index) {
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            
            if (index >= nums.length) return;
            node.left = new Node(nums[index++]);
            queue.add(node.left);
            
            if (index >= nums.length) return;
            node.right = new Node(nums[index++]);
            queue.add(node.right);
        }
    }
    
    boolean checkBST(Node root) {
        if (root == null) return false;
        List<Integer> list = new ArrayList<Integer>();
        String[] s = {};
        list.toArray(s);
        List<String> res = Arrays.asList(s);
        return inorder(root, list);
    }
    
    private boolean inorder(Node root, List<Integer> list) {
        if (root.left != null) {
            if (!inorder(root.left, list)) return false;
        }
        return true;
    }
    
    public static void main(String[] args) {
        CheckBST checkBST = new CheckBST();
        int[] nums = {3,2,6,1,4,5,7};
        Node root = checkBST.generate(nums);
        boolean res = checkBST.checkBST(root);
        System.out.println(res);
    }
}
