<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib  uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Partners</title>
</head>
<body>
    <h2>Partners</h2>
    <table>
        <tr>
            <th>id</th>
            <th>name</th>
        </tr>
        <c:forEach var="partner" items="${partnerList}">
            <tr>
                <td>${partner.id}</td>
                <td>${partner.name}</td>
                <td>
                    <a href="/deletePartner/${partner.id}">delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    <c:url value="/addPartner" var="addPartner"/>
    <a href="${addPartner}">+ Add new partner</a>
    <p><a href="/">Back to home page</a> </p>
</body>
</html>
