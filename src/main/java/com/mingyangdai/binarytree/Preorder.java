package com.mingyangdai.binarytree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * @author mingyang.dai
 * @since 2017/10/23
 */
public class Preorder {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        if (root == null) return res;
        
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while (root != null) {
            while (root != null) {
                res.add(root.val);
                stack.push(root);
                root = root.left;
            }
            
            root = stack.pop();
            while (root.right == null) {
                root = stack.pop();
            }
            root = root.right;
        }
        return res;
    }
    
    
}
