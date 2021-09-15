Lintcode 94 · Binary Tree Maximum Path Sum

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: An integer
     */
    private int maxPathSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        // write your code here
        postOrder(root);
        return maxPathSum;
    }

    private int postOrder(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int left = Math.max(0, postOrder(root.left));
        int right = Math.max(0, postOrder(root.right));

        int curMaxSum = Math.max(left, right) + root.val;
        maxPathSum = Math.max(curMaxSum, Math.max(maxPathSum, left + right + root.val));
        return curMaxSum;
    }
}

// helper function returns root value plus the larger value of left subtree and right subtree.

// update the "max" variable with the sum of root value and the largest value among left, right, left + right