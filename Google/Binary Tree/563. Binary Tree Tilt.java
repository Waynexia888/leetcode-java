Leetcode 563. Binary Tree Tilt

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
    private int sumOfTilt = 0;
    public int findTilt(TreeNode root) {
        valueSum(root);
        return sumOfTilt;
    }
    
    private int valueSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftSum = valueSum(root.left);
        int rightSum = valueSum(root.right);
        sumOfTilt += Math.abs(leftSum - rightSum);
        return leftSum + rightSum + root.val;  //return the sum of values starting from this node.
    }
}

// 返回的是sum
// divide conquer： 左右子树各自找当前那一层的sum