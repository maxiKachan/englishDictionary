<%@ page contentType="text/html;charset=UTF-8" %>

<html>
<head>
    <title>Add new word</title>
</head>
<body>
<h3>Insert new word</h3>
<form  method="post" action="words">
    <label>Word in English<input type="text" name="word"></label>
    <br>
    <label>Type of word<select name="type">
        <option>VERB</option>
        <option>NOUN</option>
    </select></label>
    <br>
    <label>Meaning<input type="text" name="meaning"></label>
    <br>
    <button type="submit">Add</button>
</form>
</body>
</html>
