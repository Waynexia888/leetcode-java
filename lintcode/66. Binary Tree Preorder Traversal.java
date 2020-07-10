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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // 递归
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        dfs(root, results);
        return results;
    }
    
    private void dfs(TreeNode root, List<Integer> results) {
        // 递归的出口
        if (root == null) {
            return;
        }
        
        results.add(root.val);
        dfs(root.left, results);
        dfs(root.right, results);
    }
}

////////////////////////////////////////////////////////////////
// 非递归实现前序遍历

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
     * @return: Preorder in ArrayList which contains node values.
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        // non-recursion, 先序遍历，根左右
        // 先放根， 然后放右， 再放左
        List<Integer> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            results.add(node.val);
            if (node.right != null) {
                stack.push(node.right);
            }
            
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return results;
    }
}

