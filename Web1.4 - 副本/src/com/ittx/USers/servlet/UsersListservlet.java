package com.ittx.USers.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Model.Users;
import com.ittx.Student.Servertimpl.UsersServerimpl;


@WebServlet({ "/UsersListservlet", "/userlistser" })
public class UsersListservlet extends HttpServlet {
	private UsersServerimpl usersServerimpl = new UsersServerimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Users> userlist = usersServerimpl.getAllUsers();
		
		request.setAttribute("userLists",userlist);
		System.out.println("userLists:"+userlist);
		request.getRequestDispatcher("./getUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
