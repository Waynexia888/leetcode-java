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
    public int increase, decrease, longestLength;
    public ResultType(int increase, int decrease, int longestLength) {
        this.increase = increase;  // 当前节点向下的路径长度，递增
        this.decrease = decrease;  // 当前节点向上的路径长度，递减
        this.longestLength = longestLength;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the length of the longest consecutive sequence path
     */
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        ResultType results = dfs(root);
        return results.longestLength;
    }
    
    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(0, 0, 0);
        }
        // divide 
        // 左边/右边 的最长递增，最长递减，最长长度
        ResultType left = dfs(root.left);
        ResultType right = dfs(root.right);
        
        // conquer,
        // 当前节点的最长递增，最长递减长度
        int curIncrease = 0, curDecrease = 0; //本层的节点递增长度，以及节点递减长度
        if (root.left != null && root.left.val == root.val + 1) {
            // 当前节点的最长递增长度 与 左节点的最长递增长度
            curIncrease = Math.max(curIncrease, left.increase + 1);
        }
        
        if (root.left != null && root.left.val == root.val - 1) {
            curDecrease = Math.max(curDecrease, left.decrease + 1);
        }
        
        if (root.right != null && root.right.val == root.val + 1) {
            curIncrease = Math.max(curIncrease, right.increase + 1);
        }
        
        if (root.right != null && root.right.val == root.val - 1) {
            curDecrease = Math.max(curDecrease, right.decrease + 1);
        }
        
        int len = curIncrease + 1 + curDecrease;
        len = Math.max(len, Math.max(left.longestLength, right.longestLength));
        
        return new ResultType(curIncrease, curDecrease, len);
    }
}