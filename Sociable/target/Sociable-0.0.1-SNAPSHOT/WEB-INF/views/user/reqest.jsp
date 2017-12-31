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
			<c:forEach items="${reqests.content}" var="reqest">
				<div class="row brd">
					<c:choose>
					    <c:when test="${reqest.input.avatar==0}">
						    <div class="col-md-4 col-xs-4">
						        <img class="img-rounded" width="100%" src="/resources/img/avatar.gif" >
						    </div>    
					    </c:when>  
					      
					    <c:otherwise>
					    	<div class="col-md-4 col-xs-4">
								<img class="img-rounded" width="100%" src="/images/${reqest.input.username}/avatar/${reqest.input.avatar}.jpg" >
							</div>	
					    </c:otherwise>
					</c:choose>
					<div class="col-md-1 col-xs-1">
					</div>
					<div class="col-md-7 col-xs-7">
					${reqest.input.username}<br>
					${reqest.input.secondname}<br>	
					${reqest.msg}
					${reqest.cheack}
					<form:form class="form-horizontal" action="/user/${user.username}/friends/reqest" method="POST" modelAttribute="friendReqestForm" >
					<form:errors path="*"/>
						 <input type="hidden" name="cheack" value="FALSE"/>
						 <input type="hidden"  name="id" value="${reqest.id}"/>
						 <input type="hidden" name="input" value="${reqest.input.username}"/>	
						<button type="submit" class="btn btn-default ">add</button>
					</form:form>	
					<form:form class="form-horizontal" action="/user/${user.username}/friends/reqest" method="POST" modelAttribute="friendReqestForm" >
					<form:errors path="*"/>
						<input type="hidden"  name="id" value="${reqest.id}"/>
						 <input type="hidden" name="cheack" value="TRUE"/>>		
						<button type="submit" class="btn btn-default ">delete</button>
					</form:form>			
					
					</div>
				</div>	
			</c:forEach>
			
			<div class="row">
				<div class="col-md-12 col-xs-12 text-center">
					<custom:pageable page="${reqests}" cell="<li></li>" container="<ul class='pagination'></ul>" />
					
				</div>
			</div>
		</div>		
	</div>			
				
			
