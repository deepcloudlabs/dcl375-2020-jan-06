<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Game</title>
    <jsp:include page="bootstrap.jsp"/>
</head>
<body>
<p>
<div class="container" role="main">
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">Game Panel</h3>
        </div>
        <div class="panel-body">
            <form method="post">
                <div class="form-group">
                    <label for="guess">Guess</label>
                    <input class="form-control"
                           id="guess"
                           type="number"
                           min="1"
                           max="100"
                           name="guess"
                           value="${param.guess}" />
                </div>
                <div class="form-group">
                    <c:url var="playActionUrl"
                           value="/guessing/action/play" />
                    <button class="btn btn-success"
                            formaction="${playActionUrl}">Play</button>
                </div>
            </form>
        </div>
    </div>
    <div class="panel panel-success">
        <div class="panel-heading">
            <h3 class="panel-title">Moves</h3>
        </div>
        <div class="panel-body">
            <table class="table table-striped table-hover table-responsive">
                <thead>
                    <tr>
                        <th>Guess</th>
                        <th>Message</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${game.moves}" var="move">
                        <tr>
                            <td>${move.guess}</td>
                            <td>${move.message}</td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
</div>
</body>
</html>