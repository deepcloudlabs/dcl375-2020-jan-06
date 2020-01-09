<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Lottery App</title>
</head>
<body>
    <form method="post">
        <label for="n">n:</label>
        <input type="number"
               id="n"
               value="${param.n}"
               name="n"
               min="1" max="10">
        <c:url var="drawActionUrl" value="/numbers/action/draw"/>
        <c:url var="resetActionUrl" value="/numbers/action/reset"/>
        <button formaction="${drawActionUrl}">Draw</button>
        <button formaction="${resetActionUrl}">Reset</button>
    </form>
    <table>
        <tbody>
            <c:forEach items="${lottery.numbers}"
                       var="numbers">
                <tr>
                    <c:forEach items="${numbers}"
                               var="number">
                        <td>${number}</td>
                    </c:forEach>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>