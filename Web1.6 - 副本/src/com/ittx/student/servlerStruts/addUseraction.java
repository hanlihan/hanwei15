package com.ittx.student.servlerStruts;

import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.interceptor.RequestAware;

import com.ittx.student.model.Users;
import com.ittx.student.server.UsersServer;
import com.ittx.student.serverimp.UsersServerimpl;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

public class addUseraction extends ActionSupport implements ModelDriven<Users>, RequestAware {
	private Users user = new Users();
	private UsersServer users = new UsersServerimpl();
	private Map<String, Object> requestMap;

	public String Add(){
		System.out.println("id :"+user.getId());
		if(user.getId() ==0){
			if (users.addUser(user)) {
				return SUCCESS;
			}else{
				requestMap.put("error", "账户已存在");
				return INPUT;
			}	
		}else{
			users.upUSersByName(user);
			return SUCCESS;
		}
	}
	public String GetUser() {
		ArrayList<Users> userlist = users.getAllUsers();
		requestMap.put("userLists", userlist);
		return "GET";

	}

  public String update(){
	 int id = (int) requestMap.get("id");
	 Users user = users.isExistUsersByID(id);
	 requestMap.put("user", user);
	  return INPUT;
	  
  }
	public String delete(){
		int id= (int) requestMap.get("id");
		users.deleteUsersById(id);
		return SUCCESS;
		
	}
	public String find(){
		int id = (int) requestMap.get("id");
		if(users.isExistUsersByID(id) == null ){
			requestMap.put("eorrey", "id不存在");
			return "FINDD";
		}else{			
			Users user = users.isExistUsersByID(id);
			requestMap.put("use", user);
			System.out.println(user);
			return "FIND";
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
