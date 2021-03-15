<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Price Period</title>
</head>
<body>
    <c:url value="/addPricePeriod" var="addPricePeriod"/>
    <form action="${addPricePeriod}" method="POST">
        <label for="price">Цена</label>
        <input type="number" name="price" id="price">

        <label for="dateBegin">Дата начала</label>
        <input type="date" name="dateBegin" id="dateBegin">

        <label for="dateEnd">Дата конца</label>
        <input type="date" name="dateEnd" id="dateEnd">

        <label for="fruitType">Выбрать фрукт</label>
        <select name="fruitTypeId" id="fruitType">
            <c:forEach var="fruitType" items="${fruitTypesList}">
                <option value="${fruitType.id}">${fruitType.name} ( ${fruitType.fruit.name} )</option>
            </c:forEach>
        </select>

        <label for="partner">Выбрать поставщика</label>
        <select name="partnerId" id="partner">
            <c:forEach var="partner" items="${partnersList}">
                <option value="${partner.id}">${partner.name}</option>
            </c:forEach>
        </select>

        <input type="submit" value="Apply Add">
    </form>
</body>
</html>
