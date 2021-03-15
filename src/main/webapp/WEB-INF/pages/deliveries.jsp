<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Deliveries</title>
</head>
<body>
    <h2>Deliveries</h2>
    <table>
        <tr>
            <th>id</th>
            <th>weight</th>
            <th>date</th>
            <th>idPricePeriod</th>
        </tr>
        <c:forEach var="delivery" items="${deliveryList}">
            <tr>
                <td>${delivery.id}</td>
                <td>${delivery.weight}</td>
                <td>${delivery.date}</td>
                <td>${delivery.pricePeriod.id}</td>
                <td>
                    <a href="/deleteDelivery/${delivery.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/addDelivery" var="addDelivery"/>
    <a href="${addDelivery}">+ Add new delivery</a>
    <p><a href="/">Back to home page</a> </p>
</body>
</html>
