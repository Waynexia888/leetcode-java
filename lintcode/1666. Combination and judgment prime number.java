// Description

// Give n integers and an integer k, you can choose k integers in the
// n integers and add them up, now let you calculate how many ways 
// that the sum of the k integers is a prime number.

// n does not exceed 10
// k does not exceed n

// Example 1:

// Input：a=[3,7,12,19]，k=3
// Output：1
// Explanation:
// There are 4 ways
// 3+7+12=22　　3+7+19＝29　　7+12+19＝38　　3+12+19＝34  
// and only 29 is a prime.
// Example 2:

// Input：a=[1,2,3], k=2
// Output：2
// Explanation:
// There are 3 ways
// 1 + 2 = 3         1 + 3 = 4      2 + 3 =5
// and only 3 and 5 are primes.


public class Solution {
    /**
     * @param a: the n numbers
     * @param k: the number of integers you can choose
     * @return: how many ways that the sum of the k integers is a prime number
     */
    public int getWays(int[] a, int k) {
        // Write your code here
        if (a == null || a.length == 0) {
            return -1;
        }
        
        Arrays.sort(a);
        List<Integer> results = new ArrayList<>();
        dfs(a, k, new ArrayList<>(), results, 0);
        
        int count = 0;
        for (int i = 0; i < results.size(); i++) {
            if (isPrime(results.get(i))) {
                count++;
            }
        }
        return count;
    }
    
    private void dfs(int[] a, int k, List<Integer> temp, List<Integer> results, int startIndex) {
        if (temp.size() == k) {
            int ans = 0;
            for (int i = 0; i < temp.size(); i++) {
                ans += temp.get(i);
            }
            results.add(ans);
            return;
        }
        
        for (int i = startIndex; i < a.length; i++) {
            temp.add(a[i]);
            dfs(a, k, temp, results, i + 1);
            temp.remove(temp.size() - 1);
        }
    }
    
    private boolean isPrime(int number) {
        if (number < 2) {
            return false;
        }
        
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}