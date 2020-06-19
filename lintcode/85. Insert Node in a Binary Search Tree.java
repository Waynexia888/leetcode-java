/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /*
     * @param root: The root of the binary search tree.
     * 
     * @param node: insert this node into the binary search tree
     * 
     * @return: The root of the new binary search tree.
     */
    public TreeNode insertNode(TreeNode root, TreeNode node) {
        // 在树上定位要插入节点的位置。
        // 1. 如果它大于当前根节点，则应该在右子树中，如果没有右子树则将该点作为右儿子插入；若存在右子树则在右子树中继续定位。
        // 2. 如果它小于当前根节点，则应该在左子树中，处理同上。
        if (root == null) {
            return node;
        }

        if (root.val > node.val) {
            root.left = insertNode(root.left, node);
        } else {
            root.right = insertNode(root.right, node);
        }

        return root;
    }
}