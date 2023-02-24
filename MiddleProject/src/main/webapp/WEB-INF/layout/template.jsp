<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html>
<html lang="en">

  <head>

    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="">
    <link href="https://fonts.googleapis.com/css?family=Poppins:100,200,300,400,500,600,700,800,900&display=swap" rel="stylesheet">

    <title>Hexashop Ecommerce HTML CSS Template</title>


    <!-- Additional CSS Files -->
    <link rel="stylesheet" type="text/css" href="bootstrap/assets/css/bootstrap.min.css">

    <link rel="stylesheet" type="text/css" href="bootstrap/assets/css/font-awesome.css">

    <link rel="stylesheet" href="bootstrap/assets/css/templatemo-hexashop.css">

    <link rel="stylesheet" href="bootstrap/assets/css/owl-carousel.css">

    <link rel="stylesheet" href="bootstrap/assets/css/lightbox.css">
<!--

TemplateMo 571 Hexashop

https://templatemo.com/tm-571-hexashop

-->
    </head>
<body>
	<!-- Navigation-->
	<tiles:insertAttribute name="menu">
	</tiles:insertAttribute>

	<!-- Header-->
	<tiles:insertAttribute name="header">
	</tiles:insertAttribute>

	<!-- Section-->
	<tiles:insertAttribute name="body">
	</tiles:insertAttribute>

	<!-- Footer-->
	<tiles:insertAttribute name="footer">
	</tiles:insertAttribute>
	
	<!-- jQuery -->
    <script src="bootstrap/assets/js/jquery-2.1.0.min.js"></script>

    <!-- Bootstrap -->
    <script src="bootstrap/assets/js/popper.js"></script>
    <script src="bootstrap/assets/js/bootstrap.min.js"></script>

    <!-- Plugins -->
    <script src="bootstrap/assets/js/owl-carousel.js"></script>
    <script src="bootstrap/assets/js/accordions.js"></script>
    <script src="bootstrap/assets/js/datepicker.js"></script>
    <script src="bootstrap/assets/js/scrollreveal.min.js"></script>
    <script src="bootstrap/assets/js/waypoints.min.js"></script>
    <script src="bootstrap/assets/js/jquery.counterup.min.js"></script>
    <script src="bootstrap/assets/js/imgfix.min.js"></script> 
    <script src="bootstrap/assets/js/slick.js"></script> 
    <script src="bootstrap/assets/js/lightbox.js"></script> 
    <script src="bootstrap/assets/js/isotope.js"></script>
    <script src="bootstrap/assets/js/quantity.js"></script>
    
    <!-- Global Init -->
    <script src="bootstrap/assets/js/custom.js"></script>

    <script>

        $(function() {
            var selectedClass = "";
            $("p").click(function(){
            selectedClass = $(this).attr("data-rel");
            $("#portfolio").fadeTo(50, 0.1);
                $("#portfolio div").not("."+selectedClass).fadeOut();
            setTimeout(function() {
              $("."+selectedClass).fadeIn();
              $("#portfolio").fadeTo(50, 1);
            }, 500);
                
            });
        });

    </script>
</body>
</html>
