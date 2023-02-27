<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.3/jquery.min.js">
</script> 

<h3>검색 결과 페이지 입니다.</h3>

<c:if test = "${empty list }">
 <h3>검색결과 없음</h3>
</c:if>
 
<section class="py-5">
            <div class="container px-4 px-lg-5 mt-5">
                <div class="row gx-5 gx-lg-5 row-cols-2 row-cols-md-3 row-cols-xl-4 justify-content-center">
                <c:forEach var="list" items="${list }">
                    <div class="col mb-5 colbox">
                        <div class="card h-100">
                            <!-- Sale badge-->
<!--                             <div class="badge bg-dark text-white position-absolute" style="top: 0.5rem; right: 0.5rem"></div> -->
                            <!-- Product image-->
                            <img class="card-img-top" src="images/${list.proImg }" alt="..." class="img"/>
                            <!-- Product details-->
                            <div class="card-body p-4">
                                <div class="text-center">
                                    <!-- Product name-->
                                    <h5 class="fw-bolder"><a href="productDetail.do?pid=${list.proId }">${list.proName }</a></h5>
                                    <!-- Product reviews-->
                                    <div class="d-flex justify-content-center small text-warning mb-2">
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                        <div class="bi-star-fill"></div>
                                    </div>
                                    <!-- Product price-->
                                    
                                    ${list.proPrice }원
                                </div>
                            </div>
                            <!-- Product actions-->
                            <div class="card-footer p-4 pt-0 border-top-0 bg-transparent">
                                <div class="text-center"><a class="btn btn-outline-dark mt-auto" href="#">Add to cart</a></div>
                            </div>
                        </div>
                    </div>
                </c:forEach>
                </div>
            </div>
        </section>