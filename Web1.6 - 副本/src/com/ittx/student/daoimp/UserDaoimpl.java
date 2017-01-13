package com.ittx.student.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;


import com.ittx.student.model.Student;
import com.ittx.student.model.Users;
import com.ittx.student.Untls.CouneDB;
import com.ittx.student.dao.UserDAO;

public class UserDaoimpl extends CouneDB implements UserDAO {




	@Override
	public ArrayList<Users> getAllUsers() {
		String sql = "select * from users";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Users> userlist = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			userlist = new ArrayList<>();
			while (rs.next()) {
				int ids = rs.getInt("uid");
				String name = rs.getString("username");
				String password = rs.getString("password");
				Users user = new Users(ids,name, password);
				userlist.add(user);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);

		}
		return userlist;
	}


	@Override
	public void deleteUsersById(int id) {
		String sql = "delete from users where uid= ?";
		Connection connect = null;
		PreparedStatement sta = null;
		try {
			connect = getConnection();
			sta = connect.prepareStatement(sql);
			sta.setInt(1, id);
			sta.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
				try {
					if (sta != null) {
					sta.close();
					}
				} catch (SQLException e) {
			}
			closeConnection(connect);
		}
		
	}

	@Override
	public Users Examine(String username, String password) {
		String  sql="select * from Users where userName=? and passWord=?";
	    Connection connect = null;
	    PreparedStatement ps =null;
	    ResultSet rs = null;
	    Users users = null;
	    try {
	        connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1,username);
			ps.setString(2,password);
			rs = ps.executeQuery();
			if(rs.next()){
				String usernames = rs.getString("userName");
				String passwords = rs.getString("passWord");
				
			    users= new Users(usernames, passwords);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			    if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			closeConnection(connect);
			}
	    return users;
	}

	@Override
	public Users Examines(String username) {
		String  sql="select * from Users where userName=?";
	    Connection connect = null;
	    PreparedStatement ps =null;
	    ResultSet rs = null;
	    Users users = null;
	    try {
	        connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setString(1,username);
			rs = ps.executeQuery();
			if(rs.next()){
				String usernames = rs.getString("userName");
				String passwords = rs.getString("passWord");

			    users= new Users(usernames, passwords);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(rs!=null){
					rs.close();
				}
			    if(ps != null){
					ps.close();
				}
			} catch (SQLException e) {
					e.printStackTrace();
				}
			closeConnection(connect);
			}
	    return users;
	}

	@Override
	public void addUser(Users users) {
		String sql = "insert into users (userName,passWord) values(?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			
			ps.setString(1,users.getUsername());
			ps.setString(2, users.getPassword());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try {
				if(ps != null){
					ps.close();
				}
				} catch (SQLException e) {
					e.printStackTrace();
				}
			closeConnection(connect);
		}
		
	}

	@Override
	public Users isExistUsersByID(int id) {
		String sql = "SELECT * FROM users WHERE uid = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Users use = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				int uId = rs.getInt("uid");
				String name = rs.getString("username");
				String password = rs.getString("password");

				use = new Users( uId,name,password);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (ps != null)
					ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
			closeConnection(connect);
		}

		return use;
	}

	@Override
	public void upUSersByName(Users user) {
		String sql = "update users set passWord=? where userName=?";
    	Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, user.getPassword());
			ps.setString(2, user.getUsername());
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
			closeConnection(connect);
		}
	}
}
