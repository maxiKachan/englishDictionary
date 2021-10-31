<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Item</title>
</head>
<body>
<h3><a href="words">All words</a></h3>
<jsp:useBean id="word" scope="request" type="com.maximKachan.englishDictionary.domain.Word"/>
<table border="1">
    <tr>
        <th><h3>Id</h3></th>
        <th><h3>Word</h3></th>
        <th><h3>Type of Word</h3></th>
        <th><h3>Meaning</h3></th>
    </tr>
    <tr>
        <th><h3>${word.wordId}</h3></th>
        <th><h3>${word.word}</h3></th>
        <th><h3>${word.type}</h3></th>
        <th><h3>${word.meaning}</h3></th>
    </tr>
    <tr>
        <th>
            <h2>
                <button type="button"><a href="/words/${word.wordId}/edit">Update</a></button>
            </h2>
        </th>
        <th>
            <form method="post" action="/words/${word.wordId}">
                <input type="hidden" name="_method" value="delete">
                <h2>
                    <button type="submit">Delete</button>
                </h2>
            </form>
        </th>
    </tr>
</table>
</body>
</html>
