Leetcode 1047. Remove All Adjacent Duplicates In String

class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (stack.isEmpty() || stack.peek() != c) {
                stack.push(c);
            } else {
                stack.pop();
            }
        }
        
        char[] arr = new char[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            arr[i] = stack.pop();
        }
        return String.valueOf(arr);
    }
}