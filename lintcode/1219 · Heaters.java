public class Solution {
    /**
     * @param houses: positions of houses
     * @param heaters: positions of heaters
     * @return: the minimum radius standard of heaters
     */
    public int findRadius(int[] houses, int[] heaters) {
        // Write your code here
        int res = Integer.MIN_VALUE;
        Arrays.sort(heaters);
        for (Integer house : houses) {
            int distanceToHeater = closestHeater(heaters, house);
            res = Math.max(res, distanceToHeater);
        }
        return res;
    }

    private int closestHeater(int[] heaters, int house) {
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

// for each house, find the distance to the nearest heater by binary search,
//     also update the minimum radius at the same time
// houses -> n; heaters -> m 
// m * log(m) + n * log(m) = O((m + n) * log(m))

// 假设每个heater的radius是r， 如果一个heater的位置是x， 那么【x - r, x + r】这个范围内的房屋都会被加热
