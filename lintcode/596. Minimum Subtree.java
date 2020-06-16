/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */

    public TreeNode minimum_subtree_root = null;
    public int minimum_subtree_sum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        getTreeSum(root);
        return minimum_subtree_root;
    }

    // 得到root为根的二叉树所有节点之和
    // 顺便打个擂台，求出minimum_subtree_sum
    public int getTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_weight = getTreeSum(root.left);
        int right_weight = getTreeSum(root.right);
        int root_weight_of_tree = left_weight + right_weight + root.val;

        if (root_weight_of_tree < minimum_subtree_sum) {
            minimum_subtree_sum = root_weight_of_tree;
            minimum_subtree_root = root;
        }
        return root_weight_of_tree;
    }
}