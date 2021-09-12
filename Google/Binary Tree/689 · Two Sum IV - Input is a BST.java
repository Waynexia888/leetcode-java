Lintcode 689 · Two Sum IV - Input is a BST

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
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    private int[] results;
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return results;
        }
        results = new int[2];
        Set<Integer> set = new HashSet<>();
        inorder(root, n, set);
        return results;
    }

    private void inorder(TreeNode root, int n, Set<Integer> set) {
        if (root == null) {
            return;
        }
        inorder(root.left, n, set);
        if (set.contains(n - root.val)) {
            results[0] = root.val;
            results[1] = n - root.val;
            return;
        } else {
            set.add(root.val);
        }
        inorder(root.right, n, set);
    }
}

///////////////////////////////////////////////////////////
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
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        List<Integer> list = new ArrayList<>();
        inorder(root, list);
        
        int[] results = new int[2];
        int left = 0, right = list.size() - 1;
        while (left < right) {
            int sum = list.get(left) + list.get(right);
            if (sum == n) {
                results[0] = list.get(left);
                results[1] = list.get(right);
                break;
            } else if (sum < n) {
                left++;
            } else {
                right--;
            }
        }
        return results;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, list);
        list.add(root.val);
        inorder(root.right, list);
    }
}

///////////////////////////////////////////////////////////////////
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
     * @param : the root of tree
     * @param : the target sum
     * @return: two numbers from tree which sum is n
     */
 
    public int[] twoSum(TreeNode root, int n) {
        // write your code here
        if (root == null) {
            return null;
        }
        // results = new int[2];
        List<int[]> list = new ArrayList<>();
        Set<Integer> set = new HashSet<>();
        inorder(root, n, set, list);
        return list.get(0);
    }

    private void inorder(TreeNode root, int n, Set<Integer> set, List<int[]> list) {
        if (root == null) {
            return;
        }
        inorder(root.left, n, set, list);
        if (set.contains(n - root.val)) {
            // results[0] = root.val;
            // results[1] = n - root.val;
            list.add(new int[]{root.val, n - root.val});
            return;
        } else {
            set.add(root.val);
        }
        inorder(root.right, n, set, list);
    }
}