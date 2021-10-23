<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h3><a href="home">Home Page</a> </h3>
<h3><a href="words/new">Add new word </a> </h3>
<table>
    <tr>
        <th>Words</th>
        <th>Meaning</th>
    </tr>
    <jsp:useBean id="words" scope="request" type="java.util.List"/>
    <c:forEach var="word" items="${words}">
        <tr>
            <td><a href="words/${word.wordId}">${word.word}</a></td>
            <td>${word.meaning}</td>
            <td><a href="words?delete=true&id=${word.wordId}">Delete</a></td>
            <td><a href="words?update=true&id=${word.wordId}&word=${word.word}&meaning=${word.meaning}">Update</a> </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
