/**
 * Definition for ListNode.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int val) {
 *         this.val = val;
 *         this.next = null;
 *     }
 * }
 */ 
public class Solution {
    /**
     * @param lists: a list of ListNode
     * @return: The head of one sorted list.
     */
    public ListNode mergeKLists(List<ListNode> lists) {  
        // time: O(nlogk)
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(), new Comparator<ListNode>(){
            @Override
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        });
       
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode head = minHeap.poll();
            current.next = head;
            current = current.next;
            if (head.next != null) {
                minHeap.offer(head.next);
            }
        }
        return dummy.next;
    }
}
