// Lintcode 9: Fizz Buzz 问题  · fizz buzz

// 题目描述:
// Given number n. Print number from 1 to n. But:
// when number is divided by 3, print "fizz".
// when number is divided by 5, print "buzz".
// when number is divided by both 3 and 5, print "fizz buzz".
// when number can't be divided by either 3 or 5, print the number itself.

// 样例1:
// If n = 15, you should return:
// [
//   "1", "2", "fizz",
//   "4", "buzz", "fizz",
//   "7", "8", "fizz",
//   "buzz", "11", "fizz",
//   "13", "14", "fizz buzz"
// ]

// 样例2:
// If n = 10, you should return:
// [
//   "1", "2", "fizz",
//   "4", "buzz", "fizz",
//   "7", "8", "fizz",
//   "buzz"
// ]


public class Solution {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public ArrayList<String> fizzBuzz(int n) {
        // write your code here
        ArrayList<String> results = new ArrayList<String>(); // []
        for (int i = 1; i <= n; i++) {
            if (i % 3 == 0 && i % 5 == 0) {
                results.add("fizz buzz");
            } else if (i % 3 == 0) {
                results.add("fizz");
            } else if (i % 5 == 0) {
                results.add("buzz");
            } else {
                results.add(String.valueOf(i)); // i + ""
            }
        }
    
        return results;
