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
}%>
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
        <a href="${pageContext.request.contextPath}/" class="active">LMS</a>
        <div class="topnav-right">
            <a href="${pageContext.request.contextPath}/userpage">Profile</a>
            <a href="${pageContext.request.contextPath}/mybooks">My Books</a>
            <a href="${pageContext.request.contextPath}/library" class="active">Library</a>
            <a href="${pageContext.request.contextPath}/logout" class="warning">Logout</a>
        </div>
    </div>

    <div class="main">
        
        <div class="container">
            <div class="container mt-3">
                <div class="row">
                    <div class="col-md-12">
                        <div class="border border-primary mb-3">
                            <h1 class="content text-center mb-3">List of Books in the Library</h1>
                        </div>
                        <table class="table">
                            <thead class="thead-dark">
                                <tr>
                                	<th scope="col">ID</th>
                                    <th scope="col">Book ID</th>
                                    <th scope="col">Book Title</th>
                                    <th scope="col">Author</th>
                                    <th scope="col">Genre</th>
                                    <th scope="col">Description</th>
                                    <th scope="col">Actions</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach items="${listofbooks}" var="b">
                                <tr>
                                    <th scope="row">${b.id}</th>
                                    <td>${b.bookId}</td>
                                    <td>${b.title}</td>
                                    <td class="font-weight-bold">${b.author}</td>
                                    <td>${b.genre}</td>
                                    <td>${b.description}</td>
                                    <td>
                                    <a href="${pageContext.request.contextPath}/getuserbook/${b.id}/${currentuser.id}">Get</a>
                                    
                                    </td>
                                </tr>
                                </c:forEach>
                                
                            </tbody>
                        </table>
                        
                    </div>
                </div>
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