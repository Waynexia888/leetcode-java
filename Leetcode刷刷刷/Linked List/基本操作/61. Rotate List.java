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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }
        
        // count the length; 
        // and connect the tail node to the head node
        int length = 1;
        ListNode index = head;
        while (index.next != null) {
            index = index.next;
            length++;
        }
        index.next = head;
        
        // find the node before the result node
        // cut the head node off
        for (int i = 1; i < length - k % length; i++) {
            head = head.next;
        }
        
        ListNode result = head.next;
        head.next = null;
        
        return result; 
    }
}



// Time: O(n); space: O(1)
