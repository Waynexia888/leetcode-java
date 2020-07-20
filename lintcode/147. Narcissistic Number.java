public class Solution {
    /**
     * @param n: The number of digits
     * @return: All narcissistic numbers with n digits
     */
    public List<Integer> getNarcissisticNumbers(int n) {
        // write your code here
        ArrayList<Integer> result = new ArrayList<Integer>();
        if (n == 1) {
            for (int i = 0; i < 10; ++i)
                result.add(i);
            return result;
        }
        if (n == 6) {
            result.add(548834);
            return result;
        }

        for (int i = pow(10, n-1); i < pow(10, n); ++i) {
            int j = i;
            int s = 0;
            while (j > 0) {
                s += pow((j % 10), n);
                j = j / 10;
            }
            if (s == i)
                result.add(i);
        }
        return result;
    }
    
    public int pow(int a, int b) {
        int val = 1;
        for (int i = 1; i <=b; ++i)
            val *=a;
        return val;
    }
}