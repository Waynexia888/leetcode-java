public class MyQueue {
    private Stack<Integer> s1 = new Stack<>();
    private Stack<Integer> s2 = new Stack<>();

    public MyQueue() {
        // do intialization if necessary
    }

    /*
     * @param element: An integer
     * 
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        s2.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        // s2 = [1, 2, 3] -> move()操作 -> s1 = [3, 2, 1]
        // 当s1是空的时候，才执行move操作
        if (s1.isEmpty()) {
            move();
        }
        return s1.pop();

    }

    public void move() {
        while (!s2.isEmpty()) {
            s1.push(s2.pop());
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (s1.isEmpty()) {
            move();
        }
        return s1.peek(); // 获取栈顶元素
    }
}