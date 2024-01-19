<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="com.model.User"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<%
User user = (User) session.getAttribute("currentuser");
if(user==null){
	
	session.setAttribute("message", "You are not logged in!! Login First");
	response.sendRedirect("login");
	return;
}else{
	if(user.getRole().equals("user")){
		
		session.setAttribute("message", "You are not Admin! Not accessible");
		response.sendRedirect("login");
		return;	
	}
}
%>
<!DOCTYPE html>
<html>
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
		<a href="${pageContext.request.contextPath}/index.html" class="active">LMS</a>
		<div class="topnav-right">
			<a href="${pageContext.request.contextPath}/adminpage">Profile</a> 
			<a href="${pageContext.request.contextPath}/adminmybooks">My Books</a> 
			<a href="${pageContext.request.contextPath}/addbook" class="active">AddBooks</a> 
			<a href="${pageContext.request.contextPath}/users">Users</a> 
			<a href="${pageContext.request.contextPath}/adminlibrary">Library</a>
			<a href="${pageContext.request.contextPath}/logout" class="warning">Logout</a>
		</div>
	</div>
	
	<div class="main">
        <div class="container mt-5 border border-primary ">
            <div class="col-md-6 offset-md-3  ">
                <h1 class="text-center mb-3 pt-3">Add a Book</h1>
                <form action="${pageContext.request.contextPath}/addnewbook" method="post">
                    <div class="form-group mt-5">
                        <label for="bookId">BookId</label>
                        <input type="text" 
                            class="form-control" 
                            name="bookId" 
                            id="bookId" 
                            placeholder="Ex. ABC123 " />
                    </div>
                    <div class="form-group">
                        <label for="title">Title</label>
                        <input type="text" 
                            class="form-control" 
                            name="title" 
                            id="title" 
                            placeholder="Ex. Story of an Ant" />
                    </div>
                    <div class="form-group">
                        <label for="author">Author</label>
                        <input type="text" 
                            class="form-control" 
                            name="author" 
                            id="author" 
                            placeholder="Name of the Author " />
                    </div>
                    <div class="form-group">
                        <label for="genre">Genre</label>
                        <input type="text" 
                            class="form-control" 
                            name="genre" 
                            id="genre" 
                            placeholder="Fiction" />
                    </div>
                    <div class="form-group">
                        <label for="description">Description</label>
                        <input type="description" 
                            class="form-control" 
                            name="description" 
                            id="description" 
                            placeholder="Write description of the book" />
                    </div>
                    <div class="container text-center mt-5 pb-3">
                        <button type="submit" class="btn btn-primary">Save</button>
                    </div>

                </form>
            </div>
        </div>
    </div>
	
	<footer class="bg-body-tertiary text-center text-lg-start">
        <!-- Copyright -->
        <div class="text-center p-3" style="background-color:#d6e7eb;">
          � 2024 Copyright:
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