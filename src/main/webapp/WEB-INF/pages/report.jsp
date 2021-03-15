<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Отчет</title>
</head>
<body>
<c:url value="/report" var="report"/>
<form action="${report}" method="POST">

    <label for="dateBegin">Дата начала</label>
    <input type="date" name="dateBegin" id="dateBegin">

    <label for="dateEnd">Дата конца</label>
    <input type="date" name="dateEnd" id="dateEnd">


    <input type="submit" value="Apply Add">
</form>

<table>
    <tr>
        <th>Поставщик</th>
        <th>Фрукт</th>
        <th>Вес</th>
        <th>Дата</th>
        <th>Цена</th>
        <th>Стоимость(итог)</th>
    </tr>
    <c:forEach var="delivery" items="${deliveryList}">
        <tr>
            <td>${delivery.pricePeriod.partner.name}</td>
            <td>${delivery.pricePeriod.fruitType.name}(${delivery.pricePeriod.fruitType.fruit.name})</td>
            <td>${delivery.weight}</td>
            <td>${delivery.date}</td>
            <td>${delivery.pricePeriod.price}</td>
            <td>${delivery.weight*delivery.pricePeriod.price}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
