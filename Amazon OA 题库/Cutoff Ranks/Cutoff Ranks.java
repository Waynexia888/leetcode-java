public class Solution {
    public int cutoffRank(int cutoffRank, int num, int[] scores) {
        if (cutoffRank == 0 || num > 100000) {
            return 0;
        }

        Arrays.sort(scores);
        int count = 0; 
        int currentRank = 0;
        int globalRank = 0;
        int prevScore = Integer.MAX_VALUE;

        for (int i = num - 1; i >= 0; i--) {
            if (scores[i] == 0) {
                break;
            }
            globalRank++;
            
            if (scores[i] < prevScore) {
                currentRank = globalRank;
            }
            prevScore = scores[i];

            if (currentRank <= cutoffRank) {
                count++;
            } else {
                break;
            }
        }
        return count;
    }
}

// [25, 50, 50, 100] cutoffRank = 3

// time: O(nlogn); space: O(1)