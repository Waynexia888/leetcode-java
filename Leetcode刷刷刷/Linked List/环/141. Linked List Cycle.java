// Given a linked list, determine if it has a cycle in it.

// To represent a cycle in the given linked list, we use an integer pos
//  which represents the position (0-indexed) in the linked list where tail 
//  connects to. If pos is -1, then there is no cycle in the linked list.

 

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the 
// second node.



/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}

// 本题思想： 判断链表是否有环
// slow指针走一步， fast指针走两步
// 技巧总结： 当有2个指针的时候，while循环的结束条件，往往是以后面那根指针的结束条件为主
// 时间复杂度: O(n)
// 空间复杂度: O(1)