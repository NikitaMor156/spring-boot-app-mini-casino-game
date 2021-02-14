<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<body>

<h3>Create new user</h3>
<br><br>


<form:form action="saveUser" modelAttribute="user">
    <form:hidden path="id"/>


    User name: <form:input path="name"/>
    <br><br>
    Region: <form:input path="region"/>
    <br><br>
    Balance: <form:input path="balance"/>
    <br><br>

    <input type="submit" value="create">

</form:form>
<br><br>
<input type="button" value="cancel" onclick="window.location.href='/'">

</body>

</html>