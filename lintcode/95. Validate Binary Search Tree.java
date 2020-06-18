/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // write your code here
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    public boolean helper(TreeNode root, long minVal, long maxVal) {
        // minVal < root.val < maxVal
        if (root == null) {
            return true;
        }

        if (root.val >= maxVal || root.val <= minVal) {
            return false;
        }

        return helper(root.left, minVal, root.val) && helper(root.right, root.val, maxVal);
    }
}