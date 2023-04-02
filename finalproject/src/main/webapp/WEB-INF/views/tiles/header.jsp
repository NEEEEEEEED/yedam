<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>

<ul class="nav justify-content-center">
  <li class="nav-item">
    <a class="nav-link active" aria-current="page" href="${pageContext.request.contextPath }/empList">게시판</a>
  </li>
  <sec:authorize access="hasRole('ROLE_ADMIN')">
	  <li class="nav-item">
	    <a class="nav-link active" href="${pageContext.request.contextPath }/empInsert">게시글 등록</a>
	  </li>
  </sec:authorize>
  <li class="nav-item">
    <a class="nav-link active" href="${pageContext.request.contextPath }/logout">로그아웃</a>
  </li>
  <li class="nav-item">
    <a class="nav-link disabled">Disabled</a>
  </li>
</ul>

