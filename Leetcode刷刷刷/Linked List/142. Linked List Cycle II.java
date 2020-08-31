// Given a linked list, return the node where the cycle begins. If there is no 
// cycle, return null.

// To represent a cycle in the given linked list, we use an integer pos which 
// represents the position (0-indexed) in the linked list where tail connects to. 
// If pos is -1, then there is no cycle in the linked list.

// Note: Do not modify the linked list.

 

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        ListNode slow = head;
        ListNode fast = head;
        
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode slow2 = head;
                while (slow != slow2) {
                    slow = slow.next;
                    slow2 = slow2.next;
                }
                return slow;
            }
        }
        return null;
    }
}

// 本题思想： 寻找环的起始节点
// 理解不下来， 背诵即可
// 时间复杂度: O(n)
// 空间复杂度: O(1)
// 当然本题用哈希表来记录是否有重复元素，时间O(n),空间O(n)


////////////////////////////////////////////////////////////////////

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
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        
        Set<ListNode> visited = new HashSet<>();
        ListNode node = head;
        
        while (node != null) {
            if (visited.contains(node)) {
                return node;
            }
            visited.add(node);
            node = node.next;
        }
        return null;
    }
}