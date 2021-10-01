<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>you win!</h2>
<br>

Your balance is ${balance}
<br><br>
<pre></pre>
<br>

<input type="button" value="play again" onclick="window.location.href='/play/getGamesList/playRussianRoulette'">
<br><br>

<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="main menu" onclick="window.location.href='/'">

</body>
</html>