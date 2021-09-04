Leetcode 98. Validate Binary Search Tree

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
    public boolean isValidBST(TreeNode root) {
       return dfs(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean dfs(TreeNode root, long low, long high) {
        if (root == null) {
            return true;
        }
        
        if (root.val <= low || root.val >= high) {
            return false;
        }
        return dfs(root.left, low, root.val) && dfs(root.right, root.val, high);
    }
}
// time: o(n); space: o(n)

////////////////////////////////////////
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
    private long pre = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    
    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        if (!inOrder(root.left)) {
            return false;
        }
        
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;
        return inOrder(root.right);
    }
}

// left, root, right