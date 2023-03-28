<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<ul class="nav">
  <li class="nav-item">
  <!-- contextpath를 자동으로 지정하기 위해서 el태그 사용 -->
    <a class="nav-link" href="${pageContext.request.contextPath }/getBoardList">게시판</a>
  </li>
  <li class="nav-item">
    <a class="nav-link" href="${pageContext.request.contextPath }/boardInsert">게시글 등록</a>
  </li>
</ul>