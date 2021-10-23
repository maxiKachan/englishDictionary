<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>Update</title>
</head>
<body>
<jsp:useBean id="word" scope="request" class="com.maximKachan.englishDictionary.domain.Word"/>
<form method="post" action="/words/${word.wordId}">
    <input type="hidden" name="_method" value="patch">
    <label>Id<input type="number" name="wordId" value="${word.wordId}" readonly></label><br>
    <label>Word in English<input type="text" name="word" value="${word.word}"></label><br>
    <label>Meaning<input type="text" name="meaning" value="${word.meaning}"></label><br>
    <button type="submit">Update</button>
</form>
</body>
</html>
