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
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        // write your code here
        List<Integer> results = new ArrayList<>();
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode current = head;
        while (current != null) {
            results.add(current.val);
            current = current.next;
        }
        
        Collections.reverse(results);
        return results;
    }
}

//////////////////////////////////////////////////

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
     * @param head: the given linked list
     * @return: the array that store the values in reverse order 
     */
    public List<Integer> reverseStore(ListNode head) {
        // 先把链表反转，然后一个一个放进数组里
        ListNode prev = null;
        while (head != null) {
            ListNode temp = head;
            head = head.next;
            temp.next = prev;
            prev = temp;
        }
        
        // 此时以prev开始的头节点就是反转好的链表
        List<Integer> results = new ArrayList<>();
        ListNode current = prev;
        while (current != null) {
            results.add(current.val);
            current = current.next;
        }
        return results;
    }
}