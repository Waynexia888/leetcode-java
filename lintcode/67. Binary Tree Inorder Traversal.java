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
     * @param root: A Tree
     * @return: Inorder in ArrayList which contains node values.
     */
    public List<Integer> inorderTraversal(TreeNode root) {
        // 递归
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        dfs(root, results);
        return results;
    }
    
    private void dfs(TreeNode root, List<Integer> results) {
        if (root == null) {
            return;
        }
        
        dfs(root.left, results);
        results.add(root.val);
        dfs(root.right, results);
    }
}

////////////////////////////////////////////////////////////////
// 非递归实现中序遍历