package com.ittx.studentmange.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Model.Student;
import com.ittx.Student.Server.StudentServlet;
import com.ittx.Student.Servertimpl.StudentServletimpl;


@WebServlet({ "/StudentListServlet", "/student_list.do" })
public class StudentListServlet extends HttpServlet {
	private StudentServlet studentServer = new StudentServletimpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<Student> studentListss = studentServer.getAllStudent();
		
		request.setAttribute("studentLists", studentListss);
//		System.out.println("studentLists:"+studentListss);
		request.getRequestDispatcher("./student_list.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
