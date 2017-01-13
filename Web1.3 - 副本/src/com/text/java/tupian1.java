package com.text.java;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.jspsmart.upload.SmartUpload;
import com.jspsmart.upload.SmartUploadException;



/**
 * Servlet implementation class tupian1
 */
@WebServlet({ "/tupian1", "/tupan1.do" })
public class tupian1 extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
	         File file = new File("E:/imagesss/");
	         if(!file.exists()){
	        	 file.mkdirs();
	         }
	         SmartUpload su = new SmartUpload();
	         su.initialize(getServletConfig(), request, response);
	         String result = "上传成功";
	         try {
				su.upload();
				su.save(file.getPath());
			} catch (SmartUploadException e) {
                result = "上传失败";
				e.printStackTrace();
			}
	         request.setAttribute("result", result);
	         request.getRequestDispatcher("./file.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
