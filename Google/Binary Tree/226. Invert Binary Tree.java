Leetcode 226. Invert Binary Tree

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
    public TreeNode invertTree(TreeNode root) {
        return postOrder(root); 
    }
    
    private TreeNode postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = postOrder(root.left);
        TreeNode right = postOrder(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
}

// since you need to invert the whole binary tree, we can divide the problem into smaller subproblems.

///////////////////////////////////////////////////

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
    public TreeNode invertTree(TreeNode root) {
        return postOrder(root); 
    }
    
    private TreeNode postOrder(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = postOrder(root.left);
        TreeNode right = postOrder(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }
}

// since you need to invert the whole binary tree, we can divide the problem into smaller subproblems.

//////////////////////////////////////////

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
    public TreeNode invertTree(TreeNode root) {
        postOrder(root); 
        return root;
    }
    
    private void postOrder(TreeNode root) {
        if (root == null) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
    }
}

// since you need to invert the whole binary tree, we can divide the problem into smaller subproblems.
