<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
<style>

</style>
<security:authorize access="isAuthenticated()">
<div >
	<div class="col-md-12 col-xs-12 ">					
		<c:choose>
		    <c:when test="${user.avatar==0}">
		       <img src="/resources/img/avatar.gif" class="top" width="95%"  >
		    </c:when>    
		    <c:otherwise>
		        <security:authorize access="isAuthenticated()">
				<img class="img-rounded" width="100%" src="/images/${user.username}/avatar/${user.avatar}.jpg?version=${item.version}	" >
				</security:authorize>
		    </c:otherwise>
		</c:choose>								
	</div>
			 <security:authorize access="isAuthenticated()">
				<form:form class="form-horizontal" action="/user/${user.username}/save_image" method="POST" modelAttribute="images" enctype="multipart/form-data">
				<form:errors path="*"/>
			 <input type="hidden" name="name" value=<security:authentication property="principal.username"/>>
			 <input type="hidden" name="folder" value="AVATAR">
<!-- file avatar -->
			<div class="text-center">
				<label class="btn btn-default btn-file">
	   			<input type="file" name="file" class="btn-success" ><button type="submit" class="btn-success text-center ">Create</button>
				</label>
			</div>
				
				
			</form:form>
			</security:authorize>
			<div class="list-group">
		    <a href="/user" class="list-group-item active">
		        <span class="glyphicon glyphicon-star"></span>  ${user.name} ${user.secondname} <span class="badge"></span>
		    </a>
		     <a href="#" class="list-group-item">
		        <span class="glyphicon glyphicon-th-list"></span> ${user.birthday}<span class="badge"></span>
		    </a>
		    <a href="#" class="list-group-item">
		        <span class="glyphicon glyphicon-camera"></span> ${user.fone}<span class="badge"></span>
		    </a>
		    <a href="/user/${user.username}/friends" class="list-group-item">
		        <span class="glyphicon glyphicon-camera"></span> friends<span class="badge">${user.input.size()}</span>
		    </a>
		   
		</div>
	</div>	
	</security:authorize>