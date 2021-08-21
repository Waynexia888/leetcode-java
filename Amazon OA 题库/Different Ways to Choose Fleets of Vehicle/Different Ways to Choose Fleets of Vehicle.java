// 有两种wheeled，一种是two-wheeled, 一种是four-wheeled
// Given array wheels = [4, 5, 6]
// return [2, 0, 2]

DP Approach without using dp array:

Number of ways to choose 0 wheels = 0;
Number of ways to choose 1 wheel = 0;
Number of ways to choose 2 wheel = 1
Number of ways to choose 3 ( and any odd number) of wheels = 0;
Number of ways to choose 4 wheels = 2 (1 four wheeled vehicle or 2 two wheeled vehicles);
Number of ways to choose 6 wheels = 2 (Number of ways to choose 4 wheels) + 0 (four+two, two+two+two) // Note: four+two and two+four are not considered to be different.
Number of ways to choose 8 wheels = 3 (Number of ways to choose 4 wheels) + 1 (four+four, four+two+two, two+two+two)....

Since the only options we have are two wheels and four wheels, the number of ways would only increase by 1 on next multiples of 4.

public int[] findVehicles(int[] vehicles) {
    if (vehicles == null || vehicles.length == 0) {
        return new int[0];
    }

    int[] results = new int[vehicles.length];
    for (int i = 0; i < vehicles.length; i++) {
        if (vehicles[i] % 2 != 0) {
            results[i] = 0;
            continue;
        }
        int ways = (vehicles[i] / 4) + 1;
        results[i] = ways;
    }
    return results;
}

// time: O(N), space: O(1)