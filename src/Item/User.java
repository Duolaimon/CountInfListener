package Item;

/**
 * @author deity
 *         16-11-14 下午8:18
 */
public class User {
    private String sessionId;
    private String firstTimeString;
    private String ipString;

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    public String getFirstTimeString() {
        return firstTimeString;
    }

    public void setFirstTimeString(String firstTimeString) {
        this.firstTimeString = firstTimeString;
    }

    public String getIpString() {
        return ipString;
    }

    public void setIpString(String ipString) {
        this.ipString = ipString;
    }
}
