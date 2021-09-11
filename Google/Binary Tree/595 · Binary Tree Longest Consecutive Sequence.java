Lintcode 595 · Binary Tree Longest Consecutive Sequence

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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    private int longestLength = 0;
    public int longestConsecutive(TreeNode root) {
        // write your code here
        dfs(root, null, 0);
        return longestLength;
    }
    // We use a variable length to store the current consecutive path length and pass it down the tree.
    private void dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return;
        }
        length = (parent != null && parent.val + 1 == root.val) ? length + 1 : 1;
        longestLength = Math.max(longestLength, length);
        dfs(root.left, root, length);
        dfs(root.right, root, length);
    }
}

////////////////////////////////////////////////////////////////
// without storing the maxLength as a global variable.

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
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        return dfs(root, null, 0);
        
    }
    // We use a variable length to store the current consecutive path length and pass it down the tree.
    private int dfs(TreeNode root, TreeNode parent, int length) {
        if (root == null) {
            return 0;
        }
        length = (parent != null && parent.val + 1 == root.val) ? length + 1 : 1;
        int left = dfs(root.left, root, length);
        int right = dfs(root.right, root, length);
        return Math.max(length, Math.max(left, right));
    }
}

//////////////////////////////////////////////////////////

class ResultType {
    public int max_len, curr_len;
    public ResultType(int max, int curr) {
        this.max_len = max;
        this.curr_len = curr;
    }
}
public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive(TreeNode root) {
        // write your code here
        return helper(root).max_len;
    }
    private ResultType helper(TreeNode root) {
        if(root == null) {
            return new ResultType(0, 0);
        }
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);
        int curr = 1;
        if(root.left != null && root.val + 1 == root.left.val) {
            curr = left.curr_len + 1;
        }
        if(root.right != null && root.val + 1 == root.right.val) {
            curr = Math.max(curr, right.curr_len + 1);
        }
        int max = Math.max(curr, Math.max(left.max_len, right.max_len));
        return new ResultType(max, curr);
    }
}