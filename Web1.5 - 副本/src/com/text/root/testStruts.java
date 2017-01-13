package com.text.root;

import javax.servlet.http.HttpServletRequest;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.text.root.Test.TestAction;
import com.text.root.model.User;

/**
 * 接收参数四种方式
 * 
 * 1.通过Action属性
 * 
 * 2.domainModel 利用现有model类 
 *   1>private User user; 添加get,set方法 
 *   2>页上form表单name属性指定为： 对象名.属性名 
 *    如: user.name
 * 
 * 3.实现ModelDriven接口方式 
 *     1>实现ModelDriven接口 
 *     2>实例化model类.如 : private User user = new User();
 * 
 *  4.ServletApi request对象
 *    HttpServletRequest request = ServletActionContext.getRequest();
 */
public class testStruts extends TestAction implements ModelDriven<User> {
	private static Logger log = Logger.getLogger(textLog4j.class);
	private User user = new User();


	public String execute() throws Exception {
		log.info("testStruts>>>>>>>>>>");
		if(!"admin".equals(user.getName())){
//            this.addFieldError("testName","用户名错误");
            this.request.setAttribute("testNames","用户名不正确");
			log.debug("asdasd<<<<<,");
			return INPUT;		
		}else if(!"123".equals(user.getPassword())){
//			this.addFieldError("Password","密码错误");
			this.request.setAttribute("Passwords","密码不正确");
			log.debug("accc>>>>");
			return INPUT;
		}
		return SUCCESS;
		
	}

	public String Add() {
		log.debug("add>>>>>>");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		log.debug("姓名 :" + request.getParameter("name") + "密码 :" + request.getParameter("password"));
		if(request.getParameter("name").equals("admin") && request.getParameter("password").equals("123")){
//			log.debug("姓名 :" + user.getName() + " 密码 :" + user.getPassword());
			log.debug("asdasd<<<<<,");
		return "ADD";	
		}else{
			log.debug("accc>>>>");
			return INPUT;
		}
	}

//	 public String Add() {
//	 log.debug("add>>>>>>");
//	 log.debug("姓名 :"+ getUser().getName() +" 密码 :"+ getUser().getPassword());
//	 return "ADD";
//	 }

	public String Update() {
		log.info("up>>>>>..");
		return "UP";

	}
	public String Delete() {
		log.info("de>>>>>..");
		return "DELETE";

	}

	// public User getUser() {
	// return user;
	// }
	//
	// public void setUser(User user) {
	// this.user = user;
	// }

	@Override
	public User getModel() {

		return user;
	}
}
