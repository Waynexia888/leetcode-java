public class Simple_Calculator {
    /**
     * @param a:        An integer
     * @param operator: A character, +, -, *, /.
     * @param b:        An integer
     * @return: The result
     */
    public int calculate(int a, char operator, int b) {
        // 注意：题目给出operator是char类型，所以' ', 而不是 ""
        switch (operator) {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                return a / b;
            default:
                return 0;
        }
    }
}