package com.mingyangdai.binarytree;

/**
 * @author mingyang.dai
 * @since 2017/8/30
 */
public class ConvertBSTtoGreaterTree {
    int sum = 0;
    
    public TreeNode convertBST(TreeNode root) {
        convert(root);
        return root;
    }
    
    public void convert(TreeNode cur) {
        if (cur == null) return;
        convert(cur.right);
        cur.val += sum;
        sum = cur.val;
        convert(cur.left);
    }
    
    public int maxCount(int m, int n, int[][] ops) {
        int x=0, y=0;
        for (int[] array : ops) {
            x = Math.max(x, array[0]);
            y = Math.max(y, array[1]);
        }
        return x*y;
    }
    
    public static void main(String[] args) {
        int[] nums = {4,2,6,1,3,5,7};
        TreeNode root = TreeNode.generate(nums);
        ConvertBSTtoGreaterTree tree = new ConvertBSTtoGreaterTree();
        tree.convertBST(root);
        TreeNode.traverse(root);
    }
}
