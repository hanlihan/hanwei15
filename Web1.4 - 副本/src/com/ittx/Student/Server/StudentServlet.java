package com.ittx.Student.Server;

import java.util.ArrayList;
import java.util.HashMap;

import com.ittx.Student.Model.Student;

public interface StudentServlet {
    ArrayList<Student> getAllStudent();
    void deleteStudentById(int number,String rootDir);
    void upStudentByNumber(Student student);
    Student isExistStudentByNumber(int numbers);
	boolean addStudent(HashMap<String, String> paramters, String rootDir);
}
