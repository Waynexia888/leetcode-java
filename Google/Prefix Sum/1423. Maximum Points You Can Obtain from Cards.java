Leetcode 1423. Maximum Points You Can Obtain from Cards

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int[] prefix = new int[k + 1];
        for (int i = 0; i < k; i++) {
            prefix[i + 1] = prefix[i] + cardPoints[i];
        }

        int[] suffix = new int[k + 1];
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            suffix[i + 1] = suffix[i] + cardPoints[n - 1 - i];
        }
        
        int sum = 0;
        // each i represent the number of cards we take from the front
        for (int i = 0; i <= k; i++) {
            sum = Math.max(sum, prefix[i] + suffix[k - i]);
        }
        return sum;
    }
}

// cardPoints = [1,2,3,4,5,6,1], k = 3
// prefix = [0, 1, 3, 6]
// suffix = [0, 1, 7, 12]

// [0, 0, 0, 0]
//  0, 1, 2, 3

// time: O(k); space: O(k)

///////////////////////////////////////////////////////////////

class Solution {
    public int maxScore(int[] cardPoints, int k) {
        int prefixSum = 0;
        for (int i = 0; i < k; i++) {
            prefixSum += cardPoints[i];
        }
        
        // take all k cards from the beginning, and 0 card from the end
        int suffixSum = 0;
        int sum = 0;
        sum = Math.max(sum, prefixSum + suffixSum);
        
        int n = cardPoints.length;
        for (int i = 0; i < k; i++) {
            suffixSum += cardPoints[n - 1 - i]; 
            prefixSum -= cardPoints[k - 1 - i];
            sum = Math.max(sum, prefixSum + suffixSum);
        }
        return sum;
    }
}

// cardPoints = [1,2,3,4,5,6,1], k = 3
// prefix = [0, 1, 3, 6]
// suffix = [0, 1, 7, 12]

// i = 0;
// prefixSum = 6 - 3 = 3
// suffixSum = 0 + 1 = 1
// i = 1
// prefixSum = 3 - 2 = 1;
// suffixSUm = 1 + 6 = 7

// i = 2
// prefixSUm = 1 - 1 = 0;
// suffixSum = 7 + 5 = 12

