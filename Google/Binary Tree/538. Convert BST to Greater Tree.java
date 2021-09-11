Leetcode 538. Convert BST to Greater Tree

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
    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        inorder(root);
        return root;
    }
    
    // reversed inorder
    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.right);
        sum += root.val;
        root.val = sum;
        inorder(root.left);    
    }
}

/////////////////////////////////////////////////////////////
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
    
    public TreeNode convertBST(TreeNode root) {
        if (root == null) {
            return root;
        }
        
        int sum = 0;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode node = root;
        while (node != null) {
            stack.push(node);
            node = node.right;
        }
        
        while (!stack.isEmpty()) {
            TreeNode n = stack.pop();
            sum += n.val;
            n.val = sum;
            if (n.left != null) {
                TreeNode cur = n.left;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.right;
                }
            }
        }
        return root;
    }
}
