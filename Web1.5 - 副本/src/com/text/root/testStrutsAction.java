package com.text.root;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.text.root.Test.TestAction;
import com.text.root.model.User;

public class testStrutsAction extends ActionSupport implements ModelDriven<User> {
	private static Logger log = Logger.getLogger(testStrutsAction.class);
	private User user = new User();

	@Override
	public User getModel() {

		return user;
	}
	public String execute() throws Exception {
		
		log.info("testStrutsRequestAction>>>>>>>>>>");
		ActionContext actionContext = ActionContext.getContext();
		if(!"admin".equals(user.getName())){
            actionContext.put("Names","账户不正确");
			log.debug("asdasd<<<<<,");
			return INPUT;		
		}else if(!"1234".equals(user.getPassword())){
			actionContext.put("Passwords","密码不正确");
			log.debug("accc>>>>");
			return INPUT;
		}else{
			return SUCCESS;
		}
		
	}

	
}
