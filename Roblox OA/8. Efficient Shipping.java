// A warehouse manager needs to create a shipment to fill a truck. All of the products
// in the warehouse are in boxes of the same size. Each product is packed in some
// number of units per box. Given the number of boxes the truck can hold, determine
// the maximum number of units of any mix of products that can be shipped.

// Example: 
// boxes = [1, 2, 3]
// unitsPerBox = [3, 2, 1]
// truckSize = 3

// 1 box with 3 units
// 2 boxes with 2 units each 
// 3 boxes with 1 unit each;
// the maximum number of units that can be shipped = 3 + 2 + 2 = 7 units

// complete the function getMaxUnits, return long: a long integer that denotes 
// the maximum units that can be carried by the truck.

public long getMaxUnits(int[] boxes, int[] unitsPerBox, int truckSize) {
    long result = 0;
    Queue<int[]> queue = new PriorityQueue<>((a, b)-> (b[0] - a[0]));

    for (int i = 0; i < boxes.length; i++) {
        queue.offer(new int[]{unitsPerBox[i], boxes[i]});
    }

    while (truckSize > 0 && queue.size() > 0) {
        int[] info = queue.poll();
        result += info[0] * (truckSize > info[1] ? info[1] : truckSize);
        truckSize -= info[1];
    }
    return result;
}

// use heap to record [unitPerBox, boxes], keep a maxHeap
// time: O(nlogk)
// space: O(k)



private static int function(int[] boxes, int[] unitPerBox, int truckSize) {
    int n = boxes.length;
    int[] dp = new int[truckSize + 1];
    for(int i = 0; i < n; i++){
        for(int j = truckSize; j >= boxes[i]; j--){
            dp[j] = Math.max(dp[j], dp[j - boxes[i]] + boxes[i] * unitPerBox[i]);
        }
    }
    return dp[truckSize];
}
