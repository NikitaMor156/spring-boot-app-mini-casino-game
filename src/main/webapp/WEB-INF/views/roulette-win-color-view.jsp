<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<body>

<c:if test="${rouletteManager.winnerColor == 1}">
    <h2><font color="red">RED</font> </h2>
</c:if>

<c:if test="${rouletteManager.winnerColor == 2}">
    <h2>BLACK</h2>
</c:if>

<c:if test="${rouletteManager.winnerColor == 3}">
    <h2><font color="green">GREEN</font> </h2>
</c:if>
<br><br>
User ${playingUser.name} balance: ${playingUser.balance}
<br><br>
<input type="button" value="play again" onclick="window.location.href='/play/getGamesList/playRoulette'">
<br><br>
<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<br><br>
<input type="button" value="starter menu" onclick="window.location.href='/'">

</body>
</html>