package com.ittx.Student.ServletText;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.ittx.Student.Daoimpl.StudentDaoimpl;
import com.ittx.Student.Model.Student;

public class StudentDaoimplTest {
    private  StudentDaoimpl stu = new StudentDaoimpl();
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testAddStudent() {
		Student s = new Student("°¢ÈøµÂ", 1003, true, "");
		stu.addStudent(s);
	}

	@Test
	public void testIsExistStudentByNumber() {
		fail("Not yet implemented");
	}

}
