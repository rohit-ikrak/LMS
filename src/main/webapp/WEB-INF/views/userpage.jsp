
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored = "false" %>
<%
	User user=(User)session.getAttribute("currentuser");
	if(user==null){
		
		session.setAttribute("message", "You are not logged in!! Login First");
		response.sendRedirect("login");
		return;
	}
%>
<!doctype html>
<html lang="en">

<head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css"
        integrity="sha384-xOolHFLEh07PJGoPkLv1IbcEPTNtaed2xpHsD9ESMhqIYd0nLMwNLD69Npy4HI+N" crossorigin="anonymous">

    <title>LMS</title>
    <link rel="icon" href="" type="image/png">
    <!-- linking local css file -->
	<link rel="stylesheet" href="<c:url value="/resources/css/style.css" />" >
</head>

<body>
    <div class="topnav">
        <a href="index.html" class="active">LMS</a>
        <div class="topnav-right">
            <a href="${pageContext.request.contextPath}/userpage" class="active">Profile</a>
            <a href="${pageContext.request.contextPath}/mybooks">My Books</a>
            <a href="${pageContext.request.contextPath}/library">Library</a>
            <a href="${pageContext.request.contextPath}/logout" class="warning">Logout</a>
        </div>
    </div>

    <div class="main">
        <div class="container mt-3">
            <div class="col-md-6 offset-md-3">
                <h1 class="text-center mb-3">Welcome, ${currentuser.name}!</h1>
            </div>
            <div class="border border-danger my-5">
                <div class="col-md-8 offset-md-2 mt-5 mb-3">    
                    <form action="${pageContext.request.contextPath}/userpage/updateuserdata" method="post">
                        <div class="form-group">
                            <input type="hidden" class="form-control" name="id" id="id" value="${currentuser.id}"/>
                            
                            <label for="name">Name</label>
                            <input type="text" 
                                class="form-control mb-3" 
                                name="name" 
                                id="name" 
                                placeholder="Enter name to update" 
                                value="${currentuser.name}"/>
                            
                            <div class="form-group row">
                                <div class="col">
                                    <label for="email">Email</label>    
                                    <input type="text" 
                                        class="form-control mb-2" 
                                        name="email" 
                                        id="email" 
                                        placeholder="Enter name to update" 
                                        value="${currentuser.email}"/>
                                    </div>
                                <div class="col">
                                    <label for="phoneno">Mobile Number</label>
                                    <input type="text" 
                                        class="form-control mb-2" 
                                        name="phoneno" 
                                        id="phoneno" 
                                        placeholder="Enter mobile number to update" 
                                        value="${currentuser.phoneno}"/>
                                </div>
                            </div>

                            <label for="dob">Date of Birth</label>
                            <input type="text" 
                                class="form-control mb-2" 
                                name="dob" 
                                id="dob" 
                                placeholder="Enter Date of Birth to update" 
                                value="${currentuser.dob}"/>
                                
                            <label for="password">Password</label>
                            <input type="password" 
                                class="form-control mb-2" 
                                name="password" 
                                id="password" 
                                placeholder="Enter Password to update" 
                                value="${currentuser.password}" />
                                
                            <label for="role">Role</label>
                            <input type="text" 
                                class="form-control mb-2" 
                                name="role" 
                                id="role" 
                                placeholder="****CAN'T Be Changed****" 
                                value="${currentuser.role}" disabled/>
                        </div>
                        
                        <div class="container text-center">
                            <a href="${pageContext.request.contextPath}/" class="btn btn-outline-danger">Back</a>
                            <button type="submit" class="btn btn-warning">Update</button>
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>


    <footer class="bg-body-tertiary text-center text-lg-start">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color:#d6e7eb;">
          © 2024 Copyright:
          <a class="text-body" href="#link">rk-lms.com</a>
        </div>
        <!-- Copyright -->
      </footer>

    </div>

    

    <!-- Option 1: jQuery and Bootstrap Bundle (includes Popper) -->
    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-Fy6S3B9q64WdZWQUiU+q4/2Lc9npb8tCaSX9FK7E8HnRr0Jz8D6OP9dO5Vg3Q9ct"
        crossorigin="anonymous"></script>
</body>

</html>