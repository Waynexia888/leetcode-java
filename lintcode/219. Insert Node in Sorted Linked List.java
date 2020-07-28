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
        // write your code here
        ListNode node = new ListNode(val);
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 因为要插入的点有可能在head的前面，因此是从dummy点开始
        // 并且每次都是对dummy.next进行比较，这样能在要插入的位置的前一个位置停下来
        ListNode current = dummy;
        while (current.next != null && current.next.val < val) {
            current = current.next;
        }
        
        // 找到合适的位置后停下来
        node.next = current.next;
        current.next = node;
        
        return dummy.next;
    }
}