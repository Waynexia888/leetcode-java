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

///////////////////////////

public class MyQueue {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    public MyQueue() {
        // do intialization if necessary
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }
    
    private void stack1ToStack2() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        // write your code here
        stack1.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (stack2.isEmpty() == true) {
            this.stack1ToStack2();
        }
        return stack2.pop();
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        if (stack2.isEmpty() == true) {
            this.stack1ToStack2();
        }
        return stack2.peek();
    }
}

stack1: to buffer all new elements -> push(x) goes to stack1
stack2: to pop out the 1st elements
    case2.1 if stack2 is empty, then we move all the element from stack1 to stack2 one by one. Then pop the top element from stack2
    case2.2 if stack2 is not empty, then we call stack2.pop()