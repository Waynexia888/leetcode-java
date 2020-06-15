/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

class ResultType {
    public boolean isBalanced;
    public int depth;

    public ResultType(boolean isBalanced, int depth) {
        this.isBalanced = isBalanced;
        this.depth = depth;
    }
}

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // divide conquer
        // 因为要返回的值有两个， 所以写一个ResultType类，使返回值（高度信息，平衡信息）都能返回回去
        return maxDepth(root).isBalanced;
    }

    public ResultType maxDepth(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }

        ResultType left = maxDepth(root.left);
        ResultType right = maxDepth(root.right);
        int depth = Math.max(left.depth, right.depth) + 1;

        if (!left.isBalanced || !right.isBalanced) {
            return new ResultType(false, -1);
        }

        if (Math.abs(left.depth - right.depth) > 1) {
            return new ResultType(false, -1);
        }

        return new ResultType(true, depth);
    }
}