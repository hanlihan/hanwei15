package com.ittx.student.servlerStruts;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.coyote.http11.InternalNioInputBuffer.HeaderParseData;
import org.apache.struts2.ServletActionContext;
import org.apache.struts2.dispatcher.RequestMap;
import org.apache.struts2.interceptor.RequestAware;

import com.ittx.student.Untls.FileUtil;
import com.ittx.student.model.Student;
import com.ittx.student.model.Users;
import com.ittx.student.server.StudentServlet;
import com.ittx.student.serverimp.StudentServletimpl;
import com.opensymphony.xwork2.ActionSupport;



public class Studentaction extends ActionSupport implements RequestAware {
	private StudentServlet studentServlet = new StudentServletimpl();
	private Map<String, Object> requestMap;
	private File myfile;
	private String myfileFileName;
	private String name;
	private int number;
	private int sex;
	private int id;

	public String execute() throws IOException {
		String headerUrl = "";// 保存头像地址
		if (id == 0) {
			Student stu = studentServlet.isExistStudentByNumber(number);
			if (stu == null) {
				if (myfile != null) {
					String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
					System.out.println("saveDir:" + saveDir);
					File saveFile = new File(saveDir, myfileFileName);
					FileUtil.createFile(saveFile);
					FileUtil.copeFile(myfile, saveFile);
					headerUrl = "/upload/" + myfileFileName;
				}
				Student student = new Student(name, number, sex == 1 ? true : false, headerUrl);
				studentServlet.addStudent(student);
				return SUCCESS;
			} else {
				requestMap.put("message", "添加学生已存在!");
				return INPUT;
			}
		} else {
			// requestMap.put("message", "添加学生已存在!");
			// return INPUT;
			//修改界面
			Student student = studentServlet.selectStudentById(id);
			Student stu = studentServlet.isExistStudentByNumber(number);
			if (stu == null || student.getNumber() == number) {
				headerUrl = student.getSrc();
				if (myfile != null) {
					//删除旧头像
					String oidDir = ServletActionContext.getServletContext().getRealPath("") + headerUrl;
					if (!headerUrl.equals(""))
						FileUtil.deleteFile(oidDir);
					// 上传新头像
				    String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
					File saveFile = new File(saveDir, myfileFileName);
					FileUtil.createFile(saveFile);
					FileUtil.copeFile(myfile, saveFile);
					headerUrl = "/upload/" + myfileFileName;

				}// 更新数据
					student = new Student(id, name, number, sex == 1 ? true : false, headerUrl);
					studentServlet.upStudentByNumber(student);
					return SUCCESS;
				
			} else {
				requestMap.put("message", "学号已存在");
				requestMap.put("stus", student);
				return INPUT;
			}
			
		}

	}

	public String add() throws IOException {
		Student stu = studentServlet.isExistStudentByNumber(number);
		if (stu == null) {
			if (myfile != null) {
				String saveDir = ServletActionContext.getServletContext().getRealPath("/upload");
				System.out.println("saveDir:" + saveDir);
				File saveFile = new File(saveDir, myfileFileName);
				FileUtil.createFile(saveFile);
				FileUtil.copeFile(myfile, saveFile);
			}
			String headerUrl = "/upload/" + myfileFileName;
			Student student = new Student(name, number, sex == 1 ? true : false, headerUrl);
			studentServlet.addStudent(student);
			requestMap.put("message", "添加学生成功!");
			return SUCCESS;
		} else {
			requestMap.put("message", "学生已存在！！");
			return INPUT;
		}
	}

	public String show() {
		System.out.println("show  1111111");
		ArrayList<Student> list = studentServlet.getAllStudent();
		requestMap.put("studentlist", list);
		return "list";
	}

	public String delete() {
		System.out.println("11111111111");
		String saveDir = ServletActionContext.getServletContext().getRealPath("");
		int numb = (int) requestMap.get("number");
		// int numb = number;
		System.out.println(numb);
		studentServlet.deleteStudentById(numb, saveDir);
		return SUCCESS;
	}

	public String update() {
		int numb = (int) requestMap.get("number");
		Student stus = studentServlet.isExistStudentByNumber(numb);
		requestMap.put("stus", stus);
		return INPUT;
	}
    public String find(){
    	Student stu = studentServlet.isExistStudentByNumber(number);
    	requestMap.put("student",stu);
		return "find";    	
    }
	@Override
	public void setRequest(Map<String, Object> request) {
		requestMap = request;

	}

	public File getMyfile() {
		return myfile;
	}

	public void setMyfile(File myfile) {
		this.myfile = myfile;
	}

	public String getMyfileFileName() {
		return myfileFileName;
	}

	public void setMyfileFileName(String myfileFileName) {
		this.myfileFileName = myfileFileName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public int getSex() {
		return sex;
	}

	public void setSex(int sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
