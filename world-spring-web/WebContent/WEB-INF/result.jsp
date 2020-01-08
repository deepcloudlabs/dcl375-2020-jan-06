<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="util" tagdir="/WEB-INF/tags"%>
<div class="panel panel-success">
	<div class="panel-heading">
		<h3 class="panel-title">World Countries</h3>
	</div>
	<div class="panel-body">
		<util:table items="${countries}"
			properties="code,name,population,surfaceArea"
			columns="Code,Name,Population,Surface Area"></util:table>
	</div>
</div>



