<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<body>

<table>
    <tr>
        <th>User name</th>
        <th>Region</th>
        <th>balance</th>
    </tr>

    <c:forEach var="us" items="${allUsers}">

    <c:url var="deleteButton" value="/deleteUser">
        <c:param name="userId" value="${us.id}"/>
    </c:url>

        <tr>
            <td>${us.name}</td>
            <td>${us.region}</td>
            <td>${us.balance}</td>
            <td>
                <input type="button" value="Delete" onclick="window.location.href='${deleteButton}'">

            </td>
        </tr>

    </c:forEach>

</table>
<br><br>

<input type="button" value="add new user" onclick="window.location.href='/addNewUser'">
<br><br>

<input type="button" value="PLAY" onclick="window.location.href='/chooseUser'">



</body>

</html>