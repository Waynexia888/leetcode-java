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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
     
    public int maxConsecutivePathLength = 0;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        if (root == null) {
            return 0;
        }
        
        dfs(root);
        return maxConsecutivePathLength;
    }
    
    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int curMaxConsecutivePathLength = 1;
        // divide 
        int leftMaxConsecutivePathLength = dfs(root.left);
        int rightMaxConsecutivePathLength = dfs(root.right);
        
        // conquer, 最大值在左边还是在右边
        if (root.left != null && root.val == root.left.val - 1) {
            curMaxConsecutivePathLength = Math.max(leftMaxConsecutivePathLength + 1, curMaxConsecutivePathLength);
        }
        
        if (root.right != null && root.val == root.right.val - 1) {
            curMaxConsecutivePathLength = Math.max(rightMaxConsecutivePathLength + 1, curMaxConsecutivePathLength);
        }
        
        // traverse, update global result
        if (curMaxConsecutivePathLength > maxConsecutivePathLength) {
            maxConsecutivePathLength = curMaxConsecutivePathLength;
        }
        
        return curMaxConsecutivePathLength;
    }
    
}