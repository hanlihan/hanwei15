package com.ittx.student.server;

import java.util.ArrayList;

import com.ittx.student.model.Users;



public interface UsersServer {
     boolean Examine(String username,String password);
     boolean addUser(Users users);
     ArrayList<Users> getAllUsers();
     void deleteUsersById(int id);
     Users isExistUsersByID(int id);
	 void upUSersByName(Users user);
}
