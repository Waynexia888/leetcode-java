// For example:
// consecutiveDifference = [-2, -1, -2, 5]
// lowerBound = 3
// upperBound = 10

// Note that none of the values is out of the bound. All possible analogous arrays are:
// [3, 5, 6, 8, 3]
// [4, 6, 7, 9, 4]
// [5, 7, 8, 10, 5]

// Tha answer is 3.

public static int countAnalogousArrays(List<Integer> consecutiveDifference, int lowerBound, int upperBound) {

        int min = 0, max = 0, sum = 0;
        for (Integer val : consecutiveDifference) {
            sum += val;
            min = Math.min(min, sum);
            max = Math.max(max, sum);
        }

        int result = upperBound - lowerBound - (max - min) + 1;
        return result < 0 ? 0 : result;
}

val = -2, sum = -2, min = -2, max = 0
val = -1, sum = -3, min = -3, max = 0
val = -2, sum = -5, min = -5, max = 0
val = 5, sum = 0, min = -5, max = 0

10 - 3 - (0 - -5) + 1 = 3

https://leetcode.com/discuss/interview-question/1332322/amazon-online-assessment-july-2021-secret-array