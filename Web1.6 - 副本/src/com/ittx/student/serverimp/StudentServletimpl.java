package com.ittx.student.serverimp;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.student.Untls.FileUtil;
import com.ittx.student.dao.StudentDAO;
import com.ittx.student.daoimp.StudentDaoimpl;
import com.ittx.student.model.Student;
import com.ittx.student.server.StudentServlet;




public class StudentServletimpl  implements StudentServlet {
         private  StudentDAO dao = new StudentDaoimpl();   
	

	@Override
	public ArrayList<Student> getAllStudent() {
		ArrayList<Student> list  = dao.getAllStudent();
		return list;
		
	}

	@Override
	public void deleteStudentById(int number,String rootDir) {
		Student student = dao.isExistStudentByNumber(number);
		String headerUrl = student.getSrc();
		try {
			FileUtil.deleteFile(rootDir+headerUrl);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		dao.deleteStudentById(number);
	}



	@Override
	public boolean addStudent(HashMap<String, String> paramters,String rootDir) {
		String number = paramters.get("number");
		String userName = paramters.get("userName");
		String headerUrl = paramters.get("header_url");
		boolean sex = paramters.get("sex").equals("1")?true:false;
		int numbers = Integer.parseInt(number);
//		System.out.println("userName:"+userName+", number :"+number+" ,fileUrl :"+headerUrl);
		Student student = dao.isExistStudentByNumber(numbers);
		if(student == null){
			Student stu = new Student(userName, numbers, sex, headerUrl);
					dao.addStudent(stu);
					return true;
		}else{
			if(!headerUrl.equals("")){				
				try {
					FileUtil.deleteFile(rootDir+headerUrl);
				} catch (FileNotFoundException e) {
					e.printStackTrace();
				}
			}
			return false;
		}
		
	}

	

	@Override
	public void upStudentByNumber(Student student) {
		dao.upStudentByNumber(student);
		
	}

	@Override
	public Student isExistStudentByNumber(int numbers) {
		Student student = dao.isExistStudentByNumber(numbers);
		return student;
	}

	@Override
	public void addStudent(Student student) {
		dao.addStudent(student);
		
	}


	@Override
	public Student selectStudentById(int ids) {
		return dao.selectStudentById(ids);
		
	}


}
