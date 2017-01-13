package com.ittx.Student.Dao;

import java.util.ArrayList;

import com.ittx.Student.Model.Student;
import com.ittx.Student.Model.Users;

public interface UserDAO {
	Users Examine(String username,String password);
	Users Examines(String username);
	void addUser(Users users);
	ArrayList<Users> getAllUsers();
	void deleteUsersById(int id);
	Users isExistUsersByID(int id);
	 void upUSersByName(Users user);

}
