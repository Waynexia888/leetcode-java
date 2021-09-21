Leetcode 366. Find Leaves of Binary Tree

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
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        postOrder(root, results);
        return results;
    }
    
    private int postOrder(TreeNode root, List<List<Integer>> results) {
        if (root == null) {
            return -1;
        }
        
        int left = postOrder(root.left, results);
        int right = postOrder(root.right, results);
        int level = Math.max(left, right) + 1;
        if (results.size() == level) {
            results.add(new ArrayList<>());
        }
        results.get(level).add(root.val);
        root.left = null;
        root.right = null;
        return level;
    }
}
