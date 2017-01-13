package com.text.Li;

import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

import java.sql.Connection;

@WebListener
public class DemoServletContext implements ServletContextListener {
    private static final String URL="jdbc:mysql://localhost:3306/gs";
    private static final String USER="root";
    private static final String PASSWORD="154331";
    
    public void contextDestroyed(ServletContextEvent arg0)  { 
        System.out.println("DemoServletContext>>>contextDestroyed>>>");
        Connection connect = (Connection) arg0.getServletContext().getAttribute("con");
        if(connect!=null){
        	try {
				connect.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
        }
    }

	
    public void contextInitialized(ServletContextEvent arg0)  { 
      try{
    	Class.forName("com.mysql.jdbc.Driver");
    }catch(ClassNotFoundException e){
    	e.printStackTrace();
    }
      
     Connection connect = null;
      try {
		connect =  DriverManager.getConnection(URL, USER, PASSWORD);
	} catch (SQLException e) {
				e.printStackTrace();
	}
      arg0.getServletContext().setAttribute("con", connect);
      
      System.out.println("DemoServletContext>>>contextInitialized>>>");
      }
	
}
