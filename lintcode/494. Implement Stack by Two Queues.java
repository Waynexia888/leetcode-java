public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();
    public void push(int x) {
        // write your code here
        queue1.offer(x);
    }
    
    private void moveItems() {
        while (queue1.size() != 1) {
            queue2.offer(queue1.poll());
        }
    }
    
    private void swapQueues() {
        Queue<Integer> temp = queue1;
        queue1 = queue2;
        queue2 = temp;
    }
    
    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        moveItems();
        queue1.poll();
        swapQueues();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        moveItems();
        int item = queue1.poll();
        queue2.offer(item);
        swapQueues();
        return item;
        
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return queue1.isEmpty();
    }
}

stack: [1, 2, 3, 
queue1: to buffer all new elements -> push(x) goes to queue1   
    1, 2, 3
queue2: to buffer (n - 1) elements from queue1 to queue2 one by one, then pop the top element from queue1

after one pop(), queue1 might be empty, then swap queue1 and queue2.(change their address)
make sure queue 1 has elements, queue2 is empty.

time complexity: 
push() -> O(1);
pop() -> O(n);
1st time call pop(): n (pop from queue1) + n (push to queue2) + 1 (pop from queue1) = 2n + 1
2nd time call pop(): n (pop from queue1) + n (push to queue2) + 1 (pop from queue1) = 2n + 1
top() -> O(n);
isEmpty() -> O(n)
