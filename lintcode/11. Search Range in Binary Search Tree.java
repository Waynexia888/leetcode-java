/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: param root: The root of the binary search tree
     * @param k1:   An integer
     * @param k2:   An integer
     * @return: return: Return all keys that k1<=key<=k2 in ascending order
     */
    public List<Integer> searchRange(TreeNode root, int k1, int k2) {
        // 由于题目给的是一个BST，那么肯定满足BST的特点： 左子树的值 < root.val < 右子树的值
        // 本题同时考察中序遍历
        // 这题有一个可以剪枝的技巧，如果已经可以确定左子树或右子树不在数值范围内，可以不遍历相应的子树。
        // 时间复杂度: 遍历一遍二叉树的时间复杂度为 O(n)
        // 空间复杂度: 递归的空间开销取决于树的最大深度，空间复杂度为O(n)
        List<Integer> results = new ArrayList<>();
        dfs(root, k1, k2, results);
        return results;
    }

    private void dfs(TreeNode root, int k1, int k2, List<Integer> results) {
        if (root == null) {
            return;
        }
        // 剪枝，如果当前节点<= k1, 那么不必访问左子树
        if (root.val > k1) {
            dfs(root.left, k1, k2, results);
        }
        //
        if (k1 <= root.val && root.val <= k2) {
            results.add(root.val);
        }
        // 剪枝， 如果当前节点>= k2, 不必访问右子树
        if (root.val < k2) {
            dfs(root.right, k1, k2, results);
        }
    }
}