public class Solution {
    /**
     * @param time: a string of Time
     * @return: The MaximumMoment
     */
    public String MaximumMoment(String time) {
        // Write your code here.
        if (time == null || time.length() == 0) {
            return time;
        }

        char[] timeChars = time.toCharArray();
        if (timeChars[0] == '?') {
            if (timeChars[1] <= '9' && timeChars[1] >= '4') {
                timeChars[0] = '1';
            } else {
                timeChars[0] = '2';
            }
        }

        if (timeChars[1] == '?') {
            if (timeChars[0] != '2') {
                timeChars[1] = '9';
            } else {
                timeChars[1] = '3';
            }
        }

        if (timeChars[3] == '?') {
            timeChars[3] = '5';
        }
        if (timeChars[4] == '?') {
            timeChars[4] = '9';
        }

        return String.valueOf(timeChars);
    }
}