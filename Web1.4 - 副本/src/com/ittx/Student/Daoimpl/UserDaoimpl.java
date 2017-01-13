package com.ittx.Student.Daoimpl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import com.ittx.Student.Dao.UserDAO;
import com.ittx.Student.Model.Student;
import com.ittx.Student.Model.Users;
import com.ittx.Student.Untls.CouneDB;

public class UserDaoimpl extends CouneDB implements UserDAO {


	@Override
	public Users Examine(String username,String password) {
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
				int number = rs.getInt("number");
			    users= new Users(usernames, passwords,number);
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
		String sql = "insert into users (userName,passWord,number) values(?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			
			ps.setString(1,users.getUsername());
			ps.setString(2, users.getPassword());
			ps.setInt(3, users.getNumber());
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
				int num = rs.getInt("number");
				
				use = new Users( uId,name,password,num);
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
				int num = rs.getInt("number");
				Users user = new Users(ids,name, password, num);
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
	public void upUSersByName(Users user) {
		String sql = "update users set passWord=?,number=? where userName=?";
    	Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, user.getPassword());
			ps.setInt(2, user.getNumber());
			ps.setString(3, user.getUsername());
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
				int number = rs.getInt("number");
			    users= new Users(usernames, passwords,number);
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
}
