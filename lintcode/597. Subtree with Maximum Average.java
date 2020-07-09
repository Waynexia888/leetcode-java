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
class ResultType {
    public int nodeNumber, sum;
    public double maxAvg;
    public TreeNode rootOfSubtree;
    public ResultType(TreeNode rootOfSubtree, int nodeNumber, int sum, double maxAvg) {
        this.rootOfSubtree = rootOfSubtree;
        this.nodeNumber = nodeNumber;
        this.sum = sum;
        this.maxAvg = maxAvg;
    }
}



public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the maximum average of subtree
     */
    public TreeNode findSubtree2(TreeNode root) {
        // 因为要求出平均值， 所以需要知道节点个数，以及节点个数对应的sum
        ResultType results = helper(root);
        return results.rootOfSubtree;
    }
    
    private ResultType helper(TreeNode root) {
        // 递归的出口
        if (root == null) {
            return new ResultType(null, 0, 0, 0);
        }
        
        ResultType leftResult = helper(root.left);
        ResultType rightResult = helper(root.right);
        int nodeNumber = leftResult.nodeNumber + rightResult.nodeNumber + 1;
        int sum = leftResult.sum + rightResult.sum + root.val;
        double avg = (double) sum / nodeNumber;
        ResultType result = new ResultType(root, nodeNumber, sum, avg);
         
        if (leftResult.rootOfSubtree != null && result.maxAvg < leftResult.maxAvg) {
            result.maxAvg = leftResult.maxAvg;
            result.rootOfSubtree = leftResult.rootOfSubtree;
        }
        
        if (rightResult.rootOfSubtree != null && result.maxAvg < rightResult.maxAvg) {
            result.maxAvg = rightResult.maxAvg;
            result.rootOfSubtree = rightResult.rootOfSubtree;
        }
        
        return result;
    }
}