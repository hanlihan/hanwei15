package com.ittx.student.dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.student.model.Student;



public interface StudentDAO {
	void addStudent(Student student);
     ArrayList<Student> getAllStudent();
     void deleteStudentById(int number);
     void upStudentByNumber(Student student);
	 Student isExistStudentByNumber(int numbers);
	Student selectStudentById(int ids);

}
