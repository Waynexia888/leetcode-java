Leetcode 735. Asteroid Collision

class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        
        for (int a : asteroids) {
            if (a > 0) {
                stack.push(a);
            }
            
            if (a < 0) {
                while (!stack.isEmpty() && stack.peek() > 0 && stack.peek() < Math.abs(a)) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(a);
                }
                if (stack.peek() == Math.abs(a)) {
                    stack.pop();
                }
            }
        }
        
        int[] results = new int[stack.size()];
        for (int i = stack.size() - 1; i >= 0; i--) {
            results[i] = stack.pop();
        }
        return results;
    }
}

