<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ attribute name="items" type="java.util.Collection"
	rtexprvalue="true" required="true"%>
<%@ attribute name="columns" rtexprvalue="false" required="true"%>
<%@ attribute name="properties" rtexprvalue="false" required="true"%>

<table class="table table-striped table-responsive table-hover">
	<thead>
		<tr>
		   <c:forEach items="${fn:split(columns,',')}" 
		              var="column">
			<th>${column}*</th>
		   </c:forEach>
		</tr>
	</thead>
	<tbody>
		<c:forEach items="${items}" var="item">
			<tr>
			   <c:forEach items="${fn:split(properties,',')}" 
		              var="prop">
 				  <td>${item[prop]}</td>
 			   </c:forEach>
			</tr>
		</c:forEach>
	</tbody>
</table>
