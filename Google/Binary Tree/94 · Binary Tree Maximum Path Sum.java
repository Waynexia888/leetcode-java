Lintcode 94 · Binary Tree Maximum Path Sum
Leetcode 124. Binary Tree Maximum Path Sum

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        postOrder(root);
        return maxSum;
    }
    
    // 本层递归返回一条最长的路径和
    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = Math.max(postOrder(root.left), 0);
        int right = Math.max(postOrder(root.right), 0);
        int curSum = left + right + root.val;
        maxSum = Math.max(maxSum, curSum);
        return Math.max(left, right) + root.val;
    }
}