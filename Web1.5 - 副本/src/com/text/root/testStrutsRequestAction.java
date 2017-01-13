package com.text.root;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.RequestAware;
import org.apache.struts2.interceptor.SessionAware;
import org.omg.CORBA.PRIVATE_MEMBER;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.text.root.Test.TestAction;
import com.text.root.model.User;

public class testStrutsRequestAction extends TestAction implements ModelDriven<User>,RequestAware,SessionAware,ApplicationAware {
	private static Logger log = Logger.getLogger(textLog4j.class);
	private User user = new User();
    private Map<String, Object> requestMap;
    private Map<String, Object> sessionMap;
    private Map<String, Object> applictionMap;

	public String execute() throws Exception {
		log.info("testStruts>>>>>>>>>>");
		if(!"admin".equals(user.getName())){
			requestMap.put("Names","用户名不正确");
            
			log.debug("asdasd<<<<<,");
			return INPUT;		
		}else if(!"123".equals(user.getPassword())){
			requestMap.put("Passwords","密码不正确");
			log.debug("accc>>>>");
			return INPUT;
		}
		return SUCCESS;
		
	}


	@Override
	public User getModel() {

		return user;
	}

	@Override
	public void setApplication(Map<String, Object> request) {
		requestMap = request;
	}

	@Override
	public void setSession(Map<String, Object> session) {
		sessionMap = session;
	}

	@Override
	public void setRequest(Map<String, Object> appliction) {
		applictionMap = appliction;
	}
}
