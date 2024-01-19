
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="<c:url value="/resources/js/jquery.js" />" ></script>
</head>
<body>
    <script>
        $(document).ready(function(){
            
            setTimeout(function(){
               	alert("Hurray!!! Success");
                window.location.href = "/LMS/"; // Redirect after 3 seconds
            }, 500); // Adjust the time as needed (in milliseconds)
        });
    </script>
</body>
</html>
