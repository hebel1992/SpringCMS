<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<head>
    <title>Add Category</title>
</head>
<body>
<h1>Dodaj nową kategorię</h1>
<%--@elvariable id="category" type="pl.coderslab.models.Category"--%>
<form:form action="/category/add" method="post" modelAttribute="category">
    Tytuł: <form:input path="name" type="text"/><br/>
    Opis: <form:textarea path="description"/>
    <input type="submit" value="Dodaj">
</form:form>
</body>
</html>
