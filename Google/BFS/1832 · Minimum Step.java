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

////////////////////////////////////////////////////////

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

        Queue<Integer> queue = new LinkedList<>(); // put index into queue
        queue.offer(0);
        // from start index to current index, record steps; check current index is visited or not
        Map<Integer, Integer> distance = new HashMap<>(); 
        distance.put(0, 0);
        Set<Integer> visitedColors = new HashSet<>(); // check current color is visited or not

        // construct  the adjacency list. color -> index
        int len = colors.size();
        Map<Integer, Set<Integer>> color2Index = new HashMap<>();
        for (int i = 0; i < len; i++) {
            int color = colors.get(i);
            if (!color2Index.containsKey(color)) {
                color2Index.put(color, new HashSet<>());
            }
            color2Index.get(color).add(i);
        }

        while (!queue.isEmpty()) {
            int cur = queue.poll();  // index 
            if (cur == len - 1) {
                // return distance.get(cur);
                break;
            }

            // // same color
            // int color = colors.get(cur); // current color
            // if (!visitedColors.contains(color)) {
            //     // current color is not visited, so chech its neighbors.
            //     Set<Integer> neighbors = color2Index.get(color); // return a set of index for the current color
            //     for (int neighbor : neighbors) { 
            //         if (isValid(neighbor, len, distance)) {
            //             queue.offer(neighbor);
            //             distance.put(neighbor, distance.get(cur) + 1);
            //         }
            //     }
            // }
            // visitedColors.add(color);

            // i -> i + 1
            if (isValid(cur + 1, len, distance)) { //within the chess table, not visited
                queue.offer(cur + 1);
                distance.put(cur + 1, distance.get(cur) + 1);
            }

            // i -> i - 1
            if (isValid(cur - 1, len, distance)) {
                queue.offer(cur - 1);
                distance.put(cur - 1, distance.get(cur) + 1);
            }

            // same color
            int color = colors.get(cur); // current color
            if (visitedColors.contains(color)) {
                continue;
            }
            // current color is not visited, so chech its neighbors.
            Set<Integer> neighbors = color2Index.get(color); // return a set of index for the current color
            for (int neighbor : neighbors) { 
                if (isValid(neighbor, len, distance)) {
                    queue.offer(neighbor);
                    distance.put(neighbor, distance.get(cur) + 1);
                }
            }
            visitedColors.add(color);
        }
        return distance.get(len - 1);
    }

    private boolean isValid(int index, int len, Map<Integer, Integer> distance) {
        if (index < 0 || index >= len) {
            return false;
        }
        if (distance.containsKey(index)) {
            return false;
        }
        return true;
    }
}