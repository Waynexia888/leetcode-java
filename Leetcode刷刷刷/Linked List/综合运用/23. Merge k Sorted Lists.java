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
    public ListNode mergeKLists(ListNode[] lists) {
        // time: O(nlog(k)) where k is the length of lists; n is the number of node
        // space: O(n)
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);
        
        for (ListNode list : lists) {
            if (list != null) {
                minHeap.offer(list);
            }
        }
        
        while (!minHeap.isEmpty()) {
            // dummy -> 1 -> 4 -> 5
            //         cur
            // 
            cur.next = minHeap.poll();
            cur = cur.next;
            if (cur.next != null) {
                minHeap.offer(cur.next);
            }
        }
        return dummy.next;
    }
}