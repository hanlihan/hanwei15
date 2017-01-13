package com.text.Web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.text.bean.Student;
import com.text.db.StudentDB;
 

public class WebServlet extends HttpServlet {
	public StudentDB studentDB;

	@Override
	public void init(ServletConfig config) throws ServletException {
		studentDB = StudentDB.getInstance();
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			
	        ArrayList<Student> studentList= studentDB.getAllStudent();
	        studentDB.printAllStudent(studentList); 
	        
	        PrintWriter pw =response.getWriter();
	        String doctype="<!DOCTYPE html>";
	        pw.println(doctype
	        		+"<html>"
	        		+"<head>"
	        		+   "<title>学生列表</title>"
	    		    +   "<link rel=\"stylesheet\" type=\"text/css\" href=\"http://localhost:8080/Web/css/mystyle.css\"></link>"
	    		    +"</head>"
	    		    +"<body bgcolor=\"#f0f0f0\">" 
	    		    +"<div class=\"emp_contaner\">"
	    		    +  "<h1 align=\"center\">学生列表</h1>" 
	    		    + "<table>"
	    		    +   "<tr>"
	    		    +  "<th>学号</th> <th>姓名</th> <th>年龄</th>"
	    		    +  "</tr>");
	        for(Student student:studentList){
	        	
	        	pw.println("<tr>"
	        			+      "<td>"+student.getNumber()+"</td> <td>"+student.getName()+"</td> <td>"+student.getAge()+"</td>"
		    		    +   "</tr>");
	        }
	        pw.println("</table>" 
		    +"</div>"
		    +"</body>"
		    + "</html>");
	        pw.close();
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  doGet(request, response);
	}

}
