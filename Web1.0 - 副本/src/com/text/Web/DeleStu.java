package com.text.Web;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.bean.Student1;
import com.text.db.StudenttDB;


public class DeleStu extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String number = request.getParameter("num"); 
		Student1 student = StudenttDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		String head_img = student.getSrc();
		
		String head_file = getServletContext().getRealPath("/") + head_img;
	
	
		File file = new File(head_file);
	
		if (file.exists()) {
			file.delete();
		}
		
		    
		StudenttDB.getInstance().deleteStudentById(Integer.parseInt(number));
		response.sendRedirect("./GetStu2.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
