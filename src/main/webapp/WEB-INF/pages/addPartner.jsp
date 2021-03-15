<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Partner</title>
</head>
<body>
    <c:url value="/addPartner" var="var"/>
    <form action="${var}" method="POST">
        <label for="name">Name</label>
        <input type="text" name="name" id="name">
        <input type="submit" value="Apply Add">
    </form>
</body>
</html>
