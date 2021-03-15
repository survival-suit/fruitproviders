<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Fruits</title>
</head>
<body>
    <h2>Fruits</h2>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="fruit" items="${fruits}">
            <tr>
                <td>${fruit.id}</td>
                <td>${fruit.name}</td>
                <td>
                    <a href="/editFruit/${fruit.id}">edit</a>
                    <a href="/deleteFruit/${fruit.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/addFruit" var="addFruit"/>
    <a href="${addFruit}">+ Add new fruit</a>
    <p><a href="/">Back to home page</a> </p>
</body>
</html>
