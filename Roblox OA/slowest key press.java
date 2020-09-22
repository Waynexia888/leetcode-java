// Example:
// keyTimes = [[0, 2], [1, 5], [0, 9], [2, 15]]

// Elements in keyTimes[i][0] represent encoded characters in the range ascii[a-z]
// where a = 0, b = 1,... z= 25. The second element, keyTimes[i][1] represents the 
// time the key is pressed since the start of the test. The elements will be given 
// in ascending time order. In the example, keys pressed, in order are 
// 0102 encoded = abac at times 2, 5, 9, 15. From the start time, it took 2 - 0 = 2
// to press the first key, 5 - 2 = 3 to press the second, and so on. The longest
// time it took to press a key was key 2, or 'c' at 15 - 9 = 6.

// complete the function slowestKey in the editor below, 
// return char: the key that took the longest time to press


public static char slowestKey(List<List<Integer>> keyTimes) {
    int longestTime = keyTimes.get(0).get(1);
    char result = (char)('a' + keyTimes.get(0).get(0));
    int n = keyTimes.size();
    for (int i = 0; i < n - 1; i++) {
        List<Integer> nextKey = keyTimes.get(i + 1);
        List<Integer> curKey = keyTimes.get(i);
        int time = nextKey.get(1) - curKey.get(1);
        if (time > longestTime) {
            longestTime = time;
            result = (char)(nextKey.get(0) + 'a');
        }
    }
    return result;
}

// time: O(n);
// space: O(1)
