package com.text.Li;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;


@WebListener
public class DemoSessionLisener implements HttpSessionListener {

    
    public DemoSessionLisener() {
    	System.out.println("DemoSessionLisener >>>DemoSessionLisener >>>>> ");
    }

    public void sessionCreated(HttpSessionEvent arg0)  { 
    	System.out.println("DemoSessionLisener >>>sessionCreated >>>>> ");
    }

    public void sessionDestroyed(HttpSessionEvent arg0)  { 
    	System.out.println("DemoSessionLisener >>>sessionDestroyed >>>>> ");
    }
	
}
