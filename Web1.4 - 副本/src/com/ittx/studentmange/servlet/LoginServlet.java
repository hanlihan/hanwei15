package com.ittx.studentmange.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Server.UsersServer;
import com.ittx.Student.Servertimpl.UsersServerimpl;

@WebServlet({ "/LoginServlet", "/longinser.do" })
public class LoginServlet extends HttpServlet {
    private UsersServer usersServer = new UsersServerimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		 System.out.println(username+"\t"+password);
		if(usersServer.Examine(username, password)){
			request.getRequestDispatcher("./main.jsp").forward(request, response);
		}else{
			request.setAttribute("error","ÓÃ»§Ãû´íÎó");
			request.getRequestDispatcher("./login.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
