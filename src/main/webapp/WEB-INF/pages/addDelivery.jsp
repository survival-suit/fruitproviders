<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Delivery</title>
</head>
<body>
<c:url value="/addDelivery" var="addDelivery"/>
<form action="${addDelivery}" method="POST">
    <label for="weight">Вес(кг)</label>
    <input type="number" name="weight" id="weight">

    <label for="date">Дата поставки</label>
    <input type="date" name="date" id="date">

 <label for="pricePeriod">Выбрать фрукт</label>
    <select name="pricePeriodId" id="pricePeriod">
        <c:forEach var="pricePeriod" items="${pricePeriodList}">
            <option value="${pricePeriod.id}"> Поставщик: ${pricePeriod.partner.name}; Фрукт:${pricePeriod.fruitType.name}(${pricePeriod.fruitType.fruit.name}); Цена: ${pricePeriod.price}; Начало периода:${pricePeriod.dateBegin}; Конец периода:${pricePeriod.dateEnd};)</option>
        </c:forEach>
    </select>

    <input type="submit" value="Apply Add">
</form>
</body>
</html>
