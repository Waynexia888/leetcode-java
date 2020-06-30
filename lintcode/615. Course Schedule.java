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