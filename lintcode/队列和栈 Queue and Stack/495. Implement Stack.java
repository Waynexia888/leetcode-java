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

push() -> O(1)
pop() -> O(1)
top() -> O(1)
isEmpty() -> O(1)

ArrayList 和 LinkedList CRUD 时间复杂度：
https://blog.csdn.net/weixin_43864727/article/details/88384142

