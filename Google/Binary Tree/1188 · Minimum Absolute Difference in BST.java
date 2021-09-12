Lintcode 1188 · Minimum Absolute Difference in BST

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
     * @return: the minimum absolute difference between values of any two nodes
     */
    private int minDiff = Integer.MAX_VALUE;
    private TreeNode prev = null;
    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        inorder(root);
        return minDiff;
    }

    private void inorder(TreeNode root) {
        if (root == null) {
            return;
        }
        inorder(root.left);
        if (prev != null) {
            minDiff = Math.min(minDiff, Math.abs(prev.val - root.val));
        }
        prev = root;
        inorder(root.right);
    }
}

///////////////////////////////////////////////////////////////////////////////

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
     * @return: the minimum absolute difference between values of any two nodes
     */
    public int getMinimumDifference(TreeNode root) {
        // Write your code here
        if (root == null) {
            return 0;
        }

        int minDiff = Integer.MAX_VALUE;
        TreeNode prev = null;
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }

        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (prev != null) {
                minDiff = Math.min(minDiff, Math.abs(node.val - prev.val));
            }
            prev = node;
            if (node.right != null) {
                TreeNode cur = node.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return minDiff;
    }
