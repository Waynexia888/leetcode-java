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
    public ListNode partition(ListNode head, int x) {
        // time: O(n); 
        // space: O(n) because in the for loop, everytime we create a temp node.
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode smallHead = new ListNode(-1);
        ListNode bigHead = new ListNode(-1);
        ListNode small = smallHead;
        ListNode big = bigHead;
        
        // partition each node to the correct list
        while (head != null) {
            ListNode temp = new ListNode(head.val);
            if (head.val < x) {
                small.next = temp;
                small = small.next;
            } else {
                big.next = temp;
                big = big.next;
            }
            head = head.next;
        }
        // connect the tail of smallHead to the head of bigHead
        small.next = bigHead.next;
        return smallHead.next;
    }
}