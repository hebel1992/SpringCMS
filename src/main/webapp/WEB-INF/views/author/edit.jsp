<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<h1>Edycja autora</h1>
<%--@elvariable id="author" type="pl.coderslab.models.Author"--%>
<form:form action="${contextPath}/edit" method="post" modelAttribute="author">
    <form:hidden path="id"/>
    Imie: <form:input path="firstName" type="text"/><br/>
    Nazwisko: <form:input path="lastName" type="text"/>
    <input type="submit" value="Zaktualizuj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>
