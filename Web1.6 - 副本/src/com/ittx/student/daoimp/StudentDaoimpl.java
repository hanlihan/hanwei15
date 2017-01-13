package com.ittx.student.daoimp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.student.Untls.CouneDB;
import com.ittx.student.dao.StudentDAO;
import com.ittx.student.model.Student;






public class StudentDaoimpl extends CouneDB implements StudentDAO {

	public ArrayList<Student> getAllStudent() {
		String sql = "select * from student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			studentList = new ArrayList<>();
			while (rs.next()) {
				String name = rs.getString("name");
				int number = rs.getInt("number");
				boolean sex = rs.getBoolean("sex");
				String src = rs.getString("src");
				Student student = new Student(name, number,sex,src);
				studentList.add(student);
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
		return studentList;
	}
	public void deleteStudentById(int number) {
		String sql = "delete from student where number=?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
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
	public void addStudent(Student student) {
		String sql = "insert into student (number,name,sex,src) values(?,?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setInt(1, student.getNumber());
			ps.setString(2, student.getName());
			ps.setBoolean(3, student.isSex());
			ps.setString(4,student.getSrc());
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
	public void upStudentByNumber(Student student) {
		String sql = "update student set name=?,sex=?,src=? ,number=? where id=?";
    	Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setBoolean(2, student.isSex());
			ps.setString(3, student.getSrc());
			ps.setInt(4, student.getNumber());
			ps.setInt(5, student.getId());
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
	public Student isExistStudentByNumber(int numbers) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, numbers);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int num = rs.getInt("number");
				boolean sex = rs.getBoolean("sex");
				String src = rs.getString("src");
				
				student = new Student( id,name,num,sex,src);
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

		return student;
	}
	@Override
	public Student selectStudentById(int ids) {
		String sql = "SELECT * FROM student WHERE id = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, ids);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				int num = rs.getInt("number");
				boolean sex = rs.getBoolean("sex");
				String url = rs.getString("src");
				student = new Student(id,name,num, sex,url);
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

		return student;
	}
	
	
	
	
	
}
