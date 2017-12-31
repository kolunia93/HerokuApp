<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<link rel="stylesheet" href="/resources/css/form.css">
		<div class="row">
			<div class="col-md-12 col-xs-12">
		<form:form class="form-horizontal" action="/login" method="POST" onsubmit="return validate(this)">
			 <div class="form-group text-center">
					<h3>Login</h3><br><br>
			<label id="login">Login</label>		
      		<input name="login"id="login"><br><br>                    
      		<label id="password">paswword</label>
            <input type="password" name="password" id="password"><br><br>      
  			<input name="remember-me" type="checkbox" class="form-control"><label>Remember me</label><br><br>            
            <input type="submit"  value="Проверить">
            </div>
            </form:form>
        	</div>
        </div>
        <script >
    function showError(container, errorMessage) {
      container.className = 'error';
      var msgElem = document.createElement('span');
      msgElem.className = "error-message";
      msgElem.innerHTML = errorMessage;
      container.appendChild(msgElem);
    }
              function resetError(container) {
      container.className = '';
      if (container.lastChild.className == "error-message") {
        container.removeChild(container.lastChild);
      }
    }
           
      function validate(form) {
      var elems = form.elements;

      resetError(elems.login.parentNode);
      resetError(elems.password.parentNode);
      if (!elems.login.value) {
        showError(elems.login.parentNode, ' Введіть логін.');
      }   
      if (!elems.password.value) {
        showError(elems.password.parentNode, ' Введіть пароль.');
      }
      
      if((!elems.password.value)&&(!elems.login.value)){
    	  return false;
      }
    
      }
        </script>