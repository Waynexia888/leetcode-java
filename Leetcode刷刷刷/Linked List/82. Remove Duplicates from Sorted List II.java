// Given a sorted linked list, delete all nodes that have duplicate numbers, 
// leaving only distinct numbers from the original list.

// Return the linked list sorted as well.

// Example 1:

// Input: 1->2->3->3->4->4->5
// Output: 1->2->5
// Example 2:

// Input: 1->1->1->2->3
// Output: 2->3




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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        
        while (pre.next != null && pre.next.next != null) {
            if (pre.next.val == pre.next.next.val) {
                int sameNum = pre.next.val;
                while (pre.next != null && pre.next.val == sameNum) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }
        return dummy.next;
    }
}


// 本题思想： 删除链表的重复节点（仅保留非重复的节点）
// 因为头节点有可能会被删除， 因此使用dummy node
// 为什么while循环的结束条件是： pre.next != null && pre.next.next != null？
// 因为我们要判断任意2个节点的值是否相等，所以第1个节点和第2个节点不能为null
// 有一种特殊情况， dummy -> 1 -> 1 -> 1 -> 3 -> 5 -> null
// 我们不能碰到两个节点的值相等就删除该节点，因为有可能有3个节点的值都是一样的
// 因此需要碰到两个相等的节点值时，需要用一个变量保存那个相等的值，然后写一个while循环来一个一个删除相等的节点 
// 时间复杂度: O(n), 因为只遍历了一遍链表
// 空间复杂度: O(1)