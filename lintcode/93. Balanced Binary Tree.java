// /**
//  * Definition of TreeNode: public class TreeNode { public int val; public
//  * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
//  * this.right = null; } }
//  */

// class ResultType {
//     public boolean isBalanced;
//     public int depth;

//     public ResultType(boolean isBalanced, int depth) {
//         this.isBalanced = isBalanced;
//         this.depth = depth;
//     }
// }

// public class Solution {
//     /**
//      * @param root: The root of binary tree.
//      * @return: True if this Binary tree is Balanced, or false.
//      */
//     public boolean isBalanced(TreeNode root) {
//         // divide conquer
//         // 因为要返回的值有两个， 所以写一个ResultType类，使返回值（高度信息，平衡信息）都能返回回去
//         return maxDepth(root).isBalanced;
//     }

//     public ResultType maxDepth(TreeNode root) {
//         if (root == null) {
//             return new ResultType(true, 0);
//         }

//         ResultType left = maxDepth(root.left);
//         ResultType right = maxDepth(root.right);
//         int depth = Math.max(left.depth, right.depth) + 1;

//         if (!left.isBalanced || !right.isBalanced) {
//             return new ResultType(false, -1);
//         }

//         if (Math.abs(left.depth - right.depth) > 1) {
//             return new ResultType(false, -1);
//         }

//         return new ResultType(true, depth);
//     }
// }


///////////////////////////////////////////////////////////////
// 九章基础班习题

/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.left)) {
            return false;
        }

        if (!isBalanced(root.right)) {
            return false;
        }

        return Math.abs(getTreeHeight(root.left) - getTreeHeight(root.right)) <= 1;
    }

    public int getTreeHeight(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(getTreeHeight(root.left), getTreeHeight(root.right)) + 1;
    }
}

////////////////////////////////////////////////////////////////
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
     * @return: True if this Binary tree is Balanced, or false.
     */
    
    class ResultType {
        public boolean isTreeBalanced;
        int height;
        public ResultType(boolean isTreeBalanced, int height) {
            this.isTreeBalanced = isTreeBalanced;
            this.height = height;
        }
    }
    public boolean isBalanced(TreeNode root) {
        // write your code here
        ResultType results = dfs(root);
        return results.isTreeBalanced;
    }
    
    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(true, 0);
        }
        // divide
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        
        // conquer
        // 左子树是平衡的，右子树也是平衡的，且高度差<= 1，那么整棵数就是平衡二叉树
        if (left.isTreeBalanced && right.isTreeBalanced && Math.abs(left.height - right.height) <= 1) {
            return new ResultType(true, Math.max(left.height, right.height) + 1);
        }
        return new ResultType(false, Math.max(left.height, right.height) + 1);
        
    }
}

///////////////////////////////////////////

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
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        // write your code here
        if (root == null) {
            return true;
        }

        if (!isBalanced(root.left)) {
            return false;
        }

        if (!isBalanced(root.right)) {
            return false;
        }
        
        if (Math.abs(height(root.left) - height(root.right)) > 1) {
            return false;
        }
        return true;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(height(root.left), height(root.right)) + 1;
    }
}