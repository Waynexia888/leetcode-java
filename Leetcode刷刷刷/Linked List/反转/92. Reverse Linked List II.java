// Reverse a linked list from position m to n. Do it in one-pass.

// Note: 1 ≤ m ≤ n ≤ length of list.

// Example:

// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL



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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = dummy.next;
        
        // 因为要反转指定的一段链表。那么肯定要知道指定链表头的位置（即cur）
        // 同时也要知道指定链表的前一个节点的位置（即pre）
        for (int i = 1; i < m; i++) {
            pre = pre.next;
            cur = cur.next;
        }
        
        // dummy -> 1 -> 2 -> 3 -> 4 -> 5 -> null
        //         pre  cur  temp
        
        // dummy -> 1 -> 3 -> 2 -> 4 -> 5 -> null
        //         pre       cur  temp
        
        // dummy -> 1 -> 4 -> 3 -> 2 -> 5 -> null
        //         pre            cur
        
        // 此for loop相当于对cur指针移动两次
        for (int i = 0; i < n - m; i++) {
            ListNode temp = cur.next;
            cur.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return dummy.next;
    }
}

// 本题思想： 翻转链表的其中一部分
// 因为 1<= m <= n <= length of list， 即链表的头节点有肯能会被翻转，所以用到dummy node
// 本题使用for loop， 对cur指针（即要反转的那一段链表的头节点）进行n - m次数操作
// 每一次两两交换位置
// 时间复杂度: o(n)
// 空间复杂度: O(1)