<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Главная страница</title>
</head>
<body>
<form action="/taskSelection" method="post">
    <select name = "combobox">
        <option value="magicSquare" name="magicSquare">magic square</option>
        <option value="subString">substring in string</option>
    </select>
    <input type="submit" value="Выбрать">
</form>

<form action="/calculateSquare" method="post">

    <table width="40">
        <tr width="40">
            <td><input type="text" value="${inputArray[0][0]}" name="topLeft"></td>
            <td><input type="text" value="${inputArray[0][1]}" name="topCenter"></td>
            <td><input type="text" value="${inputArray[0][2]}" name="topRight"></td>
        </tr>
        <tr width="40">
            <td><input type="text" value="${inputArray[1][0]}" name="centerLeft"></td>
            <td><input type="text" value="${inputArray[1][1]}" name="centerCenter"></td>
            <td><input type="text" value="${inputArray[1][2]}" name="centerRight"></td>
        </tr>
        <tr width="40">
            <td><input type="text" value="${inputArray[2][0]}" name="bottomLeft"></td>
            <td><input type="text" value="${inputArray[2][1]}" name="bottomCenter"></td>
            <td><input type="text" value="${inputArray[2][2]}" name="bottomRight"></td>
        </tr>
    </table>


    <input type="submit" value="Посчитать">
</form>
<#if outputArray??>
    <#list outputArray as output>
        <table width="400"  border="1">
            <tr valign="middle" align="center">
                <td>${output[0]}</td>
                <td>${output[1]}</td>
                <td>${output[2]}</td>
            </tr>
        </table>

    </#list>
<#else>
    Составление магического квадрата из данного набора чисел невозможно
</#if>

</body>
</html>