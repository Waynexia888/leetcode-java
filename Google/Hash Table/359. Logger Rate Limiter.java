Leetcode 359. Logger Rate Limiter

class Logger {
    private Map<String, Integer> message2timestamp;
    /** Initialize your data structure here. */
    public Logger() {
        message2timestamp = new HashMap<>();
    }
    
    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        
        if (!this.message2timestamp.containsKey(message)) {
            this.message2timestamp.put(message, timestamp);
            return true;
        }
        
        int oldTimestamp = this.message2timestamp.get(message);
        if (timestamp - oldTimestamp >= 10) {
            this.message2timestamp.put(message, timestamp);
            return true;
        }
        return false;
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */