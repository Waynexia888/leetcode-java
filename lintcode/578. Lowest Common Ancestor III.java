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
class ResultType {
    public boolean has_a, has_b;
    public TreeNode node;
    public ResultType(boolean has_a, boolean has_b, TreeNode node) {
        this.has_a = has_a;
        this.has_b = has_b;
        this.node = node;
    }
}

public class Solution {
    /*
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // 创建一个ResultType的类， 记录是否有a，是否有b， 以及a和b的公共祖先
        // 时间复杂度O(N), 因为每个节点有且只被访问一次
        ResultType rt = helper(root, A, B);
        if (rt.has_a && rt.has_b) {
            return rt.node;
        } else {
            return null;
        }
    }
    
    private ResultType helper (TreeNode root, TreeNode A, TreeNode B) {
        if (root == null) {
            return new ResultType(false, false, null);
        }
        
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        boolean a_exist = left.has_a || right.has_a || root == A;
        boolean b_exist = left.has_b || right.has_b || root == B;
        
        // A 和 B的公共祖先是root的情况
        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }
        
        // A 和 B的公共祖先是左子树或者右子树的情况
        // 左边不为空，右边也不为空，说明A，B存在于一边一个， 因此他们的公共祖先是root
        if (left.node != null && right.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        
        // 左边不为空， 右边为空， 他们的公共祖先是左边
        if (left.node != null) {
            return new ResultType(a_exist, b_exist, left.node);
        }
        
        // 左边为空， 右边不为空， 他们的公共祖先是右边
        if (right.node != null) {
            return new ResultType(a_exist, b_exist, right.node);
        }
        
        //左边为空， 右边为空， 他们的公共祖先是null
        return new ResultType(a_exist, b_exist, null);
    }
}