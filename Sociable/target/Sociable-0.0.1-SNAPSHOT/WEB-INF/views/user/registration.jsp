<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page import="ua.entity.Gender"%>
<div class="row">

	
</div>
<div class="row ">
	<div class="row">
			<div class="col-md-12 col-xs-12">
				<form:form class="form-horizontal" action="/registration" method="POST" modelAttribute="user" enctype="multipart/form-data">
					
					<div class="form-group text-center">
					<h3>Registration</h3><br><br>
<!-- name -->					
    					<form:label path="name">Name</form:label>
    					<form:input path="name" size="30" /><br/>
    					<form:errors path="name" cssClass="error"/><br/>
<!-- secondname -->					
    					<form:label path="secondname">second</form:label>
    					<form:input path="secondname" size="30" /><br/>
    					<form:errors path="secondname" cssClass="error"/><br/>
<!-- Second name -->					
    					<form:label path="username">UserName</form:label>
    					<form:input path="username" size="30" /><br/>
    					<form:errors path="username" cssClass="error"/><br/>   					   					
<!-- mail -->					
    					<form:label path="email">Email</form:label>
    					<form:input path="email" size="30" /><br/>
    					<form:errors path="email" cssClass="error"/><br/>  
<!-- password -->					
    					<form:label path="password">Password</form:label>
    					<form:input path="password"  size="30" /><br/>
    					<form:errors path="password" cssClass="error"/><br/>   
    					
<!-- number -->					
    					<form:label path="fone">Fone</form:label>
    					<form:input path="fone" size="30"  /><br/>
    					<form:errors path="fone" cssClass="error"/><br/>
<!-- gender -->  
    					<form:label path="gender">Gender </form:label>    					
				    	<c:set var="enumValues" value="<%=Gender.values()%>"/><c:forEach items="${enumValues}" var="gender"> </c:forEach>   					  
    					<form:select path="gender" id="genderId" items="${enumValues}" /><br>  					
<!-- birthDay -->  	
						<label id="birthDay">birthday</label>
						<input type="date" name="birthday">
		        				Browse <input type="file" name="file" style="display: none;">
		    				
  					
  					<form:errors path="*" cssClass="error"/><br/>
  					
  					<div class="form-group">
    					<div class="col-sm-offset-2 col-sm-10">
      						<button type="submit" class="btn btn-default">Registration</button>
    					</div>
    				</div>
 					</div>
				</form:form>
		</div>
	</div> 

	<div class="col-md-2 col-xs-12"></div>
	
</div>