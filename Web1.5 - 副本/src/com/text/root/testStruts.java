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
 * ���ղ������ַ�ʽ
 * 
 * 1.ͨ��Action����
 * 
 * 2.domainModel ��������model�� 
 *   1>private User user; ���get,set���� 
 *   2>ҳ��form��name����ָ��Ϊ�� ������.������ 
 *    ��: user.name
 * 
 * 3.ʵ��ModelDriven�ӿڷ�ʽ 
 *     1>ʵ��ModelDriven�ӿ� 
 *     2>ʵ����model��.�� : private User user = new User();
 * 
 *  4.ServletApi request����
 *    HttpServletRequest request = ServletActionContext.getRequest();
 */
public class testStruts extends TestAction implements ModelDriven<User> {
	private static Logger log = Logger.getLogger(textLog4j.class);
	private User user = new User();


	public String execute() throws Exception {
		log.info("testStruts>>>>>>>>>>");
		if(!"admin".equals(user.getName())){
//            this.addFieldError("testName","�û�������");
            this.request.setAttribute("testNames","�û�������ȷ");
			log.debug("asdasd<<<<<,");
			return INPUT;		
		}else if(!"123".equals(user.getPassword())){
//			this.addFieldError("Password","�������");
			this.request.setAttribute("Passwords","���벻��ȷ");
			log.debug("accc>>>>");
			return INPUT;
		}
		return SUCCESS;
		
	}

	public String Add() {
		log.debug("add>>>>>>");
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpSession session = request.getSession();
		log.debug("���� :" + request.getParameter("name") + "���� :" + request.getParameter("password"));
		if(request.getParameter("name").equals("admin") && request.getParameter("password").equals("123")){
//			log.debug("���� :" + user.getName() + " ���� :" + user.getPassword());
			log.debug("asdasd<<<<<,");
		return "ADD";	
		}else{
			log.debug("accc>>>>");
			return INPUT;
		}
	}

//	 public String Add() {
//	 log.debug("add>>>>>>");
//	 log.debug("���� :"+ getUser().getName() +" ���� :"+ getUser().getPassword());
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
