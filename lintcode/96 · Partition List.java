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
     * @param x: An integer
     * @return: A ListNode
     */
    public ListNode partition(ListNode head, int x) {
        // write your code here
        if (head == null) {
            return null;
        }

        ListNode dummy1 = new ListNode(-1);
        ListNode dummy2 = new ListNode(-1);
        ListNode cur1 = dummy1, cur2 = dummy2;

        while (head != null) {
            if (head.val < x) {
                cur1.next = head;
                cur1 = cur1.next;
                head = head.next;
            } else {
                cur2.next = head;
                cur2 = cur2.next;
                head = head.next;
            }
        }

        cur2.next = null;
        cur1.next = dummy2.next;
        return dummy1.next;
    }
}