<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/bxslider/4.2.12/jquery.bxslider.min.js"></script>

<h3>MainPage</h3>
<div class="slider">
	<div>
		<img width="1000px" src="images/wallpaper1.jpg">
	</div>
	<div>
		<img width="1000px" src="images/wallpaper2.jpg">
	</div>
	<div>
		<img width="1000px" src="images/wallpaper3.jpg">
	</div>
</div>

<script>
	$('.slider').bxSlider({
		auto : true,
		autoControls : true,
		stopAutoOnClick : true,
		mode : 'fade',
		captions : true,
		slideWidth : 1000
	});
</script>