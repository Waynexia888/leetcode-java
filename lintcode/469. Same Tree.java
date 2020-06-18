/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param a: the root of binary tree a.
     * @param b: the root of binary tree b.
     * @return: true if they are identical, or false.
     */
    public boolean isIdentical(TreeNode a, TreeNode b) {
        // divide and conquer
        // 这里一定要先做一个异常判断，当值为null的时候该怎么处理
        if (a == null && b == null) {
            return true;
        } else if (a == null || b == null) {
            return false;
        }

        if (a.val != b.val) {
            return false;
        }

        return isIdentical(a.left, b.left) && isIdentical(a.right, b.right);
    }
}