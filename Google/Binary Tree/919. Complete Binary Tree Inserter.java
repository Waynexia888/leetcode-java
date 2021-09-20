Leetcode 919. Complete Binary Tree Inserter

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class CBTInserter {
    private Queue<TreeNode> queue;
    private TreeNode root;
    public CBTInserter(TreeNode root) {  // preprocessing take O(N) time, where n is the number of nodes
        this.root = root;
        queue = new LinkedList<>();
        queue.offer(root);
        
        while (!queue.isEmpty()) {
            TreeNode temp = queue.peek();
            // 当前一层左右子树不满
            if (temp.left == null || temp.right == null) {
                break;
            }
            queue.offer(temp.left);
            queue.offer(temp.right);
            queue.poll();
        }
    }
    
    public int insert(int val) {  // take O(1) time
        TreeNode node = new TreeNode(val);
        // 不能pop()的原因是，万一加上一个node 还是不满，所以不能pop
        TreeNode cur = queue.peek();
        if (cur.left == null) {
            cur.left = node;
        } else {
            cur.right = node;
            //右子树满了以后,需要把当前的
            queue.offer(cur.left);
            queue.offer(cur.right);
            queue.poll();
        }
        return cur.val;
    }
    
    public TreeNode get_root() { // take O(1) time
        return root;
    }
}

/**
 * Your CBTInserter object will be instantiated and called as such:
 * CBTInserter obj = new CBTInserter(root);
 * int param_1 = obj.insert(val);
 * TreeNode param_2 = obj.get_root();
 */