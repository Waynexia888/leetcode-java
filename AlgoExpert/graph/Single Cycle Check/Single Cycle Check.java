import java.util.*;

class Program {
    public static boolean hasSingleCycle(int[] array) {
        // jump through the elements in the array, visiting exactly n elements,
        // where n is the length of the array.
        // 1. when the while loop ends, if we do not back to the startIndex,
        // we may have multiple cycles
        // 2. during the while loop, if at any point we find ourselves back at the
        // startIndex,
        // then we know that we found multiple cycles.
        // time: O(n), space: O(1)
        if (array == null || array.length == 0) {
            return false;
        }

        int numOfEleVisited = 0;
        int currentIndex = 0;
        while (numOfEleVisited < array.length) {
            // if at any point we find ourselves back at the startIndex, return false
            if (numOfEleVisited > 0 && currentIndex == 0) {
                return false;
            }
            numOfEleVisited++;
            currentIndex = getNextIndex(array, currentIndex);
        }
        // when the while loop ends, if the currentIndex = 0, retrun true, 
        // else return false
        return currentIndex == 0;
    }

    private static int getNextIndex(int[] array, int currentIdx) {
        int jumpNumber = array[currentIdx];
        int nextIndex = (currentIdx + jumpNumber) % array.length;
        // determine nextIndex is positive or negative
        if (nextIndex >= 0) {
            return nextIndex;
        } else {
            return nextIndex + array.length;
        }
    }
}
