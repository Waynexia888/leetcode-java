class Solution {
    public boolean validWordSquare(List<String> words) {
        for (int i = 0; i < words.size(); i++) {
            for (int j = 0; j < words.get(i).length(); j++) {
                //如果行和列的长度不想等
                if (j >= words.size() || i >= words.get(j).length()) {
                    return false;
                }
                
                // 如果长度不想等，但是字符一样
                if (words.get(i).charAt(j) != words.get(j).charAt(i)) {
                    return false;
                }
            }
        }
        return true;
    }
}
