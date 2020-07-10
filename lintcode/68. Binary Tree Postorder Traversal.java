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
     * @return: Postorder in ArrayList which contains node values.
     */
    public List<Integer> postorderTraversal(TreeNode root) {
        // 时间复杂度O(n), 空间复杂度O(n)
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
        dfs(root.right, results);
        results.add(root.val);
        
    }
}

////////////////////////////////////////////////////////////////
//非递归实现后序遍历