<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<body>

<h2>You balance: ${currentPlayerBalance}</h2>
<br>

<pre>
    (combination - your bonus)

    *** - bid x 0.25      ### - bid x 1        $$$ - bid x 3
    **** - bid x 1.5      #### - bid x 2.5     $$$$ - bid x 15
    ****** - bid x 2.5    ##### - bid x 5      $$$$$ - bid x 100
</pre>

<pre>
                 [=====================================================] __
                 |                   SLOT MACHINE V1                   |(__)
                 |                MADE BY MYKYTA MOROKA                | ||
                 |===_______===_______===_______===_______===_______===| ||
                 ||*|       |*|       |*|       |*|       |*|       |*|| ||
                 ||*|       |*|       |*|       |*|       |*|       |*||_//
                 ||*|   ${slotOne}   |*|   ${slotTwo}   |*|   ${slotThree}   |*|   ${slotFour}   |*|   ${slotFive}   |*||_/
                 ||*|       |*|       |*|       |*|       |*|       |*||
                 ||*|_______|*|_______|*|_______|*|_______|*|_______|*||
                 |===_______________________________________________===|
                 |  /_______________________________________________\  |
                 |   |                                             |   |
                _|    \___________________________________________/    |_
               (_________________________________________________________)
</pre>
<br><br>
<form:form action="getOneHandBanditResult" modelAttribute="oneHandBanditManager">

    <form:input path="bid"/>

    <input type="submit" value="spin again">

</form:form>
<br>

<input type="button" value="another game" onclick="window.location.href='/play/getGamesList'">
<input type="button" value="main menu" onclick="window.location.href='/'">
<br>
<h2>Your win is: ${resultMoney}</h2>

</body>
</html>