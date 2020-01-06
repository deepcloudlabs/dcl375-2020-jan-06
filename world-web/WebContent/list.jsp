<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
</head>
<body>
	<p>
	<div class="container" role="main">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">World Panel</h3>
			</div>
			<div class="panel-body">
				<form action="search" method="post">
					<div class="form-group">
						<label for="continent">Continent</label> <select
							class="form-control" id="continent" name="continent">
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
						<button class="btn btn-success">List</button>
					</div>
				</form>
			</div>
		</div>
		<c:if test="${not empty countries}">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">World Countries</h3>
				</div>
				<div class="panel-body">
					<table class="table table-striped table-responsive table-hover">
						<thead>
							<tr>
								<th>Code</th>
								<th>Name</th>
								<th>Population</th>
								<th>Surface Area</th>
							</tr>
						</thead>
						<tbody>
							<c:forEach items="${countries}" var="cty">
								<tr>
									<td>${cty.code}</td>
									<td>${cty.name}</td>
									<td>${cty.population}</td>
									<td>${cty.surfaceArea}</td>
								</tr>
							</c:forEach>
						</tbody>
					</table>
				</div>
			</div>
		</c:if>
	</div>
</body>
</html>




