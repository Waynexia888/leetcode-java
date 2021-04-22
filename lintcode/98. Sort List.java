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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // quick sort 快速排序
        
        if (head == null || head.next == null) {
            return head;
        }
        // 选取middle 为pivot
        ListNode pivot = findMedian(head);
        
        ListNode leftDummy = new ListNode(-1); 
        ListNode leftTail = leftDummy;
        ListNode rightDummy = new ListNode(-1);
        ListNode rightTail = rightDummy;
        ListNode middleDummy = new ListNode(-1);
        ListNode middleTail = middleDummy;
        
        // partition过程
        while (head != null) {
            if (head.val < pivot.val) {
                leftTail.next = head;
                leftTail = head;
            } else if (head.val == pivot.val) {
                middleTail.next = head;
                middleTail = head;
            } else {
                rightTail.next = head;
                rightTail = head;
            }
            head = head.next;
        }
        leftTail.next = null;
        rightTail.next = null;
        middleTail.next = null;
        
        //递归
        ListNode left = sortList(leftDummy.next);
        ListNode right = sortList(rightDummy.next);
        
        return concat(left, middleDummy.next, right);
    }
    
    private ListNode findMedian(ListNode head) {
        ListNode slow = head;
        ListNode fast = head.next;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
    
    private ListNode concat(ListNode left, ListNode middle, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        tail.next = left;
        tail = getTail(tail);
        tail.next = middle;
        tail = getTail(tail);
        tail.next = right;
        tail = getTail(tail);
        return dummy.next;
    }
    
    private ListNode getTail(ListNode head) {
        if (head == null) {
            return null;
        }
        
        while (head.next != null) {
            head = head.next;
        }
        return head;
    }
}

//////////////////////////////////////////////////////////////
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
     * @param head: The head of linked list.
     * @return: You should return the head of the sorted linked list, using constant space complexity.
     */
    public ListNode sortList(ListNode head) {
        // 用一个list来保存每一个节点的值， 然后对list进行排序，最后对list遍历并且构建新的链表
        // time: O(nlogn), space: O(n)
        if (head == null) {
            return null;
        }
        
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode tail = dummy.next;
        
        List<Integer> list = new ArrayList<>();
        while (tail != null) {
            list.add(tail.val);
            tail = tail.next;
        }
        
        Collections.sort(list);
        
        tail = dummy.next;
        for (int i = 0; i < list.size(); i++) {
            tail.val = list.get(i);
            tail = tail.next;
        }
        return dummy.next;
    }
}