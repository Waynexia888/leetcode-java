public class Solution {
    /**
     * @param customers: the number of customers
     * @param grumpy: the owner's temper every day
     * @param X: X days
     * @return: calc the max satisfied customers
     */
    public int maxSatisfied(int[] customers, int[] grumpy, int X) {
        // time: O(n); space: O(1)
        int originSatisfiedNums = 0;
        for (int i = 0; i < customers.length; i++) {
            if (grumpy[i] == 0) {
                originSatisfiedNums += customers[i];
            }
        }

        int maxBecomeSatisfied = 0;
        int becomeSatisfied = 0;
        int left = 0, right = 0;
        for (right = 0; right < customers.length; right++) {
            if (grumpy[right] == 1) {
                becomeSatisfied += customers[right];
            }

            if (right - left + 1 > X) {
                if (grumpy[left] == 1) {
                    becomeSatisfied -= customers[left];
                }
                left++;
            }
            maxBecomeSatisfied = Math.max(maxBecomeSatisfied, becomeSatisfied);
        }
        return originSatisfiedNums + maxBecomeSatisfied;
    }
}

// originSatisfiedNums + maxBecomeSatisfied in a size of X days = totalSatisfied


// 1, 0, 1, 2, 1, 1, 7, 5
//    i        j

// 1. 令left = 0，right = 0。
// 2. 移动右端点的位置for right = 0 .. n - 1。如果grumpy[right] == 1，
//       就将customers[right]计入会变好评的人数中。
// 3. 如果窗口中的个数大于X，如果原left的位置grumpy[left] == 1，
//    就将customers[left]从变好评人数中减去。然后，令left加1，代表窗口的左端点向右滑动1格。
// 4. 记录滑动窗口中最大的变好评的人数。