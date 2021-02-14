<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<body>
<h2>Win number is: ${guessTheNumberManager.winningNumber}</h2>
<br><br>

<c:choose>
    <c:when test="${isWin == true}">
        <h2>YOU WIN!</h2>
    </c:when>

    <c:otherwise>
        <h2>YOU LOOSE!</h2>
    </c:otherwise>
</c:choose>
<br>
your balance: ${balance}
<br><br>
<input type="button" value="play again" onclick="window.location.href='/play/getGamesList/playGuessTheNumber'">
<br><br>
<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="main menu" onclick="window.location.href='/'">

</body>

</html>