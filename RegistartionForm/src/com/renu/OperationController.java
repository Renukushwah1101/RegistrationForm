package com.renu;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.renu.hibernate.DAO.FilesDAO;
import com.renu.hibernate.entity.Files;


@WebServlet("/Operation")

@MultipartConfig
public class OperationController extends HttpServlet {
	private static final long serialVersionUID = 1L;

String path="F:/RENU/H/eclipseProject/RegistartionForm/WebContent/images/";
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("page");
		action = action.toLowerCase();

		switch (action) {
		  case "listuser":
		    	listUser(request,response);
	          break;
		         case "deleteuser":
			     deleteUser(request,response);
                 break;
	         case "updateuser":
		     updateUser(request,response);
             break;
	     }
	}

	private void updateUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int fileId=Integer.parseInt(request.getParameter("fileId"));
		 List<Files> files = new FilesDAO().result(fileId);
			request.setAttribute("listUser", files);
			request.getRequestDispatcher("updateForm.jsp").forward(request, response);
			
	}

	private void deleteUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 int fileId=Integer.parseInt(request.getParameter("fileId"));
			Files file =new FilesDAO().getFile(fileId);
			new FilesDAO().deleteFile(fileId);
			File fileOnDisc =new File(path +file.getName());
			if(fileOnDisc.delete())
			{
				System.out.println("File is  delete from file system");
			}
			else {
				System.out.println("File is not delete from file system");
			}
				
			listingUser(request,response);
	}

	private void listingUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Files> files = new FilesDAO().resultout();
		request.setAttribute("files", files);
		request.setAttribute("path", path);
		request.getRequestDispatcher("listOfUsers.jsp").forward(request, response);
		
	}

	private void listUser(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Files> fil = new FilesDAO().resultout();
		request.setAttribute("files", fil);
		request.setAttribute("path", path);
		request.getRequestDispatcher("listOfUsers.jsp").forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    String form = request.getParameter("form");
		form = form.toLowerCase();

		switch (form) {
		  case "register":
		    	register(request,response);
		  case "updateRecord":
		    	updateRecord(request,response);
		    	
	          }
	}

	private void updateRecord(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pin = request.getParameter("pin");
		String  state= request.getParameter("state");
		String email = request.getParameter("email");
		String contact=request.getParameter("phone");
		int id = Integer.parseInt(request.getParameter("id"));
		
		Part part = request.getPart("file");//
		System.out.println("part name " + part);
		String fileName = extractFileName(part);// file name
		System.out.println("filename" + fileName);

		String savePath = "F:/RENU/H/eclipseProject/RegistartionForm/WebContent/images"
				+ File.separator + fileName;
		System.out.println("savePath: " + savePath);

		File photo= new File(savePath + fileName);

		System.out.println(fileName);
		part.write(savePath + File.separator);
        new FilesDAO().updateDetails(id,userid,name,fileName,gender,address,city,pin,state,email,contact);
		request.getRequestDispatcher("successful.jsp").forward(request, response);
		
		
	}

	private void register(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userid = request.getParameter("userid");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String address = request.getParameter("address");
		String city = request.getParameter("city");
		String pin = request.getParameter("pin");
		String  state= request.getParameter("state");
		String email = request.getParameter("email");
		String contact=request.getParameter("phone");
		System.out.println(userid);
		System.out.println(name);
		System.out.println(gender);
		System.out.println(city);
		System.out.println(pin);
		System.out.println(state);
		System.out.println(email);
		System.out.println(contact);
		Part part = request.getPart("file");//
		System.out.println("part name " + part);
		String fileName = extractFileName(part);// file name
		System.out.println("filename" + fileName);

		String savePath = "F:/RENU/H/eclipseProject/RegistartionForm/WebContent/images"
				+ File.separator + fileName;
		System.out.println("savePath: " + savePath);

		File photo= new File(savePath + fileName);

		System.out.println(fileName);
		part.write(savePath + File.separator);
		
		Files file = new Files(userid,name,fileName,gender,address,city,pin,state,email,contact);
        new FilesDAO().addFileDetails(file);
		request.getRequestDispatcher("success.jsp").forward(request, response);
		
	}

	private String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}
}


