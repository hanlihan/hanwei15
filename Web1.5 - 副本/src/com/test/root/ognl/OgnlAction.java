package com.test.root.ognl;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import com.mysql.fabric.xmlrpc.base.Array;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.util.ValueStack;
import com.text.root.Test.TestAction;
import com.text.root.model.User;

public class OgnlAction extends TestAction {
 
	private String name;
	private User user =new User();
    private List<User> list = new ArrayList<User>();
	@Override
	public String execute() throws Exception {
        ActionContext actionContext = ActionContext.getContext();
        ValueStack valueStack = actionContext.getValueStack();
        valueStack.push("ognl名称");
 
        
		name = "小米";
		user.setName("阿萨德");
		user.setPassword("1002");
		list.add(new User("米霉神", "444"));
		list.add(new User("闷骚门神", "4444"));
		return SUCCESS;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		
		this.name = name;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public List<User> getList() {
		return list;
	}

	public void setList(List<User> list) {
		this.list = list;
	}
}
