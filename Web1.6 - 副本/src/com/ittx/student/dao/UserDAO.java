package com.ittx.student.dao;

import java.util.ArrayList;

import com.ittx.student.model.Users;


public interface UserDAO {
	Users Examine(String username,String password);
	Users Examines(String username);
	void addUser(Users users);
	ArrayList<Users> getAllUsers();
	void deleteUsersById(int id);
	Users isExistUsersByID(int id);
	 void upUSersByName(Users user);

}
