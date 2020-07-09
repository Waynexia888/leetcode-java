// /**
//  * Definition of TreeNode: public class TreeNode { public int val; public
//  * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
//  * this.right = null; } }
//  */

// public class Solution {
//     /**
//      * @param root: the root of binary tree
//      * @return: the root of the minimum subtree
//      */

//     public TreeNode minimum_subtree_root = null;
//     public int minimum_subtree_sum = Integer.MAX_VALUE;

//     public TreeNode findSubtree(TreeNode root) {
//         // write your code here
//         getTreeSum(root);
//         return minimum_subtree_root;
//     }

//     // 得到root为根的二叉树所有节点之和
//     // 顺便打个擂台，求出minimum_subtree_sum
//     public int getTreeSum(TreeNode root) {
//         if (root == null) {
//             return 0;
//         }

//         int left_weight = getTreeSum(root.left);
//         int right_weight = getTreeSum(root.right);
//         int root_weight_of_tree = left_weight + right_weight + root.val;

//         if (root_weight_of_tree < minimum_subtree_sum) {
//             minimum_subtree_sum = root_weight_of_tree;
//             minimum_subtree_root = root;
//         }
//         return root_weight_of_tree;
//     }
// }

//////////////////////////////////////////////////////////////////





// divide conquer


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
    public int minSumOfSubtree, sumOfTree;
    public TreeNode rootOfSubtree;
    public ResultType(TreeNode rootOfSubtree, int minSumOfSubtree, int sumOfTree) {
        this.rootOfSubtree = rootOfSubtree;
        this.minSumOfSubtree = minSumOfSubtree;
        this.sumOfTree = sumOfTree;
    }
}

public class Solution {
    /**
     * @param root: the root of binary tree
     * @return: the root of the minimum subtree
     */
    public TreeNode findSubtree(TreeNode root) {
        // 设树的节点数为n。
        // 时间复杂度O(n)， 每个节点会被访问1次，时间复杂度为O(n)。
        // 空间复杂度O(n)， 在树上递归的遍历，最多会在栈上占用O(n)的空间。
        ResultType results = helper(root);
        return results.rootOfSubtree;
    }
    
    private ResultType helper(TreeNode root) {
        // 当当前节点为叶节点为空时，返回0，即为递归出口。
        if (root == null) {
            return new ResultType(null, Integer.MAX_VALUE, 0);
        }
        // 获取左子树的权值和。
        ResultType leftResult = helper(root.left);
        // 获取右子树的权值和。
        ResultType rightResult = helper(root.right);
        // 当前的权值和为整棵二叉树
        ResultType result = new ResultType(
                                    root, 
                                    leftResult.sumOfTree + rightResult.sumOfTree + root.val,  
                                    leftResult.sumOfTree + rightResult.sumOfTree + root.val
                                    );
        // 判断是否在左子树，同时更新返回值
        if (leftResult.minSumOfSubtree < result.minSumOfSubtree) {
            result.minSumOfSubtree = leftResult.minSumOfSubtree;
            result.rootOfSubtree = leftResult.rootOfSubtree;
        }
        // 判断是否在右子树，同时更新返回值
        if (rightResult.minSumOfSubtree < result.minSumOfSubtree) {
            result.minSumOfSubtree = rightResult.minSumOfSubtree;
            result.rootOfSubtree = rightResult.rootOfSubtree;
        }
        // 返回结果在根节点上
        return result;
    }
}
