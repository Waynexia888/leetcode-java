Lintcode 1085 · Longest Univalue Path

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
     * @param root: 
     * @return: the length of the longest path where each node in the path has the same value
     */
    private int maxLength = Integer.MIN_VALUE;
    public int longestUnivaluePath(TreeNode root) {
        // Write your code here
        dfs(root); // divide conquer
        return maxLength;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left = dfs(root.left);
        int right = dfs(root.right);
        int leftLength = 0;
        if (root.left != null && root.val == root.left.val) {
            leftLength = left + 1;
        }
        
        int rightLength = 0;
        if (root.right != null && root.val == root.right.val) {
            rightLength = right + 1;
        }
        maxLength = Math.max(maxLength, leftLength + rightLength);
        return Math.max(leftLength, rightLength);
    }
}