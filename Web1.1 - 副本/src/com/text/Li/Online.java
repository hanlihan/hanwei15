package com.text.Li;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class Online implements HttpSessionListener {
	private static int online = 0;
    public void sessionCreated(HttpSessionEvent arg0)  { 
          online++;
          arg0.getSession().getServletContext().setAttribute("online", online);
    }

	
    public void sessionDestroyed(HttpSessionEvent arg0)  { 
          online--;
          arg0.getSession().getServletContext().setAttribute("online", online );
    }
	
}
