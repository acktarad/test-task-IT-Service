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
    <select name="combobox">
        <option value="magicSquare" name="magicSquare">magic square</option>
        <option value="subString">substring in string</option>
    </select>
    <input type="submit" value="Выбрать">
</form>

<form action="/calculateSquare" method="post">
    <table width="40">
        <tr width="40">
            <td><input type="number" min="0" step="1" value="0" name="topLeft"></td>
            <td><input type="number" min="0" step="1" value="0" name="topCenter"></td>
            <td><input type="number" min="0" step="1" value="0" name="topRight"></td>
        </tr>
        <tr width="40">
            <td><input type="number" min="0" step="1" value="0" name="centerLeft"></td>
            <td><input type="number" min="0" step="1" value="0" name="centerCenter"></td>
            <td><input type="number" min="0" step="1" value="0" name="centerRight"></td>
        </tr>
        <tr width="40">
            <td><input type="number" min="0" step="1" value="0" name="bottomLeft"></td>
            <td><input type="number" min="0" step="1" value="0" name="bottomCenter"></td>
            <td><input type="number" min="0" step="1" value="0" name="bottomRight"></td>
        </tr>
    </table>
    <input type="submit" value="Посчитать">
</form>
<form action="/download" method="post">
    <input type="submit" value="Загрузить">
</form>
</body>
</html>