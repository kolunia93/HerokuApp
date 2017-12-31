<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
		
		
		<div class="row">
		<div class="col-md-4 col-xs-4 text-center ">
			<div class="list-group">
			   
			    <a href="/user/${user.username}/friends/reqest" class="list-group-item">
			        <span class="glyphicon glyphicon-camera"></span>Show reqest<span class="badge">${user.input.size()}</span>
			    </a>
			</div>
		</div>
		<div class="col-md-4 col-xs-4 text-center ">
			<div class="list-group">
			   
			    <a href="/user/${user.username}/friends/" class="list-group-item">
			        <span class="glyphicon glyphicon-camera"></span>My friends<span class="badge">${user.friends.size()}</span>
			    </a>
			</div>
		</div>
		<div class="col-md-4 col-xs-4 text-center ">
			<div class="list-group">
			   
			    <a href="/user/${user.username}/friends/find" class="list-group-item">
			        <span class="glyphicon glyphicon-camera"></span>Show all user<span class="badge"></span>
			    </a>
			</div>
		</div>
			
		</div>	
			
	<div class="row">	
	<div class="col-md-9 col-xs-9 text-center">		
	<c:choose>
    <c:when test="${empty friends.content}">
        <h3>Oops.. there is no friend</h3>
        <img class="img-rounded" width="100%" src="/resources/img/noreqest.jpg" >
    </c:when>    
    <c:otherwise>
      <c:forEach items="${friends.content}" var="friend">
		<div class="row">

			<div class="col-md-1 col-xs-1">
			</div>
			<div class="col-md-6 col-xs-6">
			${friend.name}<br>
			${friend.secondname}
			</div>
			<div class="col-md-5 col-xs-5">
			<c:choose>
		    <c:when test="${friend.avatar==0}">
		       <img src="/resources/img/avatar.gif" class="top" width="95%"  >
		    </c:when>    
		    <c:otherwise>
				<img class="img-rounded" width="100%" src="/images/${friend.username}/avatar/${friend.avatar}.jpg" >				
		    </c:otherwise>
			</c:choose>	
			
			</div>
		</div>	
		</c:forEach>
    </c:otherwise>
	</c:choose>
			<div class="row">
				<div class="col-md-12 col-xs-12 text-center">
					<custom:pageable page="${friends}" cell="<li></li>" container="<ul class='pagination'></ul>" />
					
				</div>
			</div>
		
		</div>
	

	</div>			
				
			
