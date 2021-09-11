Lintcode 482 · Binary Tree Level Sum

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
     * @param level: the depth of the target level
     * @return: An integer
     */
    private int sum = 0;
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }

        dfs(root, level, 1);
        return sum;
    }

    private void dfs(TreeNode root, int level, int depth) {
        if (root == null) {
            return;
        }
        if (depth == level) {
            sum += root.val;
        }

        dfs(root.left, level, depth + 1);
        dfs(root.right, level, depth + 1);
    }
}

//////////////////////////////////////////////////////////////////

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
     * @param level: the depth of the target level
     * @return: An integer
     */
    private int sum = 0;
    public int levelSum(TreeNode root, int level) {
        // write your code here
        if (root == null) {
            return 0;
        }
        if (level == 1) {
            sum += root.val;
        }
        levelSum(root.left, level - 1);
        levelSum(root.right, level - 1);
        return sum;
    }
}