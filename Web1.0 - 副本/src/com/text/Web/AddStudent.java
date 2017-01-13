package com.text.Web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.bean.Student1;
import com.text.db.StudentDB;
import com.text.db.StudenttDB;



public class AddStudent extends HttpServlet {
	
	public void init() throws ServletException {
		StudentDB.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		
		String number = request.getParameter("number");
	    String name = request.getParameter("name");
	    String tupian = request.getParameter("myile");
	    
	    int numbers = Integer.parseInt(number);
	    if(StudenttDB.getInstance().isExistStudentByNumber(numbers)){
//	    	response.sendRedirect("./AddStu.jsp?flag=false");
	    	request.getRequestDispatcher("./AddStu.jsp?flag=false").forward(request, response);;
	    	
	    }else{
	    	Student1 student = new Student1(numbers,name,true,tupian);
	    	StudenttDB.getInstance().addStudent(student);
		    response.sendRedirect("./GetStu2.jsp");
	    }
	  
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
