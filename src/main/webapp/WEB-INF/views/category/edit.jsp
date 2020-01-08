<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/category"/>
<html>
<head>
    <title>Edit Category</title>
</head>
<body>
<h1>Edycja kategorii</h1>
<%--@elvariable id="category" type="pl.coderslab.models.Category"--%>
<form:form action="${contextPath}/edit" method="post" modelAttribute="category">
    <form:hidden path="id"/>
    Tytuł: <form:input path="name" type="text"/><br/>
    Opis: <form:textarea path="description"/>
    <input type="submit" value="Zaktualizuj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>

