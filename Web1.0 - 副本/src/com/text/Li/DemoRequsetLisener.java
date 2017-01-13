package com.text.Li;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpServletRequest;

import sun.rmi.transport.proxy.HttpReceiveSocket;
@WebListener
public class DemoRequsetLisener implements ServletRequestListener {
    private SimpleDateFormat format = new SimpleDateFormat("yy年MM月dd日 HH时mm分ss秒");
    private ArrayList<User> userLists = null; 
    
    public void requestDestroyed(ServletRequestEvent arg0){
    	
    }
	public void requestInitialized(ServletRequestEvent arg0){
		HttpServletRequest request = (HttpServletRequest) arg0.getServletRequest();
	    String time = format.format(new Date());
	    String ip= request.getRemoteAddr();
	    String sessionId = request.getSession().getId();
	    
	    if(userLists == null){
	    	userLists = new ArrayList<>();
	    }
	    User users = Utils.getUserBySessionId(userLists, sessionId);
	    if(users == null){
	    	User user = new User(time, ip, sessionId);
	    	userLists.add(user);
	    }
	    ServletContext servletContext = request.getServletContext();
	    servletContext.setAttribute("userLists", userLists);
	}
	
	}
	
