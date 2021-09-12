Lintcode 614 · Binary Tree Longest Consecutive Sequence II

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
    private int maxLength = Integer.MIN_VALUE;
    public int longestConsecutive2(TreeNode root) {
        // write your code here
        postorder(root);
        return maxLength;
    }

    // int[] return increasing max length, decreasing max length
    private int[] postorder(TreeNode root) {
        if (root == null) {
            return new int[]{0, 0};
        }
        // left[0]: increasing length, from parent to child
        // left[1]: decreasing length, from parent to child
        int[] left = postorder(root.left);
        int[] right = postorder(root.right);

        // what to do at current node
        if (root.left != null && root.val == root.left.val + 1) { // increasing
            left[0] += 1;
        } else {  // 1 -> 5, not increasing by 1
            left[0] = 1;
        }

        if (root.left != null && root.val == root.left.val - 1) { // decreasing
            left[1] += 1;
        } else {
            left[1] = 1;
        }

        if (root.right != null && root.val == root.right.val + 1) { // increasing
            right[0] += 1;
        } else {
            right[0] = 1;
        }

        if (root.right != null && root.val == root.right.val - 1) { // decreasing
            right[1] += 1;
        } else {
            right[1] = 1;
        }
        maxLength = Math.max(maxLength, Math.max(left[1] + right[0] - 1, left[0] + right[1] - 1));
        return new int[]{Math.max(left[0], right[0]), Math.max(left[1], right[1])};
    }
}