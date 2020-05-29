public class String_to_Integer {
    /**
     * @param str: A string
     * @return: An integer
     */
    public int stringToInteger(String str) {
        // 要考虑给的字符串是否有符号。
        // 然后从高位开始循环累加。
        // 转换公示如下
        // 5468 -> ((5 * 10 + 4) * 10 + 6) * 10 + 8
        int num = 0, sig = 1;

        // 判断是否为负数
        if (str.charAt(0) == '-') {
            sig = -1;
            str = str.substring(1, str.length());
        }

        for (int i = 0; i < str.length(); i++) {
            num = num * 10 + str.charAt(i) - '0';
        }

        return num * sig;
    }
}