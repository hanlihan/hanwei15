package com.text.Web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.bean.Student1;
import com.text.db.StudenttDB;


public class UPstu extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                   request.setCharacterEncoding("utf-8");
                   response.setContentType("text/html,charset=utf-8");
                   
                   String userName = request.getParameter("userName");
                   String number = request.getParameter("number");
                   String sex = request.getParameter("sex");
                   String src = request.getServletContext().getRealPath("/");
                   
                   int num = Integer.parseInt(number);
                   boolean sexs = sex.equals("1")?true:false; 
                   
                   Student1 student = new Student1(num, userName,sexs,src);
                   StudenttDB.getInstance().upStudentByNumber(student);
          	    	response.sendRedirect(request.getContextPath()+"/GetStu2.jsp");
                   
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
