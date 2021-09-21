Lintcode 900 · Closest Binary Search Tree Value
Leetcode 270. Closest Binary Search Tree Value

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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    public int closestValue(TreeNode root, double target) {
        // write your code here
        int closest = root.val;
        while (root != null) {
            if (Math.abs(root.val - target) < Math.abs(closest - target)) {
                closest = root.val;
            }
            if (target < root.val) {
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return closest;
    }
}

////////////////////////////////////////////////////////////////////

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
     * @param root: the given BST
     * @param target: the given target
     * @return: the value in the BST that is closest to the target
     */
    private int closest;
    public int closestValue(TreeNode root, double target) {
        // write your code
        closest = root.val;
        inorder(root, target);
        return closest;
    }

    private void inorder(TreeNode root, double target) {
        if (root == null) {
            return;
        }
        if (target < root.val) {
            inorder(root.left, target);
        }
        if (Math.abs(root.val - target) < Math.abs(closest - target)) {
            closest = root.val;
        }
        inorder(root.right, target);
    }
}