package com.ittx.Student.Dao;

import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.Student.Model.Student;

public interface StudentDAO {
	void addStudent(Student student);
     ArrayList<Student> getAllStudent();
     void deleteStudentById(int number);
     void upStudentByNumber(Student student);
	 Student isExistStudentByNumber(int numbers);

}
