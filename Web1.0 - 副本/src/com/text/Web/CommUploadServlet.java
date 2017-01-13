package com.text.Web;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import javax.print.attribute.HashAttributeSet;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.coyote.http11.InternalNioInputBuffer.HeaderParseData;

import com.sun.crypto.provider.RSACipher;
import com.text.bean.Student1;
import com.text.db.StudentDB;
import com.text.db.StudenttDB;

@WebServlet({ "/CommUploadServlet", "/commUploadServlet.do" })
public class CommUploadServlet extends HttpServlet {

	public StudentDB studentDB;

	@Override
	public void init(ServletConfig config) throws ServletException {
		studentDB = StudentDB.getInstance();
		System.out.println(123456);
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html;charset=utf-8");
		uploadFileAndStudent(request, response);

	}

	public void uploadFileAndStudent(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException{
		ServletFileUpload servletFileUpload = new ServletFileUpload(new DiskFileItemFactory());
		servletFileUpload.setHeaderEncoding("utf-8");
		// 定义一个HashMap，存放请求参数
		HashMap<String, String> parameters = new HashMap<String, String>();
		// 得到所有的文件，以及其它请求参数：
		List<FileItem> fileItems = null;
		try {
			fileItems = servletFileUpload.parseRequest(req);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		Iterator<FileItem> i = fileItems.iterator();
		// 依次处理每一个文件，以及请求参数：
		while (i.hasNext()) {
			FileItem itemFile = (FileItem) i.next();
			// 如果是请求参数
			if (itemFile.isFormField()) {
				String name = itemFile.getFieldName();
				String value = itemFile.getString("utf-8");
				parameters.put(name, value);
                
			} else {// 如果是文件,进行上传操作
				String name = itemFile.getFieldName();
//				System.out.println(">>>>>"+name);
				String fileName = itemFile.getName(); 
//				System.out.println(">>>>>"+fileName);
                String contentType = itemFile.getContentType();
//                 System.out.println(">>>>>"+4556);
                
                //文件预备存放的位置  
//                String filePaths="F:/Web1.0/images";
//                System.out.println(" getServletContext()>>>>>>>>>>>>>"+req);
//                System.out.println(" getServletContext()" + req.getServletContext());
                String filePath = req.getServletContext().getRealPath("/") + "upload/"+fileName;
//                System.out.println(">>>>>"+4556);
//                System.out.println(" ..."+getServletContext().getRealPath("/"));
                System.out.println(fileName +" ;  "+ contentType+"\n"+filePath);
                File file = new File(filePath);  
                FileUtil.createFile(file);
                try {
					itemFile.write(file);
				} catch (Exception e) {
					e.printStackTrace();
				}  
              
                parameters.put(name, "upload/"+fileName);
			}
		}
		
		addStudents(parameters,req,resp);
	}

	private void addStudents(HashMap<String, String> parameters, HttpServletRequest request,
			HttpServletResponse response) throws  ServletException,IOException  {
		String number = parameters.get("number");
		String userName = parameters.get("userName");
		String headerUrl = parameters.get("header_url");
		int numbers = Integer.parseInt(number);
		System.out.println("userName:"+userName+", number :"+number+" ,fileUrl :"+headerUrl);
		if (StudenttDB.getInstance().isExistStudentByNumber(numbers)) {
			// response.sendRedirect("./AddStu.jsp?flag=false");
			request.getRequestDispatcher("./AddStu.jsp?flag=false").forward(request, response);
			;

		} else {
			Student1 student = new Student1(numbers, userName, true, headerUrl);
			StudenttDB.getInstance().addStudent(student);
			response.sendRedirect("./GetStu2.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
