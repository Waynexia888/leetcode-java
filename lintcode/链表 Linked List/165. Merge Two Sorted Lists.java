/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

public class Solution {
    /**
     * @param l1: ListNode l1 is the head of the linked list
     * @param l2: ListNode l2 is the head of the linked list
     * @return: ListNode head of linked list
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        // write your code here
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        ListNode list1 = l1, list2 = l2;
        
        // 当list1 和 list2都不为空的时候
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                tail.next = list1;
                list1 = list1.next;
                
            } else {
                tail.next = list2;
                list2 = list2.next;
            }
            tail = tail.next;
        }
        
        // while循环结束后，list1还有的情况下
        if (list1 != null) {
            tail.next = list1;
        }
        // while循环结束后，list2还有的情况下
        if (list2 != null) {
            tail.next = list2;
        }
        return dummy.next;
    }
}