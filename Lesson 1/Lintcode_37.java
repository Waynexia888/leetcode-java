// Lintcode 37: 反转一个3位整数  · reverse 3 digit integer

// 题目描述: Reverse a 3-digit integer.
// 反转一个只有3位数的整数。

// 样例 1:
// 输入: number = 123
// 输出: 321

// 样例 2:
// 输入: number = 900
// 输出: 9

public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    public int reverseInteger(int number) {
        // write your code here
        // 123 -> 321
        // 321 -> 3 * 100 + 2 * 10 + 1 
        // 123 -> 取出个位数

        int a = number % 10; // 3
        int b = number / 10 % 10; // 2
        int c = number / 100 % 10; // 1
        return a * 100 + b * 10 + c;
    }
}
