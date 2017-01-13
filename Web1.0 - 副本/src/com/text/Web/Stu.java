package com.text.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sun.xml.internal.bind.v2.runtime.unmarshaller.SAXConnector;


public class Stu extends HttpServlet {
	
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		    request.setCharacterEncoding("utf-8");
		    response.setContentType("text/html;charset=utf-8");
		    
		    String userName = request.getParameter("name");
		    String passWord = request.getParameter("password");
		    String autoL = request.getParameter("autoL");
		 
		    
		    if(userName.equals("stu")&&passWord.equals("123")){ 
				if("true".equals(autoL)){
					Cookie cookie_use= new Cookie("name", userName);
					Cookie cookie_psw = new Cookie("psw", passWord);
					cookie_use.setMaxAge(60*60*3);
					cookie_psw.setMaxAge(60*60*3);
					response.addCookie(cookie_use);
					response.addCookie(cookie_psw);
					
				}else{
					Cookie cookie_use= new Cookie("name", userName);
					Cookie cookie_psw = new Cookie("psw", passWord);
					cookie_use.setMaxAge(0);
					cookie_psw.setMaxAge(0);
					response.addCookie(cookie_use);
					response.addCookie(cookie_psw);
				}

				HttpSession session = request.getSession();
				session.setAttribute("user", userName);	
//				session.setMaxInactiveInterval(0);
				response.sendRedirect("index.jsp");
		    }else{
		    	response.sendRedirect("login.jsp?flag=1");
		    }
		    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
