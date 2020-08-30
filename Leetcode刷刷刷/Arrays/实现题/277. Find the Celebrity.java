// Suppose you are at a party with n people (labeled from 0 to n - 1) and among 
// them, there may exist one celebrity. The definition of a celebrity is that all 
// the other n - 1 people know him/her but he/she does not know any of them.

// Now you want to find out who the celebrity is or verify that there is not one. 
// The only thing you are allowed to do is to ask questions like: "Hi, A. Do you 
// know B?" to get information of whether A knows B. You need to find out the 
// celebrity (or verify there is not one) by asking as few questions as possible 
// (in the asymptotic sense).

// You are given a helper function bool knows(a, b) which tells you whether A knows
// B. Implement a function int findCelebrity(n). There will be exactly one 
// celebrity if he/she is in the party. Return the celebrity's label if there is 
// a celebrity in the party. If there is no celebrity, return -1.



/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

public class Solution extends Relation {
    public int findCelebrity(int n) {
        // 只有1个人的时候，没有人认识名人，所以返回-1
        if (n < 2) { 
            return -1;
        }
        
        // 这一个for 循环只能单向的判断谁可能是名人， 
        // 但是如果存在环形的关系， 就没法准确的判断谁是名人或者是否有名人
        int result = 0;
        for (int i = 1; i < n; i++) {
            // 如果result 认识i， 说明result不是名人， 但i有可能是名人
            if (knows(result, i)) {
                result = i;
            }
        }
        
        // 如果result（名人）认识i， 或者i不认识result（名人），说明没有名人存在
        for (int i = 0; i < n; i++) {
            if (result != i && (knows(result, i) || !knows(i, result))) {
                return -1;
            }
        }
        return result;
    }
}


// 本题是数组 - 实现题
// 主要考察逻辑思维， 具体问题具体分析
// 围绕着本题的定义：名人不认识任何人， 并且所有人都认识名人
// 时间复杂度: O(n)
// 空间复杂度: O(1)
