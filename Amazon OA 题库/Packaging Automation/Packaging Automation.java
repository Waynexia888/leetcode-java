//////////////////////////////////////////////////
// Time Limit Exceed, time: O(nlogn); space: O(1)
public class Solution {
    public int packaging(int numGroups, int[] arr) {
        Arrays.sort(arr);
        arr[0] = 1;
        for (int i = 1; i < numGroups; i++) {
            if (arr[i] > arr[i - 1]) {
                arr[i] = arr[i - 1] + 1;
            }
        }
        return arr[arr.length - 1];
    }
}

/////////////////////////////////////////////////
