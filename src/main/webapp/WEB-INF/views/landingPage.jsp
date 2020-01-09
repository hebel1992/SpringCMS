<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form"
           uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<html>
<style>
    .divider {
        margin: 10px;
        display: block;
    }
</style>
<head>
    <title>Landing Page</title>
</head>
<body>
<h1>Ostatnio dodane artykuły:</h1>
<table border="1">
    <thead style="font-weight: bold">
    <tr>
        <td>
            Tytuł
        </td>
        <td>
            Data dodania
        </td>
        <td>
            ...
        </td>
    </tr>
    </thead>
    <c:forEach items="${articles}" var="article">
        <tr>
            <td>
                    ${article.title}
            </td>
            <td>
                    ${article.created}
            </td>
            <td>
                    ${fn:substring(article.content, 0, 200)}...
            </td>
        </tr>
    </c:forEach>
</table>
<br/>


<button class="divider"><a href="/category/list">Lista kategorii</a></button>


<button class="divider"><a href="/author/list">Lista autorów</a></button>


<button class="divider"><a href="/article/list">Lista artykułów</a></button>


<button class="divider"><a href="/draft/list">Szkice artykułów</a></button>

</body>
</html>
