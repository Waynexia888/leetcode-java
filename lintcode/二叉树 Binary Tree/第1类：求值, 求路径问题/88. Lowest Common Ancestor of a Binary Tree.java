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
    /*
     * @param root: The root of the binary search tree.
     * @param A: A TreeNode in a Binary.
     * @param B: A TreeNode in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        // 判断LCA在root的情况
        if (root == null) {
            return null;
        }
        
        if (root == A || root == B) {
            return root;
        }
        
        // 判断LCA在左子树或者右子树的情况
        TreeNode left = lowestCommonAncestor(root.left, A, B);
        TreeNode right = lowestCommonAncestor(root.right, A, B);
        
        // 左边不为空，右边也不为空，说明A， B存在于一边一个，他们的LCA是root
        if (left != null && right != null) {
            return root;
        }
        // 左边不为空， 右边为空， LCA是left
        if (left != null) {
            return left;
        }
        // 左边为空，右边不为空， LCA是right
        if (right != null) {
            return right;
        }
        // 左边为空， 右边也为空， return null
        return null;
    }
}