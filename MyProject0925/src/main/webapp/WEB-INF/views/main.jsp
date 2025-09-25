<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>홈페이지</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-5">

<h1 class="mb-4">플레이리스트</h1>

<div class="mb-3">
    <a href="/musics/new" class="btn btn-primary">추가</a>
</div>

<table class="table table-hover">
    <thead class="table-dark">
    <tr>
        <th>Num</th>
        <th>재생목록</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="music" items="${musics}">
        <tr>
            <td>${music.id}</td>
            <td><a href="/musics/${music.id}">${music.nickname}</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
