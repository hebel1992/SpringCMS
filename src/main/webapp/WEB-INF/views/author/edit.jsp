<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>
<style>
    .error{
        color: red;
    }
</style>
<head>
    <title>Edit Author</title>
</head>
<body>
<h1>Edycja autora</h1>
<%--@elvariable id="author" type="pl.coderslab.models.Author"--%>
<form:form action="${contextPath}/edit" method="post" modelAttribute="author">
    <form:hidden path="id"/>

    <div>Imie: <form:input path="firstName" type="text"/>
        <form:errors path="firstName" cssClass="error"/></div>
    <div>Nazwisko: <form:input path="lastName" type="text"/>
        <form:errors path="lastName" cssClass="error"/></div>

    <input type="submit" value="Zaktualizuj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>
