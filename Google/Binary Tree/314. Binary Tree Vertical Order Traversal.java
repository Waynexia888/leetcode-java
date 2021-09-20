Leetcode 314. Binary Tree Vertical Order Traversal

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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        Map<Integer, List<Integer>> col2NodeList = new HashMap<>();
        Map<TreeNode, Integer> node2Col = new HashMap<>();
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        node2Col.put(root, 0);
        
        int leftMostCol = 0;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            int col = node2Col.get(node);
            // build the col2NodeList; col -> {node1, node2}
            if (!col2NodeList.containsKey(col)) {
                col2NodeList.put(col, new ArrayList<>());
            }
            col2NodeList.get(col).add(node.val);
            
            if (node.left != null) {
                queue.offer(node.left);
                node2Col.put(node.left, col - 1);
            }
            if (node.right != null) {
                queue.offer(node.right);
                node2Col.put(node.right, col + 1);
            }
            leftMostCol = Math.min(leftMostCol, col); 
        }
        
        // print out the results from map col2NodeList
        while (col2NodeList.containsKey(leftMostCol)) {
            results.add(col2NodeList.get(leftMostCol));
            leftMostCol++;
        }
        return results;
    }
}