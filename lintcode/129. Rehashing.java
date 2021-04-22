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
     * @param hashTable: A list of The first node of linked list
     * @return: A list of The first node of linked list which have twice size
     */    
    public ListNode[] rehashing(ListNode[] hashTable) {
        // write your code here
        int size = hashTable.length * 2;
        ListNode[] results = new ListNode[size];
        
        if (hashTable == null || hashTable.length == 0) {
            return results;
        }
        
        for (ListNode node : hashTable) {
            while (node != null) {
                ListNode currentNode = new ListNode(node.val);
                int index = (node.val % size + size) % size;
                if (results[index] != null) {
                    ListNode cur = results[index];
                    while (cur.next != null) {
                        cur = cur.next;
                    }
                    cur.next = currentNode;
                } else {
                    results[index] = currentNode;
                }
                node = node.next;
            }
        }
        return results;
    }
};
