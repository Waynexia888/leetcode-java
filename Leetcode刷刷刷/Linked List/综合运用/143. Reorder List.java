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
    public void reorderList(ListNode head) {
        // time: O(n), space: O(1)
        if (head == null || head.next == null) {
            return;
        }
        
        ListNode middle = getMiddle(head);
        ListNode next = reverse(middle.next);
        middle.next = null;
        ListNode p1 = head;
        ListNode p2 = next;
      
        while (p1 != null && p2 != null) {
            ListNode n1 = p1.next;
            ListNode n2 = p2.next;
            p1.next = p2;
            p2.next = n1;
            p1 = n1;
            p2 = n2;
        }   
    }
    
//     1 -> 5 -> 2 -> 4 -> 3 -> null
                    
//     1 -> 2 -> 3 -> null

//     5 -> 4 -> null
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = pre;
            pre = head;
            head = temp;
        }
        return pre;
    }
}