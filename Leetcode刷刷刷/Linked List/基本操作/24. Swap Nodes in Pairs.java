// Given a linked list, swap every two adjacent nodes and return its head.

// You may not modify the values in the list's nodes, only nodes itself may be changed.

 

// Example:

// Given 1->2->3->4, you should return the list as 2->1->4->3.


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
    public ListNode swapPairs(ListNode head) {
        // 如果链表是空 或者链表只有一个节点的时候
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode l1 = dummy;
        ListNode l2 = head;
        
        while (l2 != null && l2.next != null) {
            ListNode nextStart = l2.next.next;
            l1.next = l2.next;
            l2.next.next = l2;
            l2.next = nextStart;
            l1 = l2;
            l2 = l2.next;
        }
        return dummy.next;
    }
}


// 本题思想：链表的基本操作
// 注意链表的题目一定要按照顺序去想
// 时间复杂度: O(n)
// 空间复杂度: O(1)