// Merge two sorted linked lists and return it as a new sorted list. 
// The new list should be made by splicing together the nodes of the first two lists.

// Example:

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4



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
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                cur.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            cur = cur.next;
        }
        
        if (l1 != null) {
            cur.next = l1;
        }
        
        if (l2 != null) {
            cur.next = l2;
        }
        
        return dummy.next;
    }
}

// 本题思想： 链表的合并操作
// 以上是非递归操作
// 时间复杂度: O(n + m), n是l1的length， m是l2的length
// 空间复杂度: O(1); The iterative approach only allocates a few pointers, 
// so it has a constant overall memory footprint.


///////////////////////////////////////////////////////////////////////

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
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }
}

// 以上是非递归的写法， 不推荐这样写，因为会改变输入input
// 时间复杂度: O(m + n)
// 空间复杂度: O(m + n)
// The first call to mergeTwoLists does not return until the ends of both 
// l1 and l2 have been reached, so n + mn+m stack frames consume O(n + m)O(n+m) space.