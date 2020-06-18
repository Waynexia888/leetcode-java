/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /*
     * @param root: the root of binary tree
     * 
     * @param target: An integer
     * 
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum(TreeNode root, int target) {
        // divide and conquer
        List<List<Integer>> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 递归的出口,处理叶子节点
        if (root.left == null && root.right == null && root.val == target) {
            List<Integer> path = new ArrayList<>();
            path.add(root.val);
            result.add(path);
            return result;
        }

        // divide
        List<List<Integer>> leftPaths = binaryTreePathSum(root.left, target - root.val);
        List<List<Integer>> rightPaths = binaryTreePathSum(root.right, target - root.val);

        // merge
        for (List<Integer> l : leftPaths) {
            l.add(0, root.val); // 在index = 0的位置，插入root.val值
            result.add(l);
        }

        for (List<Integer> r : rightPaths) {
            r.add(0, root.val);
            result.add(r);
        }

        return result;
    }
}