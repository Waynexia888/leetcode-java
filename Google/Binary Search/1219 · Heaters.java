Lintcode 1219 · Heaters

public class Solution {
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        int minRadius = Integer.MIN_VALUE;
        for (int house : houses) {
            int minDistanceToHouse = Integer.MAX_VALUE;
            for (int heater : heaters) {
                minDistanceToHouse = Math.min(minDistanceToHouse, Math.abs(heater - house));
            }
            minRadius = Math.max(minRadius, minDistanceToHouse);
        }
        return minRadius;
    }
}

// 对于每一个house，如何快速的找出离他最近的heater 就是我们要优化的步骤
// 前提是heaters数组必须排好序

// 如果我们把一个house看成一个target，那么利用二分法，可以在heaters数组里找到这个target
// 或者找离target最近的heater的距离

///////////////////////////////////////////////////////////////

public class Solution {
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        Arrays.sort(heaters);
        int minRadius = Integer.MIN_VALUE;
        for (int house : houses) {
            int minDistanceToHouse = findClosestHeater(heaters, house);
            minRadius = Math.max(minRadius, minDistanceToHouse);
        }
        return minRadius;
    }

    private int findClosestHeater(int[] heaters, int house) {
        int start = 0, end = heaters.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (heaters[mid] == house) {
                return 0;
            } else if (heaters[mid] < house) {
                start = mid;
            } else {
                end = mid;
            }
        }
        return Math.min(Math.abs(heaters[start] - house), Math.abs(heaters[end] - house));
    }
}
