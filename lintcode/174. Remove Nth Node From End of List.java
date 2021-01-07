/**
 * Definition for ListNode public class ListNode { int val; ListNode next;
 * ListNode(int x) { val = x; next = null; } }
 */

public class Solution {
    /**
     * @param head: The first node of linked list.
     * @param n:    An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 快慢指针
        // 先让快指针走n步，然后快慢一起走，当快指针走到尾的时候， 慢指针刚好走到要删除节点的前一个位置，然后完成删除操作；
        if (n <= 0)
            return null;

        ListNode dummy = new ListNode(-1);
        dummy.next = head;

        ListNode slow = dummy, fast = dummy;
        for (int i = 0; i <= n; i++) {
            if (fast == null)
                return head;
            fast = fast.next;
        }

        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        slow.next = slow.next.next;
        return dummy.next;
    }
}

/////////////////////////////////////////

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
     * @param head: The first node of linked list.
     * @param n: An integer
     * @return: The head of linked list.
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // write your code here
        if (head == null || n <= 0) {
            return head;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
   
        
        ListNode slow = dummy;
        ListNode fast = dummy;
        
        for (int i = 0; i <= n; i++) {
            // Do not remove anything when n > the length of a list.
            if (fast == null) {
                return head;
            }
            fast = fast.next;
        }
        
        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        
        return dummy.next;
    }
}


/////////////////////////////////////