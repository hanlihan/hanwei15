package com.ittx.student.server;

import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.student.model.Student;



public interface StudentServlet {
    ArrayList<Student> getAllStudent();
    void deleteStudentById(int number,String rootDir);
    void upStudentByNumber(Student student);
    Student isExistStudentByNumber(int numbers);
	boolean addStudent(HashMap<String, String> paramters, String rootDir);
	void addStudent(Student student);
	Student selectStudentById(int ids) ;
}
