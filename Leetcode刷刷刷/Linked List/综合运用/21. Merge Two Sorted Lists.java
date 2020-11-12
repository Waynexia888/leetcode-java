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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        
        while (p1 != null && p2 != null) {
            if (p1.val > p2.val) {
                cur.next = new ListNode(p2.val);
                p2 = p2.next;
            } else {
                cur.next = new ListNode(p1.val);
                p1 = p1.next;
            }
            cur = cur.next;
        }
        
        if (p1 != null) {
            cur.next = p1;
        }
        
        if (p2 != null) {
            cur.next = p2;
        }
        return dummy.next;
    }
}

// time: O(n);
// space: O(n) because every time it create a new node