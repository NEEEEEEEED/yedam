<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
    
    <table class="table">
    	<tr>
    		<th>글번호</th>
    		<td>${vo.noticeId }</td>
    		<th style="text-align: right">조회수</th>
    		<td>${vo.hitCount }</td>
    	</tr>
    	<tr>
    		<th colspan="1">작성자</th>
    		<td colspan="3">${vo.noticeWriter }</td>
    	</tr>
    	<tr>
    		<th colspan="1">제목</th>
    		<td colspan="3">${vo.noticeTitle }</td>
    	</tr>
    	<tr>
    		<th>내용</th>
    		<td colspan="3"><textarea cols="50" rows="4">${vo.noticeSubject }</textarea></td>
    	</tr>
		<tr>
    		<th>작성일자</th>
    		<td colspan="3"><fmt:formatDate pattern="yyyy-MM-dd hh:mm:ss" value="${vo.noticeDate }"/></td>
    	</tr> 
    	<tr>
    		<th>첨부파일</th>
    		<td colspan="3"><a target="_blank" href="upload/${vo.attachFile }">${vo.attachFile }</td>
    	</tr> 
    </table>