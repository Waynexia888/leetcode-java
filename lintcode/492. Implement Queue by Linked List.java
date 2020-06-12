class Node {
    public int val;
    public Node next;

    public Node(int val) {
        this.val = val;
        next = null;
    }
}

public class MyQueue {
    /*
     * @param item: An integer
     * 
     * @return: nothing
     */
    public Node head, tail;

    public MyQueue() {
        head = tail = null;
    }

    public void enqueue(int item) {
        // write your code here

        if (head == null) {
            tail = new Node(item);
            head = tail;
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head == null) {
            return -1;
        } else {
            int item = head.val;
            head = head.next;
            return item;
        }
    }
}