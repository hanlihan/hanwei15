package com.ittx.studentmange.servlet;

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

import com.ittx.Student.Servertimpl.StudentServletimpl;
import com.ittx.Student.Untls.FileUtil;

@WebServlet({ "/upStudent", "/upstudent.do" })
public class upStudent extends HttpServlet {
	private StudentServletimpl stu = new StudentServletimpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HashMap<String, String> paramterMap = new HashMap<String, String>();
		uploadHeader(request, paramterMap);
		deleteHeaderImg(paramterMap);
		updateStudent(paramterMap);
	}

	private void updateStudent(HashMap<String, String> paramterMap) {
		
	}

	private void deleteHeaderImg(HashMap<String, String> paramterMap) {
		
	}

	private void uploadHeader(HttpServletRequest request, HashMap<String, String> paramterMap)
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
				String fileValue = fileItem.getString("Utf-8");
				paramterMap.put(filedName, fileValue);
			} else {
				String rootDir = getServletContext().getRealPath("/");
				String fileDir = "upload/" + fileItem.getName();
				File file = new File(rootDir, fileDir);
				FileUtil.createFile(file);
				System.out.println(file);
				try {
					fileItem.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}
				paramterMap.put(fileItem.getFieldName(), fileDir);
			}
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
