package com.ittx.USers.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

import com.ittx.Student.Model.Users;
import com.ittx.Student.Server.UsersServer;
import com.ittx.Student.Servertimpl.UsersServerimpl;


@WebServlet({ "/upUserServlet", "/upUser.do" })
public class upUserServlet extends HttpServlet {
	private Logger log = Logger.getLogger(upUserServlet.class);
    private UsersServer usersServer = new UsersServerimpl();
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             int id = Integer.parseInt(request.getParameter("id"));
             log.debug("upUserServlet:"+id);
             Users users = usersServer.isExistUsersByID(id);
             log.info("user:"+users);
             request.setAttribute("user", users);
             request.getRequestDispatcher("upUser.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
