package com.text.Li;

import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.annotation.WebListener;


@WebListener
public class DemoRequestLisener implements ServletRequestListener {

    
    public DemoRequestLisener() {
    	System.out.println("DemoRequestLisener >>>DemoRequestLisener >>>>> ");
    }

    public void requestDestroyed(ServletRequestEvent arg0)  { 
    	System.out.println("DemoRequestLisener >>>requestDestroyed >>>>> ");
    }

	
    public void requestInitialized(ServletRequestEvent arg0)  { 
    	System.out.println("DemoRequestLisener >>>requestInitialized >>>>> ");
    }
	
}

