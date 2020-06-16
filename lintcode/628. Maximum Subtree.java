/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */

    public TreeNode maximum_subtree_root = null;
    public int maximum_subtree_sum = Integer.MIN_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        getTreeSum(root);
        return maximum_subtree_root;
    }

    public int getTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_weight = getTreeSum(root.left);
        int right_weight = getTreeSum(root.right);
        int root_weight = left_weight + right_weight + root.val;

        if (root_weight > maximum_subtree_sum) {
            maximum_subtree_sum = root_weight;
            maximum_subtree_root = root;
        }

        return root_weight;
    }
}