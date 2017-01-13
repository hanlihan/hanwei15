package com.ittx.USers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ittx.Student.Model.Student;
import com.ittx.Student.Model.Users;
import com.ittx.Student.Server.UsersServer;
import com.ittx.Student.Servertimpl.StudentServletimpl;
import com.ittx.Student.Servertimpl.UsersServerimpl;

@WebServlet({ "/USertfind", "/Userfind.do" })
public class USertfind extends HttpServlet {
	private UsersServer usersServer = new UsersServerimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");

		int ids = Integer.parseInt(id);

	    Users user = usersServer.isExistUsersByID(ids);
		if(user!=null ){
			
		request.setAttribute("use", user);

		request.getRequestDispatcher("./findUser_list.jsp").forward(request, response);
		}else{
			request.setAttribute("eorrey", "ID²»´æÔÚ");
			request.getRequestDispatcher("./finduser.jsp").forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
