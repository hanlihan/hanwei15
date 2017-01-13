package com.ittx.student.serverimp;

import java.util.ArrayList;

import com.ittx.student.dao.UserDAO;
import com.ittx.student.daoimp.UserDaoimpl;
import com.ittx.student.model.Users;
import com.ittx.student.server.UsersServer;



public class UsersServerimpl implements UsersServer {
    private UserDAO userDAO = new UserDaoimpl();
	@Override
	public boolean Examine(String username, String password) {
        Users users  = userDAO.Examine(username, password);
        System.out.println(users);
        if(users == null){
        	return false;	
        }else{
        	return true;
        }
	}

	@Override
	public ArrayList<Users> getAllUsers() {
		ArrayList<Users> list = userDAO.getAllUsers();
		
		return list;
	}
	@Override
	public void deleteUsersById(int idr) {
		 userDAO.deleteUsersById(idr);
		
	}
	@Override
	public boolean addUser(Users userst) {
		if(userDAO.Examines(userst.getUsername()) == null){
			userDAO.addUser(userst);
			return true;
		}else{			
			return false;
		}
	}
	@Override
	public Users isExistUsersByID(int id) {
		return  userDAO.isExistUsersByID(id);
	}
	@Override
	public void upUSersByName(Users user) {
		System.out.println("server :"+user);
		userDAO.upUSersByName(user);
		
	}

}
