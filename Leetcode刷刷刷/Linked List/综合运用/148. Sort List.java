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
    public ListNode sortList(ListNode head) {
        // the step of merge sort 
        // time: O(nlogn); space: O(n) because recursion
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode middle = getMiddle(head); 
        ListNode next = middle.next;
        middle.next = null;
        // recursion
        return merge(sortList(head), sortList(next));
    }
    
    private ListNode getMiddle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode merge(ListNode a, ListNode b) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while (a != null && b != null) {
            if (a.val <= b.val) {
                cur.next = a;
                a = a.next;
            } else {
                cur.next = b;
                b = b.next;
            }
            cur = cur.next;
        }
        
        if (a != null) {
            cur.next = a;
        }
        
        if (b != null) {
            cur.next = b;
        }
        return dummy.next;
    }
}