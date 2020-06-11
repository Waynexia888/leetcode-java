interface InterfaceQueue {
    void push(int element);

    // define an interface for pop method
    int pop();

    // define an interface for top method
    int top();
}

class ListNode {
    public int val;
    public ListNode next, prev; // 双向链表

    public ListNode(int val) {
        this.val = val;
        prev = next = null;
    }
}

public class MyQueue implements InterfaceQueue {
    /* you can declare your private attributes here */
    private ListNode first, last;

    public MyQueue() {
        // do initialization if necessary
        first = null;
        last = null;
    }

    // 插入操作
    // implement the push method
    @Override
    public void push(int val) {
        if (last == null) {
            last = new ListNode(val);
            first = last;
        } else {
            ListNode node = new ListNode(val);
            last.next = node;
            node.prev = last;
            last = last.next;
        }

    }

    // 出队操作，返回的是队列顶部元素，并且从队列中删除该元素
    // implement the pop method
    @Override
    public int pop() {
        if (first == null) {
            return -1;
        } else {
            ListNode returnValue = first; // 用一个变量记录first val，方便后面返回
            first = first.next; // 这是删除头节点的操作
            if (first == null) { // 删除头节点后，需要判断后面节点是否为空
                last = null;
            } else {
                first.prev = null;
            }

            return returnValue.val;
        }

    }

    // 返回队列顶部元素
    // implement the top method
    @Override
    public int top() {
        if (first != null) {
            return first.val;
        } else {
            return -1;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such: MyQueue queue =
 * new MyQueue(); queue.push(123); queue.top(); will return 123; queue.pop();
 * will return 123 and pop the first element in the queue
 */