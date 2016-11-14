package listener;

import Item.User;
import util.SessionUtil;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * @author deity
 *         16-11-14 下午8:16
 */
@WebListener
public class MyRequestListener implements ServletRequestListener {
    private ArrayList<User> users;

    @Override
    public void requestDestroyed(ServletRequestEvent sre) {

    }

    @Override
    public void requestInitialized(ServletRequestEvent sre) {
        users = (ArrayList<User>)sre.getServletContext().getAttribute("users");
        if (users == null) {
            users = new ArrayList<>();
        }

        HttpServletRequest request = (HttpServletRequest) sre.getServletRequest();
        String sessionId = request.getSession().getId();

        if (SessionUtil.getUserBySessionId(users, sessionId) == null) {
            User user = new User();
            user.setSessionId(sessionId);
            user.setFirstTimeString(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
            user.setIpString(request.getRemoteAddr());
            users.add(user);
        }
        request.getServletContext().setAttribute("users", users);
    }
}
