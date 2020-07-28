/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param head: 
     * @return: nothing
     */
    public int countNodesII(ListNode head) {
        // 
        int count = 0;
        while (head != null) {
            if (head.val > 0 && head.val % 2 != 0) {
                count++;
            }
            head = head.next;
        }
        return count;
    }
}