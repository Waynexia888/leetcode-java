// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:

//     2
//    / \
//   1   3

// Input: [2,1,3]
// Output: true
// Example 2:

//     5
//    / \
//   1   4
//      / \
//     3   6

// Input: [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.



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
        if (root == null) {
            return true;
        }
        
        return helper(root, null, null);
    }
    
    public boolean helper(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }
        
        if (min != null && root.val <= min) {
            return false;
        }
        
        if (max != null && root.val >= max) {
            return false;
        }
        
        return helper(root.left, min, root.val) && helper(root.right, root.val, max);
    }
}


// 使用递归 + 判断是否是二叉搜索树
// time: O(n)
// space: O(n)