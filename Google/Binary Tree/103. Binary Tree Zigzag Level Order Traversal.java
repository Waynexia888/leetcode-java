Leetcode 103. Binary Tree Zigzag Level Order Traversal

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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> zigzagOrder = new ArrayList<>();
        if (root == null) {
            return zigzagOrder;
        }
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        int length = 0;
        while (!queue.isEmpty()) {
            
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                temp.add(node.val);
               
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            if (length % 2 == 0) {
                zigzagOrder.add(temp);
            } else {
                Collections.reverse(temp);
                zigzagOrder.add(temp);
            }
            length++;
        }
        return zigzagOrder;
    }
}