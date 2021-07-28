<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import=" com.renu.hibernate.entity.Files"%>
<%@ page import=" java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>



	<%!String form;
	int fileId;%>

	<h1>list Of Users</h1>
&nbsp;&nbsp;&nbsp;&nbsp; | <a href="${pageContext.request.contextPath}">RegistrationPage</a>
<hr>

<br/>
	<table border=1>
		<tr>
			<th>Preview</th>
			<th>Available information</th>
			<th>Update information</th>
			<th>Action</th>


			<%
			String path = (String) request.getAttribute("path");
			   List<Files> files = (List<Files>) request.getAttribute("files");
			   for(Files file: files){
				   out.print("<tr><td><img src="+path+file.getFile()+" height='200'></td>");
				   out.print("<td><ul>"+
						   "<li>User ID: "+file.getUserid()+"</li>"+
						   "<li>User name: "+file.getName()+"</li>"+
						   "<li>User Gender: "+file.getGender()+"</li>"+
						   "<li>User Addess: "+file.getAddress()+"</li>"+
						   
						   "</ul></td>");
			               out.print( "<td><ul><li><a href='" + request.getContextPath() + "/Operation?page=updateuser&fileId="
									+ file.getId()
									+ "'>Update</a></li></ul></td>");
				   
			              	out.print("<td><ul><li><a href='" + request.getContextPath() + "/Operation?page=deleteuser&fileId="
								+ file.getId()
								+ "' onclick=\"if(!confirm('Are you sure to delete the user?')) return false\">Delete</a></li></ul></td></tr>");

					}
			   
			%>
			
</body>
</html>