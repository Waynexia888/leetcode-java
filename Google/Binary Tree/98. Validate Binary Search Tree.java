Leetcode 98. Validate Binary Search Tree

preOrder: 不带参数dfs

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private boolean isBST = true;
    public boolean isValidBST(TreeNode root) {
        preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
        return isBST;
    }
    
    private void preOrder(TreeNode root, long min, long max) {
        if (root == null) {
            return;
        }
        
        // what to do at current node
        if (root.val <= min || root.val >= max) {
            isBST = false;
            return;
        }
        preOrder(root.left, min, root.val);
        preOrder(root.right, root.val, max);
    }
}

preOrder: 带参数dfs

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return preOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean preOrder(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        // what to do at current node
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        boolean isLeftBST = preOrder(root.left, min, root.val);
        boolean isRightBST = preOrder(root.right, root.val, max);
        return isLeftBST && isRightBST;
    }
}
// time: o(n); space: o(n)

////////////////////////////////////////////////////////////////////
inOrder: 带参数的dfs
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private long pre = Long.MIN_VALUE;
    // private TreeNode pre = null;
    public boolean isValidBST(TreeNode root) {
        return inOrder(root);
    }
    
    private boolean inOrder(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        boolean isLeftBST = inOrder(root.left);
        
        // what to do at current node
        if (root.val <= pre) {
            return false;
        }
        pre = root.val;

        // if (pre != null && root.val <= pre.val) {
        //     return false;
        // }
        // pre = root;
        boolean isRightBST = inOrder(root.right);
        return isLeftBST && isRightBST;
    }
}
/////////////////////////////////////////////////////////
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        return inOrder(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }
    
    private boolean inOrder(TreeNode root, long min, long max) {
        if (root == null) {
            return true;
        }
        
        boolean isLeftBST = inOrder(root.left, min, root.val);
        
        // what to do at current node
        if (root.val <= min || root.val >= max) {
            return false;
        }
        
        boolean isRightBST = inOrder(root.right, root.val, max);
        return isLeftBST && isRightBST;
    }
}

//////////////////////////////////////////////////////////////
inOrder: iterative

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        while (root != null) {
            stack.push(root);
            root = root.left;
        }
        
        long prev = Long.MIN_VALUE;
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            if (node.val <= prev) {
                return false;
            }
            prev = node.val;
            if (node.right != null) {
                TreeNode cur = node.right;
                while (cur != null) {
                    stack.push(cur);
                    cur = cur.left;
                }
            }
        }
        return true;
    }
}