<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/article"/>
<html>
<style>
    .error {
        color: red;
    }
</style>
<head>
    <title>Add Article</title>
</head>
<body>
<h1>Dodaj nowy artykuł</h1>
<%--@elvariable id="article" type="pl.coderslab.models.Article"--%>
<form:form action="${contextPath}/add" method="post" modelAttribute="article">

    <div>Tytul: <form:input path="title" type="text"/>
        <form:errors path="title" cssClass="error"/>
    </div>

    <div>Treść: <form:textarea path="content"/>
        <form:errors path="content" cssClass="error"/>
    </div>

    <div> Autor: <form:select path="author" items="${authors}" itemLabel="lastName" itemValue="id"/></div>

    <div> Kategoria: <form:select path="categories" items="${categories}" itemLabel="name" itemValue="id"
                                  multiple="true"/>
        <form:errors path="categories" cssClass="error"/>
    </div>

    <input type="submit" value="Dodaj">
</form:form><br/>
<a href="${contextPath}/list">
    <button>Wróć</button>
</a>
</body>
</html>