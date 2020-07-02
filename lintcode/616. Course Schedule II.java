public class Solution {
    /*
     * @param numCourses: a total of n courses
     * 
     * @param prerequisites: a list of prerequisite pairs
     * 
     * @return: the course order
     */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // 使用邻接表构建图， 顺便统计toTakeCourse的入度
        // key: prerequisites course; value: toTakeCourse
        int[] inDegree = new int[numCourses];
        Map<Integer, List<Integer>> graph = new HashMap<>();
        for (int i = 0; i < prerequisites.length; i++) {
            inDegree[prerequisites[i][0]]++;
            if (!graph.containsKey(prerequisites[i][1])) {
                List<Integer> list = new ArrayList<>();
                list.add(prerequisites[i][0]);
                graph.put(prerequisites[i][1], list);
            } else {
                graph.get(prerequisites[i][1]).add(prerequisites[i][0]);
            }
        }

        // find out course that has 0 in-degree
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < inDegree.length; i++) {
            if (inDegree[i] == 0) {
                queue.offer(i);
            }
        }

        // bfs
        int count = 0;
        int[] results = new int[numCourses];

        while (!queue.isEmpty()) {
            Integer course = queue.poll();

            results[count] = course;
            count++;

            List<Integer> toTakeCourse = graph.get(course);
            for (int i = 0; toTakeCourse != null && i < toTakeCourse.size(); i++) {
                inDegree[toTakeCourse.get(i)]--;
                if (inDegree[toTakeCourse.get(i)] == 0) {
                    queue.offer(toTakeCourse.get(i));
                }
            }
        }

        // 如果不能完成所有的课，返回空数组；
        if (count != numCourses) {
            return new int[0];
        }
        return results;
    }
}