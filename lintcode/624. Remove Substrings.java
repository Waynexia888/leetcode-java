public class Solution {
    /*
     * @param s: a string
     * 
     * @param dict: a set of n substrings
     * 
     * @return: the minimum length
     */
    public int minLength(String s, Set<String> dict) {
        // 本题巧妙的使用了BFS
        if (s == null) {
            return 0;
        }

        Queue<String> queue = new LinkedList<>();
        Set<String> set = new HashSet<>();
        queue.offer(s);

        int min = s.length();

        while (!queue.isEmpty()) {
            String str = queue.poll();
            for (String sub : dict) {
                int found = str.indexOf(sub); // 如果没找到，返回-1
                while (found != -1) {
                    String newStr = str.substring(0, found) + str.substring(sub.length() + found, str.length());
                    if (!set.contains(newStr)) {
                        queue.offer(newStr);
                        set.add(newStr);
                        min = Math.min(min, newStr.length());
                    }
                    // 因为indexOf是找第一个sub出现的位置，但是如果给定的字符串多处地方有sub，如果不处理，会照成结果方案缺少
                    // 因此从found + 1这个下标开始查询后面是否存在sub的可能性
                    found = str.indexOf(sub, found + 1);
                }
            }
        }
        return min;
    }
}