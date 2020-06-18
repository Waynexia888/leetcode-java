/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: An integer
     */
    public int sum = 0;

    public int leafSum(TreeNode root) {
        // write your code here
        helper(root);
        return sum;
    }

    public void helper(TreeNode root) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            sum += root.val;
            return;
        }

        helper(root.left);
        helper(root.right);
    }
}