package com.ittx.studentmange.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Model.Student;
import com.ittx.Student.Servertimpl.StudentServletimpl;


@WebServlet({ "/Studentfind", "/findstu.do" })
public class Studentfind extends HttpServlet {
	private StudentServletimpl stu = new StudentServletimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String num = request.getParameter("number"); 
		System.out.println(num);
		int numbers = Integer.parseInt(num);
	    Student student = stu.isExistStudentByNumber(numbers);
	    request.setAttribute("student",student);
	    request.getRequestDispatcher("./findstu.jsp").forward(request, response);
	    
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
