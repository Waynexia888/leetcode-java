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
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        TreeNode[] result = new TreeNode[1];
        int[] minSum = new int[1];
        minSum[0] = Integer.MAX_VALUE;
        divideConquer(root, result, minSum);
        return result[0];
    }

    private int divideConquer(TreeNode root, TreeNode[] result, int[] minSum) {
        if (root == null) {
            return 0;
        }

        int left = divideConquer(root.left, result, minSum);
        int right = divideConquer(root.right, result, minSum);
        int sum = left + right + root.val;

        if (sum < minSum[0]) {
            minSum[0] = sum;
            result[0] = root;
        }
        return sum;
    }
}

/////////////////////////////////////////////////////////////////////////////////

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
     * @return: the root of the minimum subtree
     */
    TreeNode minRoot = null;
    int minSum = Integer.MAX_VALUE;

    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        dfs(root);
        return minRoot;
    }

    // 递归求解子数和
    private int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int leftSum = dfs(root.left);
        int rightSum = dfs(root.right);
        int subSum = leftSum + rightSum + root.val;

        if (subSum < minSum) {
            minSum = subSum;
            minRoot = root;
        }
        return subSum;
    }
}

//////////////////////////////////////////////////////////
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
    public TreeNode minRoot;
    public int minSum, wholeTreeSum;
    public ResultType(int minSum, int wholeTreeSum, TreeNode minRoot) {
        this.minSum = minSum;
        this.wholeTreeSum = wholeTreeSum;
        this.minRoot = minRoot;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // write your code here
        ResultType res = dfs(root);
        return res.minRoot;
    }

    private ResultType dfs(TreeNode root) {
        if (root == null) {
            return new ResultType(Integer.MAX_VALUE, 0, null);
        }

        ResultType leftResult = dfs(root.left);
        ResultType rightResult = dfs(root.right);

        ResultType result = new ResultType(
            leftResult.wholeTreeSum + rightResult.wholeTreeSum + root.val,
            leftResult.wholeTreeSum + rightResult.wholeTreeSum + root.val,
            root
        );

        if (leftResult.minSum < result.minSum) {
            result.minSum = leftResult.minSum;
            result.minRoot = leftResult.minRoot;
        }

        if (rightResult.minSum < result.minSum) {
            result.minSum = rightResult.minSum;
            result.minRoot = rightResult.minRoot;
        }
        return result;
    }
}