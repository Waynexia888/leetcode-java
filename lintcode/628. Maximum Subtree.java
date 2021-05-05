/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */

    public TreeNode maximum_subtree_root = null;
    public int maximum_subtree_sum = Integer.MIN_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        getTreeSum(root);
        return maximum_subtree_root;
    }

    public int getTreeSum(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int left_weight = getTreeSum(root.left);
        int right_weight = getTreeSum(root.right);
        int root_weight = left_weight + right_weight + root.val;

        if (root_weight > maximum_subtree_sum) {
            maximum_subtree_sum = root_weight;
            maximum_subtree_root = root;
        }

        return root_weight;
    }
}

////////////////////////////////////////////////////////////////

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
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        TreeNode[] result = new TreeNode[1];
        int[] maxSum = new int[1];
        maxSum[0] = Integer.MIN_VALUE;
        divideConquer(root, result, maxSum);
        return result[0];
    }

    private int divideConquer(TreeNode root, TreeNode[] result, int[] maxSum) {
        if (root == null) {
            return 0;
        }

        int left = divideConquer(root.left, result, maxSum);
        int right = divideConquer(root.right, result, maxSum);
        int sum = left + right + root.val;

        if (sum > maxSum[0]) {
            maxSum[0] = sum;
            result[0] = root;
        }
        return sum;
    }
}

//////////////////////////////////////////////////////////////////////////
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
    public int maxSum, wholeTreeSum;
    public TreeNode maxRoot;
    public ResultType(int maxSum, int wholeTreeSum, TreeNode maxRoot) {
        this.maxSum = maxSum;
        this.wholeTreeSum = wholeTreeSum;
        this.maxRoot = maxRoot;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType result = dfs(root);
        return result.maxRoot;
    }

    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MIN_VALUE, 0, null);
        }

        ResultType leftResult = dfs(root.left);
        ResultType rightResult = dfs(root.right);

        ResultType result = new ResultType(
            leftResult.wholeTreeSum + rightResult.wholeTreeSum + root.val,
            leftResult.wholeTreeSum + rightResult.wholeTreeSum + root.val,
            root
        );

        if (leftResult.maxSum > result.maxSum) {
            result.maxSum = leftResult.maxSum;
            result.maxRoot = leftResult.maxRoot;
        }

        if (rightResult.maxSum > result.maxSum) {
            result.maxSum = rightResult.maxSum;
            result.maxRoot = rightResult.maxRoot;
        }
        return result;
    }
}
/////////////////////////////////////////////////////////////
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
     * @param root: the root of binary tree
     * @return: the maximum weight node
     */
    public int maxSum = Integer.MIN_VALUE;
    public TreeNode maxRoot = null;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        dfs(root);
        return maxRoot;
    }

    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int subSum = leftSum + rightSum + root.val;

        if (subSum > maxSum) {
            maxSum = subSum;
            maxRoot = root;
        }
        return subSum;
    }
}