// Given a sorted linked list, delete all duplicates such that each element appear
//  only once.

// Example 1:

// Input: 1->1->2
// Output: 1->2
// Example 2:

// Input: 1->1->2->3->3
// Output: 1->2->3

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
        
        ListNode cur = head; // 这一步作用是为了不改变input
        while (cur.next != null) {
            if (cur.val == cur.next.val) {
                cur.next = cur.next.next;
            } else {
                cur = cur.next;
            }
        }
        return head;
    }
}

// 本题思路： 删除链表的重复元素
// 需要比较当前的节点的值 与 下一个节点的值的比较
// 如果相等，就删除； 如果不相等， 当前节点向后移动一步
// 时间复杂度: O(n)
// 空间复杂度: O(1)