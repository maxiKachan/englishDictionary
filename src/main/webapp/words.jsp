<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Words JSP</h1>
<form action="words" method="post">
    <h4>Add new words</h4>
    <label><input type="text" name="word" required></label>
    <button type="submit">Add</button>
</form>
<table>
    <tr>
        <th>Words</th>
        <th>action</th>
    </tr>
    <jsp:useBean id="words" scope="request" type="java.util.List"/>
    <c:forEach var="list" items="${words}">
        <tr>
            <td>${list}</td>
            <td><a href="words?id=${words.indexOf(list)}">Delete</a></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
