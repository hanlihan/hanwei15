package com.ittx.studentmange.servlet;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Dao.StudentDAO;
import com.ittx.Student.Daoimpl.StudentDaoimpl;
import com.ittx.Student.Servertimpl.StudentServletimpl;



/**
 * Servlet implementation class DeleStudent
 */
@WebServlet({ "/DeleStudent", "/delestu.do" })   
public class DeleStudent extends HttpServlet {
    private StudentServletimpl studentS = new StudentServletimpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 String number = request.getParameter("num"); 
		 int numbers = Integer.parseInt(number);
		 String rootDir = request.getServletContext().getRealPath("/");
		 studentS.deleteStudentById(numbers,rootDir);
		 request.getRequestDispatcher("student_list.do").forward(request, response);
	 
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
