<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

			<ul class="nav navbar-nav">
		      <li class="active"><a href="/registration">Registration</a></li>
		      <li class="active"><a href="/login">Login</a></li>
		    </ul>
			<c:forEach items="${users}" var="user">  
			  ${user.username}
	</c:forEach>
	
</body>
</html>
