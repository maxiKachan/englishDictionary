<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Words JSP</h1>
<h3><a href="home">Home Page</a> </h3>
<jsp:useBean id="word" scope="request" class="java.lang.String"/>
<jsp:useBean id="id" scope="request" class="java.lang.String"/>
<jsp:useBean id="meaning" scope="request" class="java.lang.String"/>
<form action="words" method="post">
    <h4>Add new words</h4>
    <label><input type="text" name="word" value="${word}" required></label>
    <label><input type="text" name="meaning" value="${meaning}" required></label>
    <label><input type="text" name="id" value="${id}" readonly></label>
    <button type="submit">Add</button>
</form>
<table>
    <tr>
        <th>Words</th>
        <th>Meaning</th>
    </tr>
    <jsp:useBean id="words" scope="request" type="java.util.List"/>
    <c:forEach var="word" items="${words}">
        <tr>
            <td>${word.word}</td>
            <td>${word.meaning}</td>
            <td><a href="words/delete?id=${word.wordId}">Delete</a></td>
            <td><a href="words/update?id=${word.wordId}&word=${word.word}&meaning=${word.meaning}">Update</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
