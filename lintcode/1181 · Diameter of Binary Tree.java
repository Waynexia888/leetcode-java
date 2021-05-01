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
     * @param root: a root of binary tree
     * @return: return a integer
     */
    int diameter = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        // write your code here
        dfs(root);
        return diameter;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftResult = dfs(root.left);
        int rightResult = dfs(root.right);
        diameter = Math.max(diameter, leftResult + rightResult);
        return Math.max(leftResult, rightResult) + 1;
    }
}