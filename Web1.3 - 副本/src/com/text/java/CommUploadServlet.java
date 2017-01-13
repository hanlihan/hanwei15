package com.text.java;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

@WebServlet({ "/CommUploadServlet", "/CommUploadServlet.do" })
public class CommUploadServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
            DiskFileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload diskFileUpload = new ServletFileUpload(factory);
	        diskFileUpload.setHeaderEncoding("utf-8");
	        HashMap<String,String> parameters =new HashMap<String,String>();
	        List paramItems = null;
	        try {
				paramItems = diskFileUpload.parseRequest(request);
			} catch (FileUploadException e) {
				e.printStackTrace();
			}
	        Iterator i = paramItems.iterator();
	        while(i.hasNext()){
	        	FileItem fi = (FileItem) i.next();
	        	if(!fi.isFormField()){
	        		String fileName = fi.getName();
	        		String contentType = fi.getContentType();
	        		String savaFile = "images/"+fileName;
	        		String filePath =getServletContext().getRealPath("/")+savaFile;
	        		File file = new File(filePath);
	        		try {
						fi.write(file);
					} catch (Exception e) {
						e.printStackTrace();
					}
	        		parameters.put("header_url", savaFile);
	        	}else{
	        		String name = fi.getFieldName();
       	        	String value = fi.getString("utf-8");
       	        	parameters.put(name, value);
       	        	System.out.println(name+":"+value);
	        	}
	        }
	        String number = parameters.get("number");
   	        String userName = parameters.get("userName"); 
	        String headerUrl = parameters.get("header_url");
	        
	        request.getRequestDispatcher("AddStu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
