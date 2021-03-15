<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Prices per periods</title>
</head>
<body>
<h2>Prices per periods</h2>
<table>
    <tr>
        <th>id</th>
        <th>price</th>
        <th>dateBegin</th>
        <th>dateEnd</th>
        <th>partner</th>
        <th>fruitType</th>
    </tr>
    <c:forEach var="pricePeriod" items="${pricePeriodList}">
        <tr>
            <td>${pricePeriod.id}</td>
            <td>${pricePeriod.price}</td>
            <td>${pricePeriod.dateBegin}</td>
            <td>${pricePeriod.dateEnd}</td>
            <td>${pricePeriod.partner.name}</td>
            <td>${pricePeriod.fruitType.name}( ${pricePeriod.fruitType.fruit.name} )</td>
            <td>
                <a href="/deletePricePeriod/${pricePeriod.id}">delete</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/addPricePeriod" var="addPricePeriod"/>
<a href="${addPricePeriod}">+ Add new price period</a>
<p><a href="/">Back to home page</a> </p>
</body>
</html>
