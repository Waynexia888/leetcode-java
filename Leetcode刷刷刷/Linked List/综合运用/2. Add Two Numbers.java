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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // time: O(n); space: O(n) because every time we create a new node
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        ListNode p1 = l1, p2 = l2;
        int sum = 0;
        
        // here, use ||, not &&
        while (p1 != null || p2 != null) {
            if (p1 != null) {
                sum += p1.val;
                p1 = p1.next;
            }
            
            if (p2 != null) {
                sum += p2.val;
                p2 = p2.next;
            }
            
            cur.next = new ListNode(sum % 10);
            sum /= 10;
            cur = cur.next;
        }
        
        // eg: [2, 3, 6] [5, 6, 4] = [7, 9, 0, 1]
        if (sum == 1) {
            cur.next = new ListNode(1);
        }
        return dummy.next;
    }
}