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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // 参考视频： https://www.youtube.com/watch?v=XDO6I8jxHtA
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head; // 用临时变量temp记录当前的节点
            head = head.next;     // 然后不断往后遍历
            temp.next = prev;     // 把当前节点指向prev这个节点
            prev = temp;          // 每次更新prev，即往后移一步
        }
        return prev;
    }
}

///////////////////////////////////
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
     * @param head: n
     * @return: The new head of reversed linked list.
     */
    public ListNode reverse(ListNode head) {
        // write your code here
        if (head == null || head.next == null) {
            return head;
        }

        ListNode prev = null;
        while (head != null) {
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        return prev;
    }
}