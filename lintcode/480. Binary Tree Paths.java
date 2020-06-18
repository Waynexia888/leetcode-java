// /**
//  * Definition of TreeNode: public class TreeNode { public int val; public
//  * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
//  * this.right = null; } }
//  */

// public class Solution {
//     /**
//      * @param root: the root of the binary tree
//      * @return: all root-to-leaf paths
//      */
//     public List<String> binaryTreePaths(TreeNode root) {
//         // divide conquer
//         List<String> paths = new ArrayList<>();

//         if (root == null) {
//             return paths;
//         }

//         List<String> leftPaths = binaryTreePaths(root.left);
//         List<String> rightPaths = binaryTreePaths(root.right);

//         for (String path : leftPaths) {
//             paths.add(root.val + "->" + path);
//         }

//         for (String path : rightPaths) {
//             paths.add(root.val + "->" + path);
//         }

//         // root is a leaf
//         if (paths.size() == 0) {
//             paths.add("" + root.val);
//         }

//         return paths;

//     }
// }

////////////////////////////////////////////////////////////
/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } }
 */

public class Solution {
    /**
     * @param root: the root of the binary tree
     * @return: all root-to-leaf paths
     */
    public List<String> binaryTreePaths(TreeNode root) {
        // write your code here
        List<String> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        // 99%的题，不用单独处理叶子节点
        // 这里需要单独处理的原因是： root是None的结果，没有办法用于构造root是叶子的结果
        if (root.left == null && root.right == null) {
            result.add(root.val + "");
        }

        List<String> leftPaths = binaryTreePaths(root.left);
        List<String> rightPaths = binaryTreePaths(root.right);

        for (String path : leftPaths) {
            result.add(root.val + "->" + path);
        }

        for (String path : rightPaths) {
            result.add(root.val + "->" + path);
        }

        return result;

    }
}