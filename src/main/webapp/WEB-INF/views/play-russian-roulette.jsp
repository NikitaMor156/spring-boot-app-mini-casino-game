<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<body>

<h2>You balance: ${currentPlayerBalance}</h2>
<br>

How many bullets you will add to clip?
<br><br>
<form:form action="getRussianRouletteSpinResult" modelAttribute="russianRouletteManager">
    <form:radiobuttons path="revolverClipBulletCount" items="${russianRouletteManager.revolverClipBulletCountList}"/>
    <br><br>

    1 bullet - 500
    <br>
    2 bullets - 1000
    <br>
    3 bullets - 2000
    <br>
    4 bullets - 5000
    <br>
    5 bullets - 25000
    <br><br>

    <input type="submit" value="shoot">
</form:form>

<br><br>
<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="main menu" onclick="window.location.href='/'">


</body>
</html>