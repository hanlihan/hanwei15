package com.text.java;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



/**
 * Servlet implementation class xiazhai
 */
@WebServlet({ "/xiazhai", "/tupian2" })
public class xiazhai extends HttpServlet {
	
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	        String path = getServletContext().getRealPath("/")+"imagess/";
	        String filename = req.getParameter("filename");
	        File file = new File(path+filename);
	        System.out.println("file:"+file);
	        
	        if(file.exists()){
	        	resp.setContentType("application/x-msdownload");
	        	resp.setHeader("Content-Disposition", "attachment;filename=\""+filename+"\"");
	            InputStream inputStream = new FileInputStream(file);
	            ServletOutputStream ouputStream = resp.getOutputStream();
	            byte b [] = new byte[1024];
	            int n; 
	            while((n= inputStream.read(b)) != -1){
	            	ouputStream.write(b,0,n);
	            }
	            ouputStream.close();
	            inputStream.close();
	        }else{
	        	req.setAttribute("errorResult","文件不存在下载失败");
	        	RequestDispatcher dispatcher = req.getRequestDispatcher("file.jsp");
	            dispatcher.forward(req,resp);
	        }
	}

	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doGet(req, resp);
	}

}
