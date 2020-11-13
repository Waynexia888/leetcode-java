/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // given [1], n = 1, output is [];
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        int length = 0;
        ListNode index = head;
        ListNode pre = dummy;
        // count the length;
        while (index != null) {
            index = index.next;
            length++;
        }
        
        // find the previous node (pre) of the delete node
        for (int i = 0; i < length - n; i++) {
            pre = pre.next;
        }
        pre.next = pre.next.next;
        return dummy.next;
    }
}


//////////////////////One pass //////////////////////////////////

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // time : O(n); space: O(1)
        if (head == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        // firstly, let fast pointer move n + 1 steps

        for (int i = 0; i <= n; i++) {
            fast = fast.next;
        }
        
        // let slow pointer move to the previous node of the delete node.
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        
        slow.next = slow.next.next;
        return dummy.next;
    }
}