import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;

class Solution {
    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        // time: O(n^2 * nlogn)
        List<Integer> results = new ArrayList<>();
        Collections.sort(arr);  // nlogn
        int sum = 0;
        int[] prefixSum = new int[arr.size() + 1];
        for (int i = 0; i < arr.size(); i++) {  // O(n)
            sum += arr.get(i);
            prefixSum[i + 1] = prefixSum[i] + arr.get(i);
        }
        
        double target = sum / 2.0;
        int size = Integer.MAX_VALUE;
        int start = 0; 
        int end = 0;
        
        for (int i = 0; i < arr.size(); i++) {  // O(n^2)
            for (int j = i; j < arr.size(); j++) {
                if (prefixSum[j + 1] - prefixSum[i] > target) {
                    size = Math.min(size, j - i + 1);
                    start = i;
                    end = j;
                }
            }
        }
            
        for (int i = start; i <= end; i++) {  // O(n)
            results.add(arr.get(i));
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = optimizingBoxWeights(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

// If we sort the array, the subset A with maximal total weight is the shortest 
// trailing subarray with sum greater than half of the total sum, 
// e.g. for the example above,

// sorted(arr) = [1, 2, 2, 3, 4, 5]
// sum(arr) / 2 = 17 / 2 = 8.5
// A = [4, 5]
// sum(A) = 9

/////////////////////////////////////////////////////////////////////
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.ArrayList;
import java.util.Collections;
import java.util.PriorityQueue;

class Solution {
    public static List<Integer> optimizingBoxWeights(List<Integer> arr) {
        int sum = 0;
        for (int i = 0; i < arr.size(); i++) { // O(n)
            sum += arr.get(i);
        }
        double target = sum / 2.0;
        
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> (b - a));
        maxHeap.addAll(arr);  // O(n)
        
        List<Integer> results = new ArrayList<>();
        int totalSum = 0;
        while (totalSum < target) {  // O(m)
            int number = maxHeap.poll();  // O(logn)
            totalSum += number;
            results.add(number);
        }
        Collections.sort(results);
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer> arr = Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        scanner.close();
        List<Integer> res = optimizingBoxWeights(arr);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

// For input of size n and output of size m, this approach takes O(n + m log n) 
// as opposed to O(n log n) by sorting, which is faster in all cases and 
// especially so if the output size is small.