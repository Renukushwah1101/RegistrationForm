<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>  
<html>  
<head>  
<meta charset="ISO-8859-1">
<style>  
body{  
  font-family: Calibri, Helvetica, sans-serif;  
  background-color: pink;  
}  
.container {  
    padding: 50px;  
  background-color: lightblue;  
}  
  
input[type=text],input[type="tel"],input[type=password], textarea {  
  width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;  
}  
input[type=text]:focus, input[type=password]:focus {  
  background-color: orange;  
  outline: none;  
}  
 div {  
            padding: 10px 0;  
         } 

.gen{
   width: 100%;  
  padding: 15px;  
  margin: 5px 0 22px 0;  
  display: inline-block;  
  border: none;  
  background: #f1f1f1;
}          
hr {  
  border: 1px solid #f1f1f1;  
  margin-bottom: 25px;  
}  
.registerbtn {  
  background-color: #4CAF50;  
  color: white;  
  padding: 16px 20px;  
  margin: 8px 0;  
  border: none;  
  cursor: pointer;  
  width: 100%;  
  opacity: 0.9;  
}  
.registerbtn:hover {  
  opacity: 1;  
}  
</style>  
</head>  
<body>  
                 
  
<form  action="${pageContext.request.contextPath}/Operation" method="post" enctype="multipart/form-data">  
  <div class="container">  
  <center>  <h1>Registeration Form <a href="${pageContext.request.contextPath}/Operation?page=listuser"><span style="float: right;"><u>ListOfUser</u></span></a></h1> </center>  
  <hr>  
  <label> Id: </label>   
<input type="text" name="userid" placeholder= "enter ID" /> 

 <label>  Name:</label>   
<input type="text" name="name" id="name" placeholder= "Name"  />

<label> Choose file: </label>   
<input type="file" name="file" placeholder="Photo Upload" id="file" />  
<div class="gen">  
<label>      
Gender :  
</label><br>  
<input type="radio" value="Male" name="gender" checked > Male   
<input type="radio" value="Female" name="gender"> Female   
</div> 

<label> 
Address : 
</label> 
<textarea cols="80" rows="5" placeholder="Address" value="address" name="address">  
</textarea>

<div>
<label>  city:</label>   
<input type="text" name="city" placeholder= "city"  /> 
<label> 
<div>

<label>  Pincode:</label>   
<input  type="tel" name="pin" id="pin" placeholder="Pin" maxlength="6"/> 

<label>  State:</label>   
<input type="text" name="state"id="state" placeholder="State" /> 
  
<label><b>Email</b></label>  
 <input type="email" placeholder="Enter Email" name="email" >
 
 <div>
<label> ContactNumber :  </label>  
<input   type="tel" name="phone" id="phone" placeholder="ContactNumber"   maxlength="10"/>  
</div> 
     <input type="hidden" name="form" value="register">
    <input type="submit" value="submit" class="registerbtn" />    
</form>  
</body>  
</html>  