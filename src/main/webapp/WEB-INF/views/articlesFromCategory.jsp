<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/"/>
<html>
<head>
    <title>Article List</title>
</head>
<body>
<h1>Lista artykułów z kategorii ${category.name}:</h1>
<table border="1">
    <thead style="font-weight: bold">
    <tr>
        <td>
            Tytuł
        </td>
        <td>
            Treść
        </td>
        <td>
            Autor
        </td>
        <td>
            Kategoria
        </td>
        <td>
            Data utworzenia
        </td>
        <td>
            Data aktualizacji
        </td>
        <td>
            Akcja
        </td>
    </tr>
    </thead>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>${article.title}</td>
            <td>${fn:substring(article.content, 0, 200)}...</td>
            <td>${article.author}</td>
            <td>${article.categories}</td>
            <td>${article.created}</td>
            <td>${article.updated}</td>
            <td><a href="${contextPath}/edit/${article.id}">Edytuj</a>/<a
                    href="${contextPath}/delete/${article.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="/">
    <button>Wróć</button>
</a>
</body>
</html>
