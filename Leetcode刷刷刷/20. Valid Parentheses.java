class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (Character ch : s.toCharArray()) {
            if (ch == '(') {
                stack.push(')');
            } else if (ch == '[') {
                stack.push(']');
            } else if (ch == '{') {
                stack.push('}');
            } else {
                // e.g. Input: s = '}', 此时的stack是空的，所以返回false；
                if (stack.isEmpty() || stack.pop() != ch) {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}


// time: O(n); space: O(n)
