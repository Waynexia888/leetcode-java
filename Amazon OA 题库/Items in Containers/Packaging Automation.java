import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

class Solution {
    public static List<Integer> numberOfItems(String s, List<List<Integer>> ranges) {
        // time: O(n^3); space: O(1)
        List<Integer> results = new ArrayList<>();
        int start = 0;
        int end = 0;
        String subStr = "";
        for (List<Integer> list : ranges) {     // O(n)
            start = list.get(0);
            end = list.get(1);
            subStr = s.substring(start, end + 1);  // take O(n) time
            int index = subStr.indexOf('|');
            int lastIndex = subStr.lastIndexOf('|');
            int count = 0;
            for (int i = index + 1; i < lastIndex; i++) {    // O(n)
                if (subStr.charAt(i) != '|') {
                    count++;
                }
            }
            results.add(count);
        }
        return results;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        int rangesLength = Integer.parseInt(scanner.nextLine());
        List<List<Integer>> ranges = new ArrayList<>();
        for (int i = 0; i < rangesLength; i++) {
            ranges.add(Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()));
        }
        scanner.close();
        List<Integer> res = numberOfItems(s, ranges);
        System.out.println(res.stream().map(String::valueOf).collect(Collectors.joining(" ")));
    }
}

https://algo.monster/problems/items_in_containers
