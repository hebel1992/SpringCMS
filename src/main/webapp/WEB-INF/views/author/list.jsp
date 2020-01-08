<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<c:set var="contextPath" value="${pageContext.request.contextPath}/author"/>
<html>
<head>
    <title>Author List</title>
</head>
<body>
<h1>Lista autorów:</h1>
<table border="1">
    <thead style="font-weight: bold">
    <tr>
        <td>
            Imie
        </td>
        <td>
            Nazwisko
        </td>
        <td>
            Akcja
        </td>
    </tr>
    </thead>
    <c:forEach items="${authors}" var="author">
        <tr>
            <td>${author.firstName}</td>
            <td>${author.lastName}</td>
            <td><a href="${contextPath}/edit/${author.id}">Edytuj</a>/<a
                    href="${contextPath}/delete/${author.id}">Usun</a>
            </td>
        </tr>
    </c:forEach>
</table>
<br/>
<a href="${contextPath}/add">
    <button>Dodaj nowego</button>
</a>
<a href="/">
    <button>Wróć</button>
</a>
</body>
</html>
