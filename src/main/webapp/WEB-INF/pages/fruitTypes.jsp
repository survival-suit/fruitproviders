<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fruit Types</title>
</head>
<body>
<h2>Fruit Types</h2>
<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>fruit</th>
    </tr>
    <c:forEach var="fruitType" items="${fruitTypes}">
        <tr>
            <td>${fruitType.id}</td>
            <td>${fruitType.name}</td>
            <td>${fruitType.fruit}</td>
            <td>
                <a href="/deleteFruitType/${fruitType.id}">deleteFruitType</a>
            </td>
        </tr>
    </c:forEach>
</table>
<c:url value="/addFruitType" var="addFruitType"/>
<a href="${addFruitType}">+ Add new fruit type</a>
</body>
</html>
