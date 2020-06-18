/**
 * Definition of TreeNode: public class TreeNode { public int val; public
 * TreeNode left, right; public TreeNode(int val) { this.val = val; this.left =
 * this.right = null; } } Definition for singly-linked list. public class
 * ListNode { int val; ListNode next; ListNode(int x) { val = x; } }
 */
public class Solution {
    /**
     * @param root the root of binary tree
     * @return a lists of linked list
     */
    public List<ListNode> binaryTreeToLists(TreeNode root) {
        // 本题的思想还是基于BFS实现二叉树的分层遍历
        List<ListNode> result = new ArrayList<>();

        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            ListNode dummy = new ListNode(-1);
            ListNode temp = dummy;

            int n = queue.size();
            for (int i = 0; i < n; i++) {
                TreeNode cur = queue.poll();
                temp.next = new ListNode(cur.val);
                temp = temp.next;

                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
            result.add(dummy.next);
        }
        return result;
    }
}