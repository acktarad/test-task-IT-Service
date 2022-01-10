<!doctype html>
<html lang="ru">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Загрузка задачи</title>
</head>
<body>
<form action="/downloadFilter" method="post">
    <select name="combobox">
        <option value="magicSquare" name="magicSquare">magic square</option>
        <option value="subString">substring in string</option>
    </select>
    <input type="submit" value="Выбрать">
</form>
<table width="600" class="output_table" border="1" >
    <div >
        <tr valign="middle" align="center">
            <td>Тип задачи</td>
            <td colspan="2">Входные данные</td>
            <td>Действие</td>
        </tr>
    </div>
    <#if SquareList??>
        <#list SquareList as square>

            <div>
                <tr valign="middle" align="center">
                    <td>${square.type}</td>
                    <td colspan="2">${square.data}</td>
                    <td>
                        <form action="/downloadSquare" method="post">
                            <input type="hidden" value="${square.id}" name="squareId">
                            <input type="submit" value="Загрузить">
                        </form>
                        <form action="/exportSquare" target="_blank" method="post">
                            <input type="hidden" value="${square.id}" name="squareId">
                            <input type="submit" value="Экспортировать">
                        </form>
                    </td>
                </tr>
            </div>

        </#list>
    <#else>

    </#if>

    <#if subStringsList??>
        <#list subStringsList as subString>
            <div>
                <tr valign="middle" align="center">
                    <td>${subString.type}</td>
                    <td>${subString.substring}</td>
                    <td>${subString.string}</td>
                    <td>
                        <form action="/downloadSubstring" method="post">
                            <input type="hidden" value="${subString.id}" name="subStringId">
                            <input type="submit" value="Загрузить">
                        </form>
                        <form action="/exportSubstring" target="_blank" method="post">
                            <input type="hidden" value="${subString.id}" name="subStringId">
                            <input type="submit" value="Экспортировать">
                        </form>
                    </td>
                </tr>
            </div>

        </#list>
    <#else>

    </#if>

</table>

</body>
</html>