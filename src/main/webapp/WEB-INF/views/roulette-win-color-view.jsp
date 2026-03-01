<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Roulette — Result</title>
<style>
    * { box-sizing: border-box; }
    body {
        background: #0f1923;
        color: #e8e8e8;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 32px;
    }

    h1 { color: #f0c040; letter-spacing: 4px; margin: 0 0 28px 0; font-size: 24px; }

    /* Winning number box */
    .result-box {
        display: inline-block;
        width: 150px;
        height: 150px;
        border-radius: 10px;
        text-align: center;
        line-height: 1;
        padding-top: 20px;
        margin-bottom: 20px;
        border: 3px solid rgba(255,255,255,0.15);
    }
    .result-box .num  { font-size: 72px; font-weight: bold; display: block; }
    .result-box .col  { font-size: 16px; letter-spacing: 3px; font-weight: bold; margin-top: 6px; display: block; }
    .box-red   { background: #8b0000; }
    .box-black { background: #1c1c1c; border-color: #555; }
    .box-green { background: #1a6b1a; }

    /* Number bet outcome */
    .bet-panel {
        display: inline-block;
        padding: 14px 24px;
        border-radius: 8px;
        font-size: 16px;
        margin-bottom: 20px;
        vertical-align: top;
        margin-left: 24px;
        max-width: 340px;
    }
    .bet-hit  { background: #0d2e0d; border: 2px solid #4caf50; color: #8bc34a; }
    .bet-miss { background: #2e0d0d; border: 2px solid #8b0000; color: #e05050; }
    .bet-none { background: #1e1e1e; border: 2px solid #333;    color: #666;    font-style: italic; }

    .bet-panel .bet-title { font-weight: bold; font-size: 18px; margin-bottom: 6px; }
    .bet-panel .bet-detail { font-size: 13px; margin-top: 4px; color: inherit; opacity: 0.85; }

    /* Balance */
    .balance-line {
        font-size: 17px;
        color: #aaa;
        margin: 8px 0 24px 0;
    }
    .balance-line span { color: #f0c040; font-weight: bold; font-size: 19px; }

    /* Buttons */
    .btn-primary {
        background: #f0c040;
        color: #0f1923;
        border: none;
        padding: 12px 32px;
        font-size: 16px;
        font-weight: bold;
        cursor: pointer;
        border-radius: 6px;
        margin-right: 10px;
    }
    .btn-primary:hover { background: #ffd966; }
    .btn-nav {
        background: #1e2e1e;
        color: #aaa;
        border: 1px solid #3a4a3a;
        padding: 10px 20px;
        cursor: pointer;
        border-radius: 4px;
        margin-right: 10px;
        font-size: 14px;
    }
    .btn-nav:hover { background: #263626; color: #e8e8e8; }
</style>
</head>
<body>

<h1>SPIN RESULT</h1>

<%-- ===== Winning number box ===== --%>
<c:if test="${rouletteManager.winnerColor == 1}">
    <div class="result-box box-red">
        <span class="num">${rouletteManager.winnerNumber}</span>
        <span class="col">RED</span>
    </div>
</c:if>
<c:if test="${rouletteManager.winnerColor == 2}">
    <div class="result-box box-black">
        <span class="num">${rouletteManager.winnerNumber}</span>
        <span class="col">BLACK</span>
    </div>
</c:if>
<c:if test="${rouletteManager.winnerColor == 3}">
    <div class="result-box box-green">
        <span class="num">${rouletteManager.winnerNumber}</span>
        <span class="col">GREEN</span>
    </div>
</c:if>

<%-- ===== Number bet outcome ===== --%>
<c:choose>
    <c:when test="${rouletteManager.chosenNumber == -1 or rouletteManager.numberBid == 0}">
        <div class="bet-panel bet-none">
            <div class="bet-title">No number bet</div>
            <div class="bet-detail">Pick a number next time for a 35:1 payout chance.</div>
        </div>
    </c:when>
    <c:when test="${rouletteManager.winnerNumber == rouletteManager.chosenNumber}">
        <div class="bet-panel bet-hit">
            <div class="bet-title">&#10003;&nbsp; NUMBER ${rouletteManager.chosenNumber} HIT!</div>
            <div class="bet-detail">You won ${rouletteManager.numberBid * 35} on your number bet (35:1 payout).</div>
        </div>
    </c:when>
    <c:otherwise>
        <div class="bet-panel bet-miss">
            <div class="bet-title">&#10007;&nbsp; Number ${rouletteManager.chosenNumber} missed</div>
            <div class="bet-detail">The ball landed on ${rouletteManager.winnerNumber}. Better luck next spin!</div>
        </div>
    </c:otherwise>
</c:choose>

<br>

<div class="balance-line">
    ${playingUser.name}&apos;s balance: <span>${playingUser.balance}</span>
</div>

<input type="button" class="btn-primary" value="Play Again"    onclick="window.location.href='/play/getGamesList/playRoulette'">
<input type="button" class="btn-nav"     value="Another Game"  onclick="window.location.href='/play/getGamesList'">
<input type="button" class="btn-nav"     value="Main Menu"     onclick="window.location.href='/'">

</body>
</html>
