package com.ittx.USers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Model.Users;
import com.ittx.Student.Server.UsersServer;
import com.ittx.Student.Servertimpl.UsersServerimpl;

@WebServlet({ "/upUserServletlist", "/upUser_list.do" })
public class upUserServletlist extends HttpServlet {
	private UsersServer usersServer = new UsersServerimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            int id =Integer.parseInt( request.getParameter("id"));
            System.out.println(id);
            Users user = usersServer.isExistUsersByID(id);
            request.setAttribute("user", user);
            request.setAttribute("type", "modify");
            request.getRequestDispatcher("./Useradd.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
