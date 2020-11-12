/**
 * Definition for singly-linked list.
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
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        
        int lengthA = getLength(headA);
        int lengthB = getLength(headB);
        
        // cut the length, and make sure their length are equal
        if (lengthA > lengthB) {
            while (lengthA != lengthB) {
                headA = headA.next;
                lengthA--;
            }
        } else {
            while (lengthA != lengthB) {
                headB = headB.next;
                lengthB--;
            }
        }
        
        while (headA != headB) {
            headA = headA.next;
            headB = headB.next;
        }
        return headA;  
    }
    
    private int getLength(ListNode head) {
        int len = 1;
        while (head.next != null) {
            head = head.next;
            len++;
        }
        return len;
    }
}

// time: O(n);
// space: O(1);