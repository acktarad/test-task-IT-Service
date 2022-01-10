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
        <input type="text" name="substrings" placeholder="Введите подстроки через запятую">
        <input type="text" name="strings" placeholder="Введите строки через запятую">
        <input type="submit" value="Посчитать">
    </form>
    <form action="/download" method="post">
        <input type="submit" value="Загрузить">
    </form>
    <form action="/importFile" method="post" enctype="multipart/form-data">
        <input type="file" name="file">
        <input type="submit" value="Импортировать">
    </form>
</body>
</html>