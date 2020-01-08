<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
<h1>Dodaj nowego autora</h1>
<%--@elvariable id="author" type="pl.coderslab.models.Author"--%>
<form:form action="${contextPath}/add" method="post" modelAttribute="author">

    Imie: <form:input path="firstName" type="text"/><br/>
    Nazwisko: <form:input path="lastName" type="text"/>
    <input type="submit" value="Dodaj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>
