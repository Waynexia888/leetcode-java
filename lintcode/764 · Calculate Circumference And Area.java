public class Solution {
    /**
     * @param r: a Integer represent radius
     * @return: the circle's circumference nums[0] and area nums[1]
     */
    public double[] calculate(int r) {
        // write your code here
        double[] result = new double[2];
        result[0] = 2 * 3.14 * r;
        result[1] = 3.14 * r * r;
        return result;
    }
}
