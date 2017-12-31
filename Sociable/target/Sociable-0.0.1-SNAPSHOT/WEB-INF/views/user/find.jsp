<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://www.springframework.org/security/tags"
	prefix="security"%>
	<%@ taglib uri="/WEB-INF/custom.tld" prefix="custom"%>
	<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
	<style >
	.brd {
	margin-left: 5%;
	width:100%;
    border: 4px inset #DCDCDC; /* Параметры границы */
    padding: 10px; /* Поля вокруг текста */
   }
	</style>
		
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
			<c:forEach items="${friends.content}" var="friend">
				<div class="row brd">	
					<c:choose>
					    <c:when test="${friend.avatar==0}">
						    <div class="col-md-4 col-xs-4">
						        <img class="img-rounded" width="100%" src="/resources/img/avatar.gif" >
						    </div>    
					    </c:when>  
					      
					    <c:otherwise>
					    	<div class="col-md-4 col-xs-4">
								<img class="img-rounded" width="100%" src="/images/${friend.username}/avatar/${friend.avatar}.jpg" >
							</div>	
					    </c:otherwise>
					</c:choose>

					<div class="col-md-1 col-xs-1">
					</div>
					<div class="col-md-7 col-xs-7">
						${friend.name}<br>
						${friend.secondname}<br>
						${friend.birthday}<br>
						${friend.gender}<br>

						<c:if test="${friend.username eq existUser}" var="result">
						<h4>You already add this friend</h4	>
						</c:if>
						<security:authorize access="isAuthenticated()">
						    <security:authentication property="principal.username" var="username" />
						
					
					<form:form class="form-horizontal" action="/user/${username}/friends/find" method="POST" modelAttribute="friend" >
						<form:errors path="*"/>
						 <input type="hidden" name="input" value=<security:authentication property="principal.username"/>>
						 <input type="hidden" name="output" value="${friend.username}">					
						<button type="submit" class="btn btn-default btn-lg">Add to friend</button>						
					</form:form>
					</security:authorize>								
					</div>
				</div>	
			</c:forEach>
			
			<div class="row">
				<div class="col-md-12 col-xs-12 text-center">
					<custom:pageable page="${friends}" cell="<li></li>" container="<ul class='pagination'></ul>" />
					
				</div>
			</div>
		</div>
	</div>			
				
			
