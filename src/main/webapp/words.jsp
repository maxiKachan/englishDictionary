<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Words JSP</h1>
<table>
    <tr>
        <th>Word</th>
    </tr>
    <jsp:useBean id="words" scope="request" type="java.util.List"/>
    <c:forEach var="list" items="${words}">
        <tr><td>${list}</td></tr>
    </c:forEach>
</table>
</body>
</html>
