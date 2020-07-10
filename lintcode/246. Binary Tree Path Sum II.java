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
    /*
     * @param root: the root of binary tree
     * @param target: An integer
     * @return: all valid paths
     */
    public List<List<Integer>> binaryTreePathSum2(TreeNode root, int target) {
        // 因为本题的路径不考虑从头到尾，中间的任意路径满足等于target即可
        // 因此递归出口根376题不一样，注意体会
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) {
            return results;
        }
        
        dfs(root, target, new ArrayList<>(), results);
        return results;
    }
    
    private void dfs(TreeNode root, int target, List<Integer> path, List<List<Integer>> results) {
        if (root == null) {
            return;
        }
        path.add(root.val);
        
        int sum = target;
        for (int i = path.size() - 1; i >= 0; i--) {
            sum -= path.get(i);
            if (sum == 0) {
                results.add(new ArrayList<Integer>(path.subList(i, path.size())));
            }
        }
        
        dfs(root.left, target, path, results);
        dfs(root.right, target, path, results);
        path.remove(path.size() - 1);
    }
}