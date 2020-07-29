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
     * @param head: The first node of linked list
     * @param n: the start index
     * @param m: the end node
     * @return: A ListNode
     */
    public ListNode deleteNode(ListNode head, int n, int m) {
        // 如果要删除的是头节点，即n = 0
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        
        ListNode prev = dummy;
        ListNode end = dummy.next;
        
        // n 这个位置的前一位
        while (n > 0) {
            prev = prev.next;
            n--;
        }
        
        // m 这个位置的后一位
        while (m >= 0) {
            end = end.next;
            m--;
        }
        
        prev.next = end;
        return dummy.next;
    }
}