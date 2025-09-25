<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>곡 정보</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-5">

<h1 class="mb-4">${music.nickname}</h1>

<div class="mb-3">
    <a href="/musics/new" class="btn btn-primary">추가</a>
    <a href="/musics/${music.id}/edit" class="btn btn-warning">수정</a>
    <form action="/musics/${music.id}/delete" method="post" class="d-inline">
        <button type="submit" class="btn btn-danger">삭제</button>
    </form>
    <a href="/musics" class="btn btn-secondary">전체보기</a>
</div>

<table class="table table-hover">
    <thead class="table-dark">
    <tr>
        <th>곡</th>
        <th>아티스트</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach var="music" items="${musics}">
        <tr>
            <td><a href="/musics/${music.id}">${music.title}</a></td>
            <td>${music.artist}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>

