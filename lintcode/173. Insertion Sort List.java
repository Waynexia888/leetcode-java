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
     * @return: The head of linked list.
     */
    public ListNode insertionSortList(ListNode head) {
        // 基于插入排序的思想，一个有序，一个无序，不停的交换位置
        if (head == null || head.next == null) {
            return head;
        }
        
        // 引入哨兵节点
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        // 引入current指针 指向head这个reference，避免直接使用head， 造成head的修改
        ListNode current = head;
        // 引入prev， temp这两个节点，方便后面找出要交换节点的两个位置
        ListNode prev = null;
        ListNode temp = null;
        
        while (current != null && current.next != null) {
            if (current.val <= current.next.val) {
                current = current.next;
            } else {
                // 使用temp保存要交换的这个节点位置，避免丢失
                temp = current.next;
                current.next = current.next.next;
                prev = dummy;
                // 从头往后遍历，找到第一个比temp大的那个节点的前一个节点
                while (prev.next.val <= temp.val) {
                    prev = prev.next;
                }
                // swap 这个两个节点
                temp.next = prev.next;
                prev.next = temp;
            }
        }
        return dummy.next;
    }
}

// dummy -> 1 -> 3 -> 2 -> 0 -> null
//               |    |
//             cur  cur.next
//  |                 |
// prev              temp
//          |         |
//         prev      temp