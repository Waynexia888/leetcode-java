public class MyQueue {
    /*
     * @param item: An integer
     * @return: nothing
     */
    public ListNode head, tail;
    public MyQueue() {
        head = tail = null;
    }
    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            tail = new ListNode(item);
            head = tail;
        } else {
            tail.next = new ListNode(item);
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head != null) {
            int val = head.val;
            head = head.next;
            return val;
        }
        return -1;
    }
}

class ListNode {
    public int val;
    public ListNode next;
    public ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

enqueue() -> O(1)
dequeue() -> O(1)