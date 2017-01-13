package com.text.root.Test;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.apache.catalina.connector.Request;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.regexp.internal.recompile;

public class TestAction extends ActionSupport {
    public  HttpServletRequest request ;
    public  HttpSession session;
    public  ServletContext appliction;
	public TestAction() {
		request  = ServletActionContext.getRequest();
		session = request.getSession();
		appliction = request.getServletContext();
	}
    


}
