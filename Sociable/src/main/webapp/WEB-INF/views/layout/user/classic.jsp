<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript" src="https://code.jquery.com/jquery-3.1.0.min.js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" >
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js" ></script>
<style type="text/css">
body {
	padding-bottom: 70px; 
	padding-top: 60px;
	}
.floatTip {
  position: fixed; /* Абсолютное позиционирование */
  width: 25%; /* Ширина блока */
  top:;
  padding: 5px; /* Поля вокруг текста */
  font-family: sans-serif; /* Рубленый шрифт */
  font-size: 9pt; /* Размер шрифта */
  color: #333; /* Цвет текста */
  background: #DCDCDC; /* Цвет фона */
}


</style>
<title><tiles:getAsString name="title" /></title>
</head>
<body>
<!-- 	а сюди jsp файл з ім'ям header -->
    <tiles:insertAttribute name="header" />
	
	<div class="row">
	
			<div class="col-md-3 col-xs-3 text-center">
			<tiles:insertAttribute name="menu"></tiles:insertAttribute>
			</div>
			<div class="col-md-1 col-xs-1 ">
			</div>
			<div class="col-md-7 col-xs-7 text-centert">
			<tiles:insertAttribute name="body"></tiles:insertAttribute>
			</div>
			<div class="col-md-1 col-xs-1 ">
			</div>
	</div>	
</body>
</html>