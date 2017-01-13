package com.text.java;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;
import com.sun.org.apache.xerces.internal.util.SynchronizedSymbolTable;




@WebServlet({ "/tupian", "/tupian.do" })
public class tupian extends HttpServlet {
	private static final int maxFileSize = 1024*1024*10;
	private static final int totalMaxFileSize = 1024*1024*100;
	private SimpleDateFormat format = new SimpleDateFormat("yyMMdd_hhmmss");
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
	     String filePath = getServletContext().getRealPath("/") + "imagess";
	     
	     File file =new File(filePath);
	     if(!file.exists()){
	    	 file.mkdir();
	     }
	     SmartUpload su = new SmartUpload();
	     su.initialize(getServletConfig(), req, resp);
	     su.setMaxFileSize(maxFileSize);
	     su.setTotalMaxFileSize(totalMaxFileSize);
	     su.setAllowedFilesList("txt,jpg,gif");
	     String result = "上传成功";
	     
	     try {
			su.setDeniedFilesList("rar,jsp,js");
			su.upload();
			int count = su.save(filePath);
			System.out.println("上传成功"+count+"个文件");
//			 for(int i=0;i<2;i++){
//				 String fileName = String.valueOf(System.currentTimeMillis());
//				 String name = fileName;
//				 String ext = su.getFiles().getFile(0).getFileExt();
//				 String path = name+"."+ext;
//				 su.getFiles().getFile(i).saveAs(filePath+"/"+path);
//			 }
//			 System.out.println("上传文件成功");
            			
		} catch (Exception e) {
			result = "上传失败";
			e.printStackTrace();
		}
	     req.setAttribute("result", result);
	     req.getRequestDispatcher("File1.jsp").forward(req, resp);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
	
}