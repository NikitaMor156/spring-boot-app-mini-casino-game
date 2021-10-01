<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<body>

<h2>You balance: ${currentPlayerBalance}</h2>
<br>

<form:form action="getSpinResult" modelAttribute="rouletteManager">

    <h3><font color="red">RED</font></h3>
    (if you win you will gain x2) -> 45% chance
    Bid:
    <form:select path="redBid">
        <form:options items="${rouletteManager.redBidList}"/>
    </form:select>
    <br><br>


    <h3>BLACK</h3>
    (if you win you will gain x2) -> 45% chance
    Bid:
    <form:select path="blackBid">
        <form:options items="${rouletteManager.blackBidList}"/>
    </form:select>
    <br><br>

    <h3><font color="green">GREEN</font></h3>
    (if you win you will gain x5) -> 10% chance
    Bid:
    <form:select path="greenBid">
        <form:options items="${rouletteManager.greenBidList}"/>
    </form:select>
    <br><br>


    <input type="submit" value="Spin">
</form:form>
<br>

<br>
<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="starter menu" onclick="window.location.href='/'">
</body>

</html>