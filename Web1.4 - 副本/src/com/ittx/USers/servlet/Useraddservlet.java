package com.ittx.USers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ittx.Student.Model.Users;
import com.ittx.Student.Servertimpl.UsersServerimpl;

@WebServlet({ "/Userservlet", "/adduser.do" })
public class Useraddservlet extends HttpServlet {

	private UsersServerimpl usersServerimpl = new UsersServerimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String username = request.getParameter("userName");
		String psw = request.getParameter("passWord");
		String num = request.getParameter("Number");
		String id = request.getParameter("id");

		int numbers = Integer.parseInt(num);
		Users user = new Users(username, psw, numbers);

		if (id.equals("")) {

			if (usersServerimpl.addUser(user)) {
				request.getRequestDispatcher("userlistser").forward(request, response);
			} else {
				request.setAttribute("error", "’Àªß“—¥Ê‘⁄");
				request.getRequestDispatcher("./Useradd.jsp").forward(request, response);
			}
		} else {
			usersServerimpl.upUSersByName(user);
			request.getRequestDispatcher("./userlistser").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
