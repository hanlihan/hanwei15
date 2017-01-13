package com.text.Web;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.text.bean.Student1;
import com.text.db.StudenttDB;

@WebServlet({ "/UpStuServler", "/upstuservlet" })
public class UpStuServler extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");

		HashMap<String, String> parameterMap = new HashMap<>();

		uploadFileAndStudent(request, parameterMap);
		deleteHeaderImg(parameterMap);
		updateStudent(parameterMap);
		response.sendRedirect(request.getContextPath() + "/GetStu2.jsp");
	}
/*
 * 修改
 */
	private void updateStudent(HashMap<String, String> parameterMap) {
		String userName = parameterMap.get("userName");
		String number = parameterMap.get("number");
		String sex = parameterMap.get("sex");
		String head_url = parameterMap.get("head_img");
		int numbers = Integer.parseInt(number);
		boolean sexs = sex.equals("1") ? true : false;

		Student1 stu = new Student1(numbers, userName, sexs, head_url);
		StudenttDB.getInstance().upStudentByNumber(stu);
	}
/*
 *删除图片 
 */
	private void deleteHeaderImg(HashMap<String, String> parameterMap) {
		String number = parameterMap.get("number");
		String headerUrl = parameterMap.get("head_img");
		Student1 student = StudenttDB.getInstance().findStudentByNumber(Integer.parseInt(number));
		String head_img = student.getSrc();
//		System.out.println(",,,,,,," + head_img);
		if(headerUrl.equals("")){//不删除源头相
			parameterMap.put("head_img",head_img);
			return;
		}
		String head_file = getServletContext().getRealPath("/") + head_img;
//		System.out.println(">>>>" + getServletContext().getRealPath("/"));
		System.out.println("head_file:" + head_file);
		File file = new File(head_file);
		System.out.println("file:" + file);
		if (file.exists()) {
			file.delete();
			
		}
	}

	private void uploadFileAndStudent(HttpServletRequest request, HashMap<String, String> parameterMap)
			throws UnsupportedEncodingException {
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		servletFileUpload.setHeaderEncoding("utf-8");
		List<FileItem> fileItems = null;
		try {
			fileItems = servletFileUpload.parseRequest(request);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> iterator = fileItems.iterator();
		while (iterator.hasNext()) {
			FileItem fileItem = iterator.next();
			if (fileItem.isFormField()) {
				String filedName = fileItem.getFieldName();
				String fileValue = fileItem.getString("UTF-8");
				parameterMap.put(filedName, fileValue);
			} else {// 文件操作
				if(fileItem.getName() == null || fileItem.getName().equals("")){//表示未修改头像图片
					parameterMap.put(fileItem.getFieldName(),"");
					continue;
				}
				String rootDir = getServletContext().getRealPath("/");
				String fileDir = "upload/" + fileItem.getName();
				File file = new File(rootDir + fileDir);
				try {
					fileItem.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				parameterMap.put(fileItem.getFieldName(), fileDir);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
