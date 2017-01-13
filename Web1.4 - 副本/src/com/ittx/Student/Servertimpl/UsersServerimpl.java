package com.ittx.Student.Servertimpl;

import java.util.ArrayList;

import com.ittx.Student.Dao.UserDAO;
import com.ittx.Student.Daoimpl.UserDaoimpl;
import com.ittx.Student.Model.Student;
import com.ittx.Student.Model.Users;
import com.ittx.Student.Server.UsersServer;

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
	public boolean addUser(Users user) {
		if(userDAO.Examines(user.getUsername()) == null){
			userDAO.addUser(user);
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
		userDAO.upUSersByName(user);
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

}
