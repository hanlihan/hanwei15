package com.text.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.text.bean.Student1;

public class StudenttDB extends CouneDB {
	private static StudenttDB DB = null;

	public static StudenttDB getInstance() {
		if (DB == null) {
			DB = new StudenttDB();
		}
		return DB;
	}

	private StudenttDB() {

	}

	public void addStudent(Student1 student) {
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

	public ArrayList<Student1> getAllStudent() {
		String sql = "select * from student";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		ArrayList<Student1> studentList = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			rs = ps.executeQuery();

			studentList = new ArrayList<>();
			while (rs.next()) {
				int number = rs.getInt("number");
				String name = rs.getString("name");
				boolean sex = rs.getBoolean("sex");
				String src = rs.getString("src");
				Student1 student = new Student1(number, name,sex,src);
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
    public void upStudentByNumber(Student1 student){
    	String sql = "update student set name=?,sex=?,src=? where number=?";
    	Connection connect = null;
		PreparedStatement ps = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);

			ps.setString(1, student.getName());
			ps.setBoolean(2, student.isSex());
			ps.setString(3, student.getSrc());
			ps.setInt(4, student.getNumber());
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
    
	public Student1 findStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		Student1 student = null;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if (rs.next()) {
				int num = rs.getInt("number");
				String name = rs.getString("name");
				boolean sex = rs.getBoolean("sex");
				String src = rs.getString("src");
				
				student = new Student1( num,name,sex,src);
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

	public void Inquire(int number) {
		String sql = "Select * from student where number=?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null; 

		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();

			System.err.println("学号" + "\t" + "姓名" );
			while (rs.next()) {
				int number1 = rs.getInt("number");
				String name = rs.getString("name");
				boolean sex = rs.getBoolean("sex");
				String src = rs.getString("src");
				Student1 student = new Student1(number, name,sex,src);
				System.out.println(student.getNumber() + "\t"
						+ student.getName() +"\t"+student.isSex()+"\t"+student.getSrc());

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

	public boolean isExistStudentByNumber(int number) {
		String sql = "SELECT * FROM student WHERE number = ?";
		Connection connect = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		boolean result = false;
		try {
			connect = getConnection();
			ps = connect.prepareStatement(sql);
			ps.setInt(1, number);
			rs = ps.executeQuery();
			if (rs.next()) {
				result = true;
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

		return result;
	}
	public void printAllStudent(ArrayList<Student1> studentList) {
		System.err.println("学号" + "\t" + "姓名" + "\t" + "年龄");
		for (Student1 student : studentList) {
			System.out.println(student.getNumber() + "\t" + student.getName());
		}
	}

	public static void main(String[] args) {
		StudenttDB db = StudenttDB.getInstance();
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
