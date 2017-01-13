package com.text.Li;

import java.util.ArrayList;

import javax.servlet.ServletContext;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class Online implements HttpSessionListener {
	private static int online = 0;//在线人数
    public void sessionCreated(HttpSessionEvent arg0)  { 
          online++;
          System.out.println("..........."+online);
          arg0.getSession().getServletContext().setAttribute("online", online);
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
        HttpSession session = arg0.getSession();
        ServletContext servletContext = session.getServletContext();
    	online--;
        servletContext.setAttribute("online", online );
         
        /*
		 * 从userLists中移除用户同时更新servletContext属性值
		 */
        ArrayList<User> userLists = (ArrayList<User>) servletContext.getAttribute("userLists");
        String sessionId = session.getId();
        User user = Utils.getUserBySessionId(userLists, sessionId);
        userLists.remove(user);
        servletContext.setAttribute("userLists", userLists);
    }
	
}
