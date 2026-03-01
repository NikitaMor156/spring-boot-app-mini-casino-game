<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
<meta charset="UTF-8">
<title>Roulette</title>
<style>
    * { box-sizing: border-box; }
    body {
        background: #0f1923;
        color: #e8e8e8;
        font-family: Arial, sans-serif;
        margin: 0;
        padding: 24px 32px;
    }

    h1 { color: #f0c040; letter-spacing: 4px; margin: 0 0 4px 0; font-size: 28px; }
    .balance-bar { color: #aaa; font-size: 15px; margin-bottom: 24px; }
    .balance-bar span { color: #f0c040; font-weight: bold; font-size: 17px; }

    .section-title {
        color: #f0c040;
        font-size: 13px;
        font-weight: bold;
        letter-spacing: 2px;
        text-transform: uppercase;
        border-bottom: 1px solid #2a3a2a;
        padding-bottom: 5px;
        margin: 22px 0 12px 0;
    }

    /* "None" option */
    .no-bet-label {
        display: inline-block;
        padding: 6px 18px;
        border-radius: 4px;
        border: 2px solid #555;
        cursor: pointer;
        font-size: 13px;
        color: #888;
        margin-bottom: 10px;
    }
    #numNone { display: none; }
    #numNone:checked + .no-bet-label { border-color: #f0c040; color: #f0c040; }

    /* Roulette grid */
    .roulette-table { border-collapse: collapse; }
    .roulette-table td {
        width: 50px;
        height: 50px;
        text-align: center;
        vertical-align: middle;
        border: 2px solid #0f1923;
        padding: 0;
        position: relative;
    }
    .cell-green { background: #1a6b1a; }
    .cell-red   { background: #8b0000; }
    .cell-black { background: #1c1c1c; }
    .cell-radio { display: none; }
    .cell-label {
        display: flex;
        align-items: center;
        justify-content: center;
        width: 100%;
        height: 100%;
        font-size: 14px;
        font-weight: bold;
        color: #fff;
        cursor: pointer;
        user-select: none;
    }
    .cell-green .cell-label { font-size: 18px; }
    .cell-radio:checked + .cell-label {
        outline: 4px solid #f0c040;
        outline-offset: -4px;
        background: rgba(240, 192, 64, 0.22);
        color: #f0c040;
    }
    .roulette-table td:hover .cell-label { background: rgba(255,255,255,0.08); }

    /* Number bid row */
    .number-bid-row { margin: 12px 0 0 0; font-size: 14px; color: #ccc; }
    .number-bid-row .hint { color: #666; font-size: 12px; margin-left: 8px; }

    /* Color bets */
    .color-bets-table { border-collapse: collapse; margin-top: 6px; }
    .color-bets-table td { padding: 7px 16px 7px 0; font-size: 14px; vertical-align: middle; }
    .clr-red   { color: #e05050; font-weight: bold; font-size: 16px; min-width: 70px; display: inline-block; }
    .clr-black { color: #ccc;    font-weight: bold; font-size: 16px; min-width: 70px; display: inline-block; }
    .clr-green { color: #5cba5c; font-weight: bold; font-size: 16px; min-width: 70px; display: inline-block; }
    .odds { color: #666; font-size: 12px; min-width: 200px; display: inline-block; }

    select {
        background: #1c2a1c;
        color: #e8e8e8;
        border: 1px solid #3a5a3a;
        padding: 4px 8px;
        border-radius: 3px;
        font-size: 13px;
    }

    .btn-spin {
        background: #f0c040;
        color: #0f1923;
        border: none;
        padding: 13px 44px;
        font-size: 18px;
        font-weight: bold;
        letter-spacing: 2px;
        cursor: pointer;
        border-radius: 6px;
        margin-top: 20px;
        text-transform: uppercase;
    }
    .btn-spin:hover { background: #ffd966; }

    .nav-area { margin-top: 18px; }
    .btn-nav {
        background: #1e2e1e;
        color: #aaa;
        border: 1px solid #3a4a3a;
        padding: 9px 20px;
        cursor: pointer;
        border-radius: 4px;
        margin-right: 10px;
        font-size: 13px;
    }
    .btn-nav:hover { background: #263626; color: #e8e8e8; }
</style>
</head>
<body>

<h1>EUROPEAN ROULETTE</h1>
<div class="balance-bar">Balance: <span>${currentPlayerBalance}</span></div>

<form:form action="getSpinResult" modelAttribute="rouletteManager">

    <%-- ===== NUMBER BET ===== --%>
    <div class="section-title">Bet on a Number &mdash; pays 35:1</div>

    <input type="radio" id="numNone" name="chosenNumber" value="-1" checked="checked">
    <label for="numNone" class="no-bet-label">&#10007;&nbsp; No number bet</label>

    <table class="roulette-table">
        <tr>
            <td class="cell-green" colspan="3" style="height:46px">
                <input type="radio" id="n0" class="cell-radio" name="chosenNumber" value="0">
                <label for="n0" class="cell-label">0</label>
            </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n1"  class="cell-radio" name="chosenNumber" value="1">  <label for="n1"  class="cell-label">1</label>  </td>
            <td class="cell-black"> <input type="radio" id="n2"  class="cell-radio" name="chosenNumber" value="2">  <label for="n2"  class="cell-label">2</label>  </td>
            <td class="cell-red">   <input type="radio" id="n3"  class="cell-radio" name="chosenNumber" value="3">  <label for="n3"  class="cell-label">3</label>  </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n4"  class="cell-radio" name="chosenNumber" value="4">  <label for="n4"  class="cell-label">4</label>  </td>
            <td class="cell-red">   <input type="radio" id="n5"  class="cell-radio" name="chosenNumber" value="5">  <label for="n5"  class="cell-label">5</label>  </td>
            <td class="cell-black"> <input type="radio" id="n6"  class="cell-radio" name="chosenNumber" value="6">  <label for="n6"  class="cell-label">6</label>  </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n7"  class="cell-radio" name="chosenNumber" value="7">  <label for="n7"  class="cell-label">7</label>  </td>
            <td class="cell-black"> <input type="radio" id="n8"  class="cell-radio" name="chosenNumber" value="8">  <label for="n8"  class="cell-label">8</label>  </td>
            <td class="cell-red">   <input type="radio" id="n9"  class="cell-radio" name="chosenNumber" value="9">  <label for="n9"  class="cell-label">9</label>  </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n10" class="cell-radio" name="chosenNumber" value="10"> <label for="n10" class="cell-label">10</label> </td>
            <td class="cell-black"> <input type="radio" id="n11" class="cell-radio" name="chosenNumber" value="11"> <label for="n11" class="cell-label">11</label> </td>
            <td class="cell-red">   <input type="radio" id="n12" class="cell-radio" name="chosenNumber" value="12"> <label for="n12" class="cell-label">12</label> </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n13" class="cell-radio" name="chosenNumber" value="13"> <label for="n13" class="cell-label">13</label> </td>
            <td class="cell-red">   <input type="radio" id="n14" class="cell-radio" name="chosenNumber" value="14"> <label for="n14" class="cell-label">14</label> </td>
            <td class="cell-black"> <input type="radio" id="n15" class="cell-radio" name="chosenNumber" value="15"> <label for="n15" class="cell-label">15</label> </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n16" class="cell-radio" name="chosenNumber" value="16"> <label for="n16" class="cell-label">16</label> </td>
            <td class="cell-black"> <input type="radio" id="n17" class="cell-radio" name="chosenNumber" value="17"> <label for="n17" class="cell-label">17</label> </td>
            <td class="cell-red">   <input type="radio" id="n18" class="cell-radio" name="chosenNumber" value="18"> <label for="n18" class="cell-label">18</label> </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n19" class="cell-radio" name="chosenNumber" value="19"> <label for="n19" class="cell-label">19</label> </td>
            <td class="cell-black"> <input type="radio" id="n20" class="cell-radio" name="chosenNumber" value="20"> <label for="n20" class="cell-label">20</label> </td>
            <td class="cell-red">   <input type="radio" id="n21" class="cell-radio" name="chosenNumber" value="21"> <label for="n21" class="cell-label">21</label> </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n22" class="cell-radio" name="chosenNumber" value="22"> <label for="n22" class="cell-label">22</label> </td>
            <td class="cell-red">   <input type="radio" id="n23" class="cell-radio" name="chosenNumber" value="23"> <label for="n23" class="cell-label">23</label> </td>
            <td class="cell-black"> <input type="radio" id="n24" class="cell-radio" name="chosenNumber" value="24"> <label for="n24" class="cell-label">24</label> </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n25" class="cell-radio" name="chosenNumber" value="25"> <label for="n25" class="cell-label">25</label> </td>
            <td class="cell-black"> <input type="radio" id="n26" class="cell-radio" name="chosenNumber" value="26"> <label for="n26" class="cell-label">26</label> </td>
            <td class="cell-red">   <input type="radio" id="n27" class="cell-radio" name="chosenNumber" value="27"> <label for="n27" class="cell-label">27</label> </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n28" class="cell-radio" name="chosenNumber" value="28"> <label for="n28" class="cell-label">28</label> </td>
            <td class="cell-black"> <input type="radio" id="n29" class="cell-radio" name="chosenNumber" value="29"> <label for="n29" class="cell-label">29</label> </td>
            <td class="cell-red">   <input type="radio" id="n30" class="cell-radio" name="chosenNumber" value="30"> <label for="n30" class="cell-label">30</label> </td>
        </tr>
        <tr>
            <td class="cell-black"> <input type="radio" id="n31" class="cell-radio" name="chosenNumber" value="31"> <label for="n31" class="cell-label">31</label> </td>
            <td class="cell-red">   <input type="radio" id="n32" class="cell-radio" name="chosenNumber" value="32"> <label for="n32" class="cell-label">32</label> </td>
            <td class="cell-black"> <input type="radio" id="n33" class="cell-radio" name="chosenNumber" value="33"> <label for="n33" class="cell-label">33</label> </td>
        </tr>
        <tr>
            <td class="cell-red">   <input type="radio" id="n34" class="cell-radio" name="chosenNumber" value="34"> <label for="n34" class="cell-label">34</label> </td>
            <td class="cell-black"> <input type="radio" id="n35" class="cell-radio" name="chosenNumber" value="35"> <label for="n35" class="cell-label">35</label> </td>
            <td class="cell-red">   <input type="radio" id="n36" class="cell-radio" name="chosenNumber" value="36"> <label for="n36" class="cell-label">36</label> </td>
        </tr>
    </table>

    <div class="number-bid-row">
        Number bet amount:
        <form:select path="numberBid">
            <form:options items="${rouletteManager.numberBidList}"/>
        </form:select>
        <span class="hint">(set to 0 if you don't want a number bet)</span>
    </div>

    <%-- ===== COLOR BETS ===== --%>
    <div class="section-title" style="margin-top: 28px">Color Bets</div>

    <table class="color-bets-table">
        <tr>
            <td><span class="clr-red">RED</span></td>
            <td><span class="odds">x2 payout &nbsp;|&nbsp; 18/37 chance (~48.6%)</span></td>
            <td>Bid: <form:select path="redBid"><form:options items="${rouletteManager.redBidList}"/></form:select></td>
        </tr>
        <tr>
            <td><span class="clr-black">BLACK</span></td>
            <td><span class="odds">x2 payout &nbsp;|&nbsp; 18/37 chance (~48.6%)</span></td>
            <td>Bid: <form:select path="blackBid"><form:options items="${rouletteManager.blackBidList}"/></form:select></td>
        </tr>
        <tr>
            <td><span class="clr-green">GREEN</span></td>
            <td><span class="odds">x5 payout &nbsp;|&nbsp; 1/37 chance (~2.7%)</span></td>
            <td>Bid: <form:select path="greenBid"><form:options items="${rouletteManager.greenBidList}"/></form:select></td>
        </tr>
    </table>

    <br>
    <input type="submit" class="btn-spin" value="SPIN">

</form:form>

<div class="nav-area">
    <input type="button" class="btn-nav" value="Another Game" onclick="window.location.href='/play/getGamesList'">
    <input type="button" class="btn-nav" value="Main Menu"    onclick="window.location.href='/'">
</div>

</body>
</html>
