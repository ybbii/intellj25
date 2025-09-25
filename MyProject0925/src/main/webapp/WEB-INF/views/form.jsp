<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>${music != null ? "수정" : "추가"}</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="container mt-5">

<h1 class="mb-4">
    <c:choose>
        <c:when test="${music != null}">✏️ 수정</c:when>
        <c:otherwise>📝 작성</c:otherwise>
    </c:choose>
</h1>

<form method="post" action="<c:choose>
        <c:when test="${music != null}">/musics/${music.id}/edit</c:when>
        <c:otherwise>/musics</c:otherwise>
    </c:choose>">

    <div class="mb-3">
        <label for="nickname" class="form-label">플레이리스트 이름</label>
        <input type="text" class="form-control" name="nickname" id="nickname" value="${music.nickname}" required/>
    </div>

    <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input type="text" class="form-control" name="title" id="title" value="${music.title}" required/>
    </div>

    <div class="mb-3">
        <label for="artist" class="form-label">가수</label>
        <textarea class="form-control" name="artist" id="artist" rows="5" required>${music.artist}</textarea>
    </div>

    <button type="submit" class="btn btn-success">
        <c:choose>
            <c:when test="${music != null}">수정 완료</c:when>
            <c:otherwise>작성 완료</c:otherwise>
        </c:choose>
    </button>

    <a href="/musics" class="btn btn-secondary">취소</a>

</form>

</body>
</html>
