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
     * @param root: the root of the binary tree
     * @return: the number of nodes
     */
    public int getAns(TreeNode root) {
        // Write your code here
        int count = 0;
        if (root == null) {
            return count;
        } else {
            count++;
        }
        
        int left = getAns(root.left);
        int right = getAns(root.right);
        return left + right + 1;
    }
}