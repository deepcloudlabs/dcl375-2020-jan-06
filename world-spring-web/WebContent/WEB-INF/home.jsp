<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>World Countries v2</title>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-3.3.1.min.js"></script>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css">
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<c:url var="url" value="/countries/list"></c:url>	
<script type="text/javascript">
   window.onload = () => {
	   let listBtn = document.querySelector("#list");
	   let result= document.querySelector("#result");
	   let continentSelect = 
		   document.querySelector("#continent");
	   listBtn.addEventListener('click', () => {
		   let data = new URLSearchParams("continent="+
				   continentSelect.options[continentSelect.selectedIndex].text);		   
		   fetch("${url}",{
			   method : "POST",
			   body : data
		   })
		   .then( res => res.text())
		   .then( html => {
			   result.innerHTML = html;
		   } )
	   })
   }
</script>	
</head>
<body>
	<p>
	<div class="container" role="main">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">World Panel</h3>
			</div>
			<div class="panel-body">
				<c:url var="actionUrl" 
				    value="/countries/search"></c:url>
					<div class="form-group">
						<label for="continent">Continent</label> <select
							class="form-control" id="continent" 
							name="continent">
							<c:forEach items="${continents}" var="cont">
								<c:choose>
									<c:when test="${param.continent eq cont}">
										<option selected>${cont}</option>
									</c:when>
									<c:otherwise>
										<option>${cont}</option>
									</c:otherwise>
								</c:choose>
							</c:forEach>
						</select>
					</div>
					<div class="form-group">
						<button id="list" class="btn btn-success">List</button>
					</div>
			</div>
		</div>
	<div id="result"></div>
	</div>
</body>
</html>




