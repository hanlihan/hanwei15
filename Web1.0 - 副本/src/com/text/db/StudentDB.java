package com.text.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.text.bean.Student;

public class StudentDB extends CouneDB {
	private static StudentDB DB = null;

	public static StudentDB getInstance() {
		if (DB == null) {
			DB = new StudentDB();
		}
		return DB;
	}

	private StudentDB() {

	}

	public void addStudent(Student student) {
		String sql = "insert into tdb_ks (number,name,age) values(?,?,?)";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setInt(1, student.getNumber());
			ps.setString(2, student.getName());
			ps.setInt(3, student.getAge());
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

	public ArrayList<Student> getAllStudent() {
		String sql = "select * from tdb_ks";
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
				int number = rs.getInt("number");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Student student = new Student(number, name, age);
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

	public void updateStudentByName(Student student, String name) {
		String sql = "update tdb_ks set grade = ? where name = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, student.getAge());
			ps.setString(2, name);
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
		}
	}

	public void deleteStudentById(int number) {
		String sql = "delete from tdb_ks where number=?";
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

	public void Inquire(int number1) {
		String sql = "Select * from tdb_ks where number=?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number1);
			rs = ps.executeQuery();

			System.err.println("学号" + "\t" + "姓名" + "\t" + "年龄");
			while (rs.next()) {
				int number = rs.getInt("number");
				String name = rs.getString("name");
				int age = rs.getInt("age");
				Student student = new Student(number, name, age);
				System.out.println(student.getNumber() + "\t"
						+ student.getName() + "\t" + student.getAge());

			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (ps != null) {
				try {
					ps.close();
				} catch (SQLException e) {
				}
			}
		}

	}

	public void printAllStudent(ArrayList<Student> studentList) {
		System.err.println("学号" + "\t" + "姓名" + "\t" + "年龄");
		for (Student student : studentList) {
			System.out.println(student.getNumber() + "\t" + student.getName()
					+ "\t" + student.getAge());
		}
	}

	public static void main(String[] args) {
		StudentDB db = StudentDB.getInstance();
		// db.addStudent(new Student(1001, "小明", 89));
		// db.addStudent(new Student(1002, "小丽", 90));
		// db.addStudent(new Student(1003, "张三", 97));
		// db.addStudent(new Student(1004, "李四", 89));
		// db.printAllStudent(db.printMessageAllStudent());
		// db.deleteStudentById(1001);

		// db.updateStudentByName(new Student(1004, "李四", 85), "李四");
		// ArrayList<Student> list = (ArrayList<Student>) db.getAllStudent();
		// for (Student student : list) {
		// System.out.println(student);
		// System.out.println(db.AVG());
		// }
		db.printAllStudent(db.getAllStudent());
	}

}
