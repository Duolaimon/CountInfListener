package util;

import Item.User;

import java.util.ArrayList;

/**
 * @author deity
 *         16-11-14 下午8:27
 */
public class SessionUtil {
    public static User getUserBySessionId(ArrayList<User> users,String sessionId){
        for (User user : users) {
            if (user.getSessionId().equals(sessionId)) {
                return user;
            }
        }
        return null;
    }
}
