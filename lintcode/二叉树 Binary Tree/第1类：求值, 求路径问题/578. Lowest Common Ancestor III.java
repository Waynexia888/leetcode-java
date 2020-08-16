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
     * @param root: The root of the binary tree.
     * @param A: A TreeNode
     * @param B: A TreeNode
     * @return: Return the LCA of the two nodes.
     */
    class ResultType {
        public boolean a_exist;
        public boolean b_exist;
        public TreeNode node;
        public ResultType(boolean a_exist, boolean b_exist, TreeNode node) {
            this.a_exist = a_exist;
            this.b_exist = b_exist;
            this.node = node;
        }
    }
    public TreeNode lowestCommonAncestor3(TreeNode root, TreeNode A, TreeNode B) {
        // divide conquer
        // 需要判断A，B节点是否在二叉树上存在
        // 所以定义一个ResultType来返回三个值
        ResultType result = helper(root, A, B);
        if (result.a_exist && result.b_exist) {
            return result.node;
        }
        return null;
    }
    
    private ResultType helper(TreeNode root, TreeNode A, TreeNode B) {
        //root是空的情况
        if (root == null) {
            return new ResultType(false, false, null);
        }
        // divide
        ResultType left = helper(root.left, A, B);
        ResultType right = helper(root.right, A, B);
        
        //判断a_exist和b_exist存在的情况
        boolean a_exist = left.a_exist || right.a_exist || root == A;
        boolean b_exist = left.b_exist || right.b_exist || root == B;
        
        // A节点是root的情况， 或者B节点是root的情况
        if (root == A || root == B) {
            return new ResultType(a_exist, b_exist, root);
        }
        
        // 判断LCA在左子树或者右子树的情况
        // 如果左边不为空， 右边也不为空，也就是一边一个的情况下，LCA就是root
        if (left.node != null && right.node != null) {
            return new ResultType(a_exist, b_exist, root);
        }
        // 如果左边不为空， 右边为空，LCA就是left
        if (left.node != null && right.node == null) {
            return new ResultType(a_exist, b_exist, left.node);
        }
        // 如果左边为空， 右边不为空，LCA就是right
        if (left.node == null && right.node != null) {
            return new ResultType(a_exist, b_exist, right.node);
        }
        // 如果左边为空， 右边为空，LCA就是null
        return new ResultType(a_exist, b_exist, null);
        
    }
}