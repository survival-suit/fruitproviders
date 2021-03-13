<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Add Fruit</title>
</head>
<body>
    <c:url value="/addFruit" var="var"/>
    <form action="${var}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <input type="submit" value="Apply Add">
    </form>
</body>
</html>
