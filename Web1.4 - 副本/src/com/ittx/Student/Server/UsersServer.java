package com.ittx.Student.Server;

import java.util.ArrayList;

import com.ittx.Student.Model.Users;

public interface UsersServer {
     boolean Examine(String username,String password);
     boolean addUser(Users users);
     ArrayList<Users> getAllUsers();
     void deleteUsersById(int id);
     Users isExistUsersByID(int id);
	 void upUSersByName(Users user);
}
