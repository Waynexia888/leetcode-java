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
     * @param head: The head of linked list.
     * @param val: An integer.
     * @return: The head of new linked list.
     */
    public ListNode insertNode(ListNode head, int val) {
        // given: null, val = 5,  5->null,
        // use a dummy node to begin with, then find the position where the node.val <= val, then insert the node at location + 1
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        head = dummy;
        
        while (head.next != null && head.next.val <= val) {
            head = head.next;
        }
        node.next = head.next;
        head.next = node;
        
        return dummy.next;
    }
}