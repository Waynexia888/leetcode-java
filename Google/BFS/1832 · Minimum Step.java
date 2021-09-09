Lintcode 1832 · Minimum Step

public class Solution {
    /**
     * @param colors: the colors of grids
     * @return: return the minimum step from position 0 to position n - 1
     */
    public int minimumStep(List<Integer> colors) {
        // write your code here
        if (colors == null || colors.size() < 2) {
            return 0;
        }

        int len = colors.size();
        Queue<Integer> queue = new LinkedList<>(); // store the index
        queue.offer(0);
        boolean[] visited = new boolean[len];
        visited[0] = true;
        Set<Integer> visitedColors = new HashSet<>();

        Map<Integer, Set<Integer>> color2Index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int color = colors.get(i);
            if (!color2Index.containsKey(color)) {
                color2Index.put(color, new HashSet<>());
            }
            color2Index.get(color).add(i);
        }

        int steps = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                if (cur == len - 1) {
                    return steps;
                }
                // i -> i + 1
                if (isValid(cur + 1, len, visited)) {
                    // if (cur + 1 == len - 1) {
                    //     return steps;
                    // }
                    queue.offer(cur + 1);
                    visited[cur + 1] = true;
                }

                // i -> i - 1
                if (isValid(cur - 1, len, visited)) {
                    // if (cur - 1 == len - 1) {
                    //     return steps;
                    // }
                    queue.offer(cur - 1);
                    visited[cur - 1] = true;
                }

                // same color
                int color = colors.get(cur);
                if (visitedColors.contains(color)) {
                    continue;
                }
                for (int neighbor : color2Index.get(color)) {
                    if (visited[neighbor]) {
                        continue;
                    }
                    // if (neighbor == len - 1) {
                    //     return steps;
                    // }
                    queue.offer(neighbor);
                    visited[neighbor] = true;
                }
                visitedColors.add(color);
            }
            steps++;
        }
        return -1;
    }

    public boolean isValid(int index, int len, boolean[] visited) {
        if (index < 0 || index > len) {
            return false;
        }

        if (visited[index]) {
            return false;
        }
        return true;
    }
}