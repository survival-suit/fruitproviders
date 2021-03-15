<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Fruit Type</title>
</head>
<body>
    <c:url value="/addFruitType" var="var"/>
    <form action="${var}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">

        <label for="fruitId">Вид фрукта</label>
        <select name="fruitId" id="fruitId">
            <c:forEach var="fruitVar" items="${fruits}">
                <option value="${fruitVar.id}">${fruitVar.name}</option>
            </c:forEach>
        </select>
        <input type="submit" value="Apply Add">
    </form>
</body>
</html>
