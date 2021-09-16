<!DOCTYPE HTML>
<html>
<body>

<h2>You balance: ${currentPlayerBalance}</h2>
<br><br>


<h1>Choose game to play:</h1>
<br>
<input type="button" value="ROULETTE" onclick="window.location.href='/play/getGamesList/playRoulette'">
<br><br>

<input type="button" value="GUESS THE NUMBER" onclick="window.location.href='/play/getGamesList/playGuessTheNumber'">
<br><br>

<%--<input type="button" value="RUSSIAN ROULETTE" onclick="window.location.href='/play/getGamesList/playSimpleRoulette'">--%>
<%--<br><br>--%>

<input type="button" value="RUSSIAN ROULETTE" onclick="window.location.href='/play/getGamesList/playRussianRoulette'">
<br><br><br>

<input type="button" value="starter menu" onclick="window.location.href='/'">
</body>
</html>