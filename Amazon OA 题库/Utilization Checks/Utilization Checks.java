public class UtilizationChecks {
    public int finalInstances(int instances, int[] averageUtil) {
        for (int i = 0; i < averageUtil.length; i++) {
            if (averageUtil[i] < 25 && instance > 1) {
                instance = (int) (Math.ceil(instance / 2.0));
                i += 10;
            }
            if (i < averageUtil.length && averageUtil[i] > 60 && instance < 200000000) {
                instance *= 2;
                i += 10;
            }
        }
        return instance;
    }
}

// iterate through the averageUtil array
// check if an action is taken or not for the current number
//      if not, check the next number
//      if yes, modify the given instances, then the current index += 10
// return the instance

// time: O(n); space: O(1)

// The java.lang.Math.ceil(double a) returns the smallest (closest to negative infinity) 
// double value that is greater than or equal to the argument
// Math.ceil(125.9) = 126.0
// Math.ceil(0.4873) = 1.0
// Math.ceil(-0.65) = -0.0