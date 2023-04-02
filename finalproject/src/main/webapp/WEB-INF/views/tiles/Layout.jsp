<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>

<!DOCTYPE html>
<html>
<head>

<!-- <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/css/bootstrap.min.css" rel="stylesheet"> -->
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href=".../resources/static/assets/vendor/bootstrap/css/bootstrap.min.css">
    <link href="../resources/static/assets/vendor/fonts/circular-std/style.css" rel="stylesheet">
    <link rel="stylesheet" href=".../resources/static/assets/libs/css/style.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/fonts/fontawesome/css/fontawesome-all.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/charts/chartist-bundle/chartist.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/charts/morris-bundle/morris.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/fonts/material-design-iconic-font/css/materialdesignicons.min.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/charts/c3charts/c3.css">
    <link rel="stylesheet" href=".../resources/static/assets/vendor/fonts/flag-icon-css/flag-icon.min.css">
    <title>Concept - Bootstrap 4 Admin Dashboard Template</title>
</head>
<body>
    <!-- ============================================================== -->
    <!-- main wrapper -->
    <!-- ============================================================== -->
    <div class="dashboard-main-wrapper">
    <header>
		<tiles:insertAttribute name="header"></tiles:insertAttribute>
	</header>
	<nav>
		<tiles:insertAttribute name="nav"></tiles:insertAttribute>
	</nav>
	<main>
		<tiles:insertAttribute name="main"></tiles:insertAttribute>
	</main>
	<footer>
		<tiles:insertAttribute name="footer"></tiles:insertAttribute>
	</footer>
    <!-- Optional JavaScript -->
    <!-- jquery 3.3.1 -->
    <script src="/resources/static/assets/vendor/jquery/jquery-3.3.1.min.js"></script>
    <!-- bootstap bundle js -->
    <script src="/resources/static/assets/vendor/bootstrap/js/bootstrap.bundle.js"></script>
    <!-- slimscroll js -->
    <script src="/resources/static/assets/vendor/slimscroll/jquery.slimscroll.js"></script>
    <!-- main js -->
    <script src="/resources/static/assets/libs/js/main-js.js"></script>
    <!-- chart chartist js -->
    <script src="/resources/static/assets/vendor/charts/chartist-bundle/chartist.min.js"></script>
    <!-- sparkline js -->
    <script src="/resources/static/assets/vendor/charts/sparkline/jquery.sparkline.js"></script>
    <!-- morris js -->
    <script src="/resources/static/assets/vendor/charts/morris-bundle/raphael.min.js"></script>
    <script src="/resources/static/assets/vendor/charts/morris-bundle/morris.js"></script>
    <!-- chart c3 js -->
    <script src="/resources/static/assets/vendor/charts/c3charts/c3.min.js"></script>
    <script src="/resources/static/assets/vendor/charts/c3charts/d3-5.4.0.min.js"></script>
    <script src="/resources/static/assets/vendor/charts/c3charts/C3chartjs.js"></script>
    <script src="/resources/static/assets/libs/js/dashboard-ecommerce.js"></script>
  </body>
</html>