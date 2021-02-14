<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<body>
<h2>Choose one number [1;4] and in case of win you will get x4</h2>
<br>

<h2>You balance: ${currentPlayerBalance}</h2>
<br><br>

<form:form action="getGuessTheNumberResult" modelAttribute="guessTheNumberManager">
    <table>
        <tr>
            <th>#1  </th>
            <th>#2  </th>
            <th>#3  </th>
            <th>#4  </th>
        </tr>
        <tr>
            <td><form:radiobutton path="chosenNumber" value="1"/></td>
            <td><form:radiobutton path="chosenNumber" value="2"/></td>
            <td><form:radiobutton path="chosenNumber" value="3"/></td>
            <td><form:radiobutton path="chosenNumber" value="4"/></td>
        </tr>
    </table>
    <br>
    Bid: <form:select path="bid">
    <form:options items="${guessTheNumberManager.bidList}"/>
</form:select>

    <input type="submit" value="spin">

</form:form>

<br><br>
<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="main menu" onclick="window.location.href='/'">

</body>

</html>