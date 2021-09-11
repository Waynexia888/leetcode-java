Lintcode 1033 · Minimum Difference Between BST Nodes

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
     * @param root: the root
     * @return: the minimum difference between the values of any two different nodes in the tree
     */
    private int minDifference = Integer.MAX_VALUE;
    private TreeNode pre = null;
    public int minDiffInBST(TreeNode root) {
        // Write your code here
        inorder(root);
        return minDifference;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        // if (root.left != null) {
        //     inorder(root.left);
        // }
        inorder(root.left);
        
        if (pre != null) {
            minDifference = Math.min(minDifference, Math.abs(pre.val - root.val));
        }
        pre = root;
        // if (root.right != null) {
        //     inorder(root.right);
        // }
        inorder(root.right);
    }
}