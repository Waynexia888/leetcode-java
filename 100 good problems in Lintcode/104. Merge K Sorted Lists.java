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
        if (lists == null || lists.size() == 0) {
            return null;
        }
        
        // 建立一个大小为3的最小堆，从小到大排
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>(lists.size(), (a, b) -> a.val - b.val);
        
        for (ListNode list: lists) {
            if (list != null) {
                minHeap.offer(list);
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

time : O(nlog(k)) where n is the total number of node
k is the size of lists; heap 的offer 和 poll操作都是log(k)复杂度

space: O(n)