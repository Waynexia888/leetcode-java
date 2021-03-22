public class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // 参考视频: https://www.youtube.com/watch?v=fskPWs3Nuhc
        // 本题难点是如何构建图？ 构建图有两种方式： 1: 邻接矩阵； 2. 邻接表
        // 邻接矩阵（即使用一个二维数组）； 邻接表（即使用哈希表）
        if (numCourses <= 0 || prerequisites == null) {
            return true;
        }

        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();

        // key: 先修课, value: to take course
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (graph.containsKey(prerequisites[i][1])) {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            } else {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            }
        }

        // bfs
        // 取出所有入度为0的点，放入队列中
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        while (!queue.isEmpty()) {
            int course = queue.poll();
            List<Integer> toTakeCourse = graph.get(course);
            for (int i = 0; toTakeCourse != null && i < toTakeCourse.size(); i++) {
                inDegree[toTakeCourse.get(i)]--;
                if (inDegree[toTakeCourse.get(i)] == 0) {
                    queue.offer(toTakeCourse.get(i));
                }

            }
        }

        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] != 0) {
                return false;
            }
        }
        return true;

    }
}

//////////////////////////////////////////////////////////

public class Solution {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: true if can finish all courses or false
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // corner case:
        if (numCourses == 0 || prerequisites.length == 0) {
            return true;
        }
        
        // 1. Build the graph: key -> value ; pre course -> after course
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            map.put(i, new HashSet<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int after = prerequisites[i][0];
            int pre = prerequisites[i][1];
            map.get(pre).add(after);
        }

        // 2. find out course that has 0 in-degree
        // key -> value; course -> in degree
        Map<Integer, Integer> indegree = new HashMap<>();
        for (int i = 0; i < numCourses; i++) {
            for (Integer course : map.get(i)) {
                if (indegree.containsKey(course)) {
                    indegree.put(course, indegree.get(course) + 1);
                } else {
                    indegree.put(course, 1);
                }
            }
        }
        
        // 3. find out nodes that has 0-indegree, and put it into queue
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (!indegree.containsKey(i)) {
                queue.offer(i);
            }
        }

        // 4. bfs
        List<Integer> finished = new ArrayList<>();
        while (!queue.isEmpty()) {
            int course = queue.poll();
            finished.add(course);
            for (Integer neighbor : map.get(course)) {
                indegree.put(neighbor, indegree.get(neighbor) - 1);
                if (indegree.get(neighbor) == 0) {
                    queue.offer(neighbor);
                }
            }
        }

        // 4. check if it is possible to finish all course?
        // return finished.size() == numCourses;
        if (finished.size() == numCourses) {
            return true;
        }
        return false;
    }
}