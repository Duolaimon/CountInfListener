package listener;

import Item.User;
import util.SessionUtil;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;
import java.util.ArrayList;

/**
 * @author deity
 *         16-11-14 下午8:11
 */
@WebListener
public class MySessionListener implements HttpSessionListener {
    private int userNums = 0;

    @Override
    public void sessionCreated(HttpSessionEvent se) {
        userNums++;
        se.getSession().getServletContext().setAttribute("userNums",userNums);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent se) {
        userNums--;
        se.getSession().getServletContext().setAttribute("userNums",userNums);
        ArrayList<User> users = null;
        users = (ArrayList<User>)se.getSession().getServletContext().getAttribute("users");
        if (SessionUtil.getUserBySessionId(users, se.getSession().getId()) == null) {
            users.remove(SessionUtil.getUserBySessionId(users, se.getSession().getId()));
        }
    }
}
