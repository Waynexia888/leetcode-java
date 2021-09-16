Lintcode 104 · Merge K Sorted Lists

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
        // write your code here
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a, b) -> (a.val - b.val));
        for (ListNode node : lists) {
            if (node != null) {
                minHeap.offer(node);
            }
        }
        
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        
        while (!minHeap.isEmpty()) {
            ListNode node = minHeap.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                minHeap.offer(node.next);
            }
        }
        return dummy.next;
    }
}

// create a minHeap
// traverse the lists, if the ListNode is not null, add it to minHeap
// create a dummy node
// every time you poll a node from minHeap, insert the node after the dummy
