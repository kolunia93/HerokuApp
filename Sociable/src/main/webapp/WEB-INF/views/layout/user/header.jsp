<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@page import ="java.security.Principal"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="ua.entity.User"%>
<%@page import="ua.entity.Gender"%>
<form:form  action="/logout" method="POST" id="myform"> </form:form>

	 <div class="navbar navbar-fixed-top padd">
		<nav class="navbar navbar-inverse top_menus">
		  <div class="container-fluid">
		    <div class="navbar-header">
		     <security:authorize access="isAuthenticated()">
		      <a class="navbar-brand" href="#">Hello <security:authentication property="principal.username"/></a>
		    </security:authorize>
		    </div>
		    <ul class="nav navbar-nav">
		      <li class="active"><a href="/user">Main Page</a></li>
		
		    </ul>
		    <ul class="nav navbar-nav">
			    <li>
				     <security:authorize access="hasRole('ROLE_ADMIN')">
				      	<li class="active"><a href="/admin/admin">Admin</a></li>
				     </security:authorize>
				 </li>
			 </ul>
		     <ul class="nav navbar-nav navbar-right">

		
		      <li>
		     
		      <security:authorize access="isAuthenticated()">
			 <a href="#" onclick="document.getElementById('myform').submit()">Вихід</a>
			  </security:authorize>                
			  </li>
			  <security:authorize access="!isAuthenticated()">
			  
			  <li class="active"><a href="/registration">Registration</a></li>
			  <li class="active"><a href="/login">Login</a></li>
		      </security:authorize>
		    </ul>
		  </div>
		</nav>
		</div>

