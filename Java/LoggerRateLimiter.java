/**
 * Created on 22 Nov 2018 by happygirlzt
 *
 * LeetCode #359. Logger Rate Limiter
 *
 */

class Logger {
    private HashMap<String, Integer> rec;

    /** Initialize your data structure here. */
    public Logger() {
        rec = new HashMap<>();
    }

    /** Returns true if the message should be printed in the given timestamp, otherwise returns false.
        If this method returns false, the message will not be printed.
        The timestamp is in seconds granularity. */
    public boolean shouldPrintMessage(int timestamp, String message) {
        if (!rec.containsKey(message)) {
rec.put(message, timestamp);
            return true;
        } else {
            int interval = (timestamp - rec.get(message));
            if (interval >= 10) {
                rec.put(message, timestamp);
                return true;
            } else {
                return false;
            }
        }
    }
}

/**
 * Your Logger object will be instantiated and called as such:
 * Logger obj = new Logger();
 * boolean param_1 = obj.shouldPrintMessage(timestamp,message);
 */
