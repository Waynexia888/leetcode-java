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
     * This method will be invoked first, you should design your own algorithm 
     * to serialize a binary tree which denote by a root node to a string which
     * can be easily deserialized by your own "deserialize" method later.
     */
    public String serialize(TreeNode root) {
        // write your code here
        if (root == null) {
            return "{}";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);
        sb.append("{");

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node == null) {
                sb.append("#");
            } else {
                sb.append(node.val);
                queue.offer(node.left);
                queue.offer(node.right);
            }
            if (!queue.isEmpty()) {
                sb.append(",");
            } 
        }

        sb.append("}");
        return sb.toString();
    }

    /**
     * This method will be invoked second, the argument data is what exactly
     * you serialized at method "serialize", that means the data is not given by
     * system, it's given by your own serialize method. So the format of data is
     * designed by yourself, and deserialize it here as you serialize it in 
     * "serialize" method.
     */
    public TreeNode deserialize(String data) {
        // write your code here
        if (data == null || data.equals("{}")) {
            return null;
        }

        String[] arr = data.substring(1, data.length() - 1).split(",");
        TreeNode root = new TreeNode(Integer.parseInt(arr[0]));

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isLeftChild = true;
        
        for (int i = 1; i < arr.length; i++) {
            if (!arr[i].equals("#")) {
                TreeNode child = new TreeNode(Integer.parseInt(arr[i]));
                if (isLeftChild) {
                    queue.peek().left = child;
                } else {
                    queue.peek().right = child;
                }
                queue.offer(child);  
            }

            if (!isLeftChild) {
                queue.poll();
            }
            isLeftChild = !isLeftChild;
        }
        return root;
    }
}

// "3,9,20,#,#,15,7"
// ["3", "9", "20", "#"]
// string to int