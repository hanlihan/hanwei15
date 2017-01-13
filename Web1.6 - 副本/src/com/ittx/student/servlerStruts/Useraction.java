package com.ittx.student.servlerStruts;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.interceptor.RequestAware;

import com.ittx.student.model.Users;
import com.ittx.student.server.UsersServer;
import com.ittx.student.serverimp.UsersServerimpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class Useraction extends ActionSupport implements ModelDriven<Users>, RequestAware {
	private Users user = new Users();
	private UsersServer users = new UsersServerimpl();
	private Map<String, Object> requestMap;

	@Override
	public String execute() throws Exception {
		System.out.println("long.do execute >>>>>>>>>>>>>.");
		if (users.Examine(user.getUsername(), user.getPassword())) {
			return SUCCESS;
		} else {
			requestMap.put("error", "账户密码不正确");
			return INPUT;
		}

	}

	@Override
	public Users getModel() {
		return user;
	}

	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;
	}
}
