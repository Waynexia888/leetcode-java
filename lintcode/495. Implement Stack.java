Implement a stack. You can use any data structure inside a stack except stack itself to implement it.

Example
Example 1:

Input:
push(1)
pop()
push(2)
top()  // return 2
pop()
isEmpty() // return true
push(3)
isEmpty() // return false
Example 2:

Input:
isEmpty()


public class Stack {
    /*
     * @param x: An integer
     * @return: nothing
     */
    private List<Integer> list = new ArrayList<>();
    public void push(int x) {
        // write your code here
        list.add(x);
    }

    /*
     * @return: nothing
     */
    public void pop() {
        // write your code here
        int size = list.size();
        if (size > 0) {
            list.remove(size - 1);
        }
        return;
    }

    /*
     * @return: An integer
     */
    public int top() {
        // write your code here
        int size = list.size();
        return list.get(size - 1);
        
    }

    /*
     * @return: True if the stack is empty
     */
    public boolean isEmpty() {
        // write your code here
        return list.size() == 0;
    }
}

