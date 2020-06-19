/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /*
     * @param A: an integer array
     * 
     * @return: A tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        // write your code here
        if (A == null) {
            return null;
        }

        return helper(A, 0, A.length - 1);
    }

    public TreeNode helper(int[] A, int start, int end) {
        if (start > end) {
            return null;
        }

        // 如果没有这一步，会照成stackoverflow
        if (start == end) {
            return new TreeNode(A[start]);
        }

        int mid = start + (end - start) / 2;
        TreeNode root = new TreeNode(A[mid]);
        root.left = helper(A, start, mid - 1);
        root.right = helper(A, mid + 1, end);

        return root;
    }
}