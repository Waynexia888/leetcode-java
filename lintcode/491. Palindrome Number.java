// public class Palindrome_Number {
//     /**
//      * @param num: a positive number
//      * @return: true if it's a palindrome or false
//      */
//     public boolean isPalindrome(int num) {
//         // 方法1: 这道验证回文数字的题如果将数字转为字符串，就变成了验证回文字符串的题，
//         // 时间复杂度O(n), 空间复杂度O(1)
//         String str = Integer.toString(num);

//         int left = 0, right = str.length() - 1;
//         while (left < right) {
//             while (left < right && !isValid(str.charAt(left))) {
//                 left++;
//             }

//             while (left < right && !isValid(str.charAt(right))) {
//                 right--;
//             }

//             if (left < right && (str.charAt(left) != str.charAt(right))) {
//                 return false;
//             }
//             left++;
//             right--;
//         }
//         return true;

//     }

//     private boolean isValid(char c) {
//         return Character.isDigit(c);
//     }
// }


public class Solution {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     */
    public boolean isPalindrome(int num) {
        // 方法2: 判断数字是否为回文数
        // 翻转数字比较相等即可
        // 注意负数不是回文数
        if (num < 0) {
            return false;
        }

        // 如何翻转一个数字？
        int temp = num;
        int reverse = 0;
        while (temp > 0) {
            reverse = reverse * 10 + temp % 10;
            temp /= 10;
        }
        return num == reverse;
    }
}

// 个位数: 0 * 10 + 1232 % 10 = 2， reverse = 2, temp = 123
// 十位数：2 * 10 + 123 % 10 = 23, reverse = 23, temp = 12
// 百位数：23 * 10 + 12 % 10 = 232, reverse = 232, temp = 1
// 千位数：232 * 10 + 1 % 10 = 2321, reverse = 2321, temp = 0

///////////////////////////////////////////////////////////
// 1232
// 个位数： 1232 % 10 = 2
// 十位数： 1232 / 10 % 10 = 3
// 百位数： 1232 / 100 % 10 = 2
// 千位数： 1232 / 1000 % 10 = 1
// 2 * 1000 + 3 * 100 + 2 * 10 + 1 = 2321
