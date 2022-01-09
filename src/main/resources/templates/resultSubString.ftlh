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

<form action="/calculateSubString" method="post">
    <input type="text" name="substrings" placeholder="Введите подстроки через запятую" value="${inputArray[0]}">
    <input type="text" name="strings" placeholder="Введите строки через запятую" value="${inputArray[1]}">
    <input type="submit" value="Посчитать">
</form>
<#list outputArray as output>
    <table width="400" class="output_table" border="1">
        <tr valign="middle" align="center">
            <td>${output}</td>
        </tr>
    </table>

</#list>
</body>
</html>