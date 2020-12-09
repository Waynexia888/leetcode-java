class Solution {
    public boolean repeatedSubstringPattern(String s) {
        int len = s.length();
        
        for (int i = len / 2; i >= 1; i--) {
            if (len % i == 0) {
                String subStr = s.substring(0, i);
                int repeatedNum = len / i;
                StringBuilder sb = new StringBuilder();
                for (int k = 0; k < repeatedNum; k++) {
                    sb.append(subStr);
                }
                if (sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }
}

时间复杂度： O(n^2)
因为for循环是 ½ n， substring()这个函数会消耗O(n)时间复杂度，
因为是嵌套的关系，所以 ½n * n = ½ n^2 = n^2（前面的系数1/2 去掉）

空间复杂度： O(n) 因为string builder开辟了新空间

