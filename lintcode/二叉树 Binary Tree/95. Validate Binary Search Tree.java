/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        // 分治法的思想， 时间复杂度O(n), 空间复杂度O(n)
        return helper(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean helper(TreeNode root, long minValue, long maxValue) {
        if (root == null) {
            return true;
        }
        
        if (minValue >= root.val || maxValue <= root.val) {
            return false;
        }
        
        // 判断左子树是否满足BST， 左子树的任何一个节点都应该比root跟节点的值小，所以应该更新上下界
        // 判断右子树是否满足BST，右子树的任何一个节点都应该比root根节点的值大
        return helper(root.left, minValue, root.val) && helper(root.right, root.val, maxValue);
    }
}
}

////////////////////////////////////////////////////////////////////////

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
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    
    class ResultType {
        public boolean isBST;
        public TreeNode minNode;
        public TreeNode maxNode;
        public ResultType(boolean isBST) {
            this.isBST = isBST;
            this.minNode = null;
            this.maxNode = null;
        }
    }
    
    public boolean isValidBST(TreeNode root) {
        // BST定义：
        // 左子树的最大值 < root.val < 右子树的最小值
        // 左右子树都是BST
        // 一个node也是BST
        // 根据以上定义，需要定义一个ResultType，返回boolean(是否是BST),同时记录最大值，最小值
        // 分治法，但是 minValue 和 maxValue 用 minNode 和 maxNode 来代替。
        ResultType result = helper(root);
        return result.isBST;
    }
    
    private ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(true);
        }
        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        
        // conquer
        //只要左子树或者右子树有一个不是BST, return false
        if (!left.isBST || !right.isBST) {
            return new ResultType(false);
        }
        // 左子树的最大值 < root.val < 右子树的最小值
        if (left.maxNode != null && left.maxNode.val >= root.val ) {
            return new ResultType(false);
        }
        
        if (right.minNode != null && right.minNode.val <= root.val) {
            return new ResultType(false);
        }
        
        // 到了这一步，可以说明是BST, 那么需要处理下minNode 和 maxNode
        ResultType rt = new ResultType(true);
        rt.minNode = left.maxNode != null ? left.maxNode : root;
        rt.maxNode = right.minNode != null ? right.minNode : root;
        
        return rt;
    }
}