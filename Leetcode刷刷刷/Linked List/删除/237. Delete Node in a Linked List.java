// Write a function to delete a node (except the tail) in a singly linked list, 
// given only access to that node.

// Given linked list -- head = [4,5,1,9], which looks like following:


// Example 1:

// Input: head = [4,5,1,9], node = 5
// Output: [4,1,9]
// Explanation: You are given the second node with value 5, the linked list 
// should become 4 -> 1 -> 9 after calling your function.



/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        if (node == null) return;
        // Because we know that the node we want to delete is not the tail of the list
        node.val = node.next.val;
        node.next = node.next.next;
    }
}

// 本题思路： 删除链表节点（非尾部节点）
// 时间复杂度: O(1)
// 空间复杂度: O(1)