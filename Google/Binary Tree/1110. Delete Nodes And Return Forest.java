Leetcode 1110. Delete Nodes And Return Forest

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
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        Set<Integer> set = new HashSet<>();
        for (int val : to_delete) {
            set.add(val);
        }
        
        // 返回删除后的新二叉树，若不为空，则添加到结果集中
        root = postOrder(root, set, results);
        if (root != null) {
            results.add(root);
        }
        return results;
    }
    
    // 该递归函数返回（本级递归返回值）: 移除掉特定节点后的二叉树
    private TreeNode postOrder(TreeNode root, Set<Integer> set, List<TreeNode> results) {
        if (root == null) {
            return null;
        }
        // 去左右子树中移除‘to_delete’中出现的节点
        root.left = postOrder(root.left, set, results);
        root.right = postOrder(root.right, set, results);
        // 本级递归做的事：如果当前节点存在于待删除列表中，则将其非空子树存储到results中，并移除该点
        if (set.contains(root.val)) {
            if (root.left != null) {
                results.add(root.left);
            }
            if (root.right != null) {
                results.add(root.right);
            }
            root = null; //移除此点
        }
        return root; //本级递归返回值：移除掉特定节点后的二叉树
    }
}