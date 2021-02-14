<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<body>

<h3>Choose your user profile to play:</h3>
<br>

<c:forEach var="us" items="${allUsers}">

    <c:url var="chooseGameButton" value="/writeChosenUserToSession">
        <c:param name="playerId" value="${us.id}"/>
    </c:url>

    name: ${us.name}
    <br>
    region: ${us.region}
    <br>
    balance: ${us.balance}
    <br>
    <input type="button" value="play" onclick="window.location.href='${chooseGameButton}'">
    <br><br><br>

</c:forEach>
<input type="button" value="cancel" onclick="window.location.href='/'">


</body>

</html>