<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Imdb Search Page</title>
<jsp:include page="bootstrap.jsp"></jsp:include>
</head>
<body>
	<p>
	<div class="container" role="main">
		<div class="panel panel-success">
			<div class="panel-heading">
				<h3 class="panel-title">Movie Search Panel</h3>
			</div>
			<div class="panel-body">
				<form action="search" method="post">
					<div class="form-group">
						<label for="from">From</label> <input class="form-control"
							id="from" type="text" name="from" value="${param.from}" />
					</div>
					<div class="form-group">
						<label for="to">To</label> <input class="form-control" id="to"
							type="text" name="to" value="${param.to}" />
					</div>
					<div class="form-group">
						<label for="genre">Genre</label> <select class="form-control"
							id="genre" name="genre">
							<c:forEach items="${genres}" var="genre">
								<c:choose>
									<c:when test="${genre.name eq param.genre}">
										<option selected label="${genre.name}" value="${genre.name}">${genre.name}</option>
									</c:when>
									<c:otherwise>
										<option label="${genre.name}" value="${genre.name}">${genre.name}</option>
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

		<c:if test="${not empty movies}">
			<div class="panel panel-success">
				<div class="panel-heading">
					<h3 class="panel-title">Search Result</h3>
				</div>
				<div class="panel-body">
				    <util:table items="${movies}" 
				                properties="title,year,imdb" 
				                columns="Title,Year,IMDB"></util:table>

				</div>
			</div>
		</c:if>
	</div>
</body>
</html>