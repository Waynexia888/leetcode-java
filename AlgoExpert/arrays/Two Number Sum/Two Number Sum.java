import java.util.*;

class Program {
    public static int[] twoNumberSum(int[] array, int targetSum) {
        // because all number in the array are distinct integers
        // use hashset
        // time: O(n), space O(n)
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < array.length; i++) {
            if (!set.contains(targetSum - array[i])) {
                set.add(array[i]);
            } else {
                return new int[] { array[i], targetSum - array[i] };
            }
        }
        return new int[0];
    }
}
