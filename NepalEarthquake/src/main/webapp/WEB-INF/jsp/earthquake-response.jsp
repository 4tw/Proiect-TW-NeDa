<!DOCTYPE html>
<html lang = "en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width = device-width,initial-scale = 1">
	<title>Nepal Earthquake-Earthquake response </title>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	     <style>
  .carousel-inner > .item > img,
  .carousel-inner > .item > a > img {
      width: 40%;
      margin: auto;
	  height : 60%;
  }
body { 
  background: url("/resources/img/background.jpg") no-repeat center center fixed;
  -webkit-background-size: cover;
  -moz-background-size: cover;
  -o-background-size: cover;
  background-size: cover;
}
p{
font:rgb(0,0,0);
font-size:17px;
font-family: "Times New Roman", Georgia, Serif;
}
  #map {
	  height: 100%;
  }


div{
background:transparent;
margin:0 auto;
}
.container-fluid {
      margin: 0 auto;
	  background:transparent ;
      max-width: 970px;
	  height:60%;
   }
}
  </style>
	<script src="/resources/js/aftershocks.js"></script>
</head>
<body>
<div class="container-fluid">
	<div class="hidden-xs">
	<nav class="navbar navbar-inverse navbar-static-top" style="padding-right: 20px;">
		<div class="navbar-header">
			<a class="navbar-brand" href="index">Nepal Earthquake</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
			<li ><a href="index">Home</a></li>
			<li ><a href="deaths">Deaths</a></li>
			<li ><a href="damages">Damages</a></li>
			<li ><a href="earthquake-propagation">Earthquake Propagation</a></li>
			<li class="active"><a href="earthquake-response">Earthquake response</a></li>
			<li><a href="map">InteractivMap</a></li>
		</ul>
    </nav>
	</div>
	   <div class="hidden-sm hidden-md hidden-lg">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="#">Nepal Earthquake</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Meniu <span class="caret"></span></a>
          <ul class="dropdown-menu">
			<li><a href="index">Home</a></li>
			<li><a href="deaths">Deaths</a></li>
			<li><a href="damages">Damages</a></li>
			<li><a href="earthquake-propagation">Earthquake Propagation</a></li>
			<li  class="active"><a href="earthquake-response">Earthquake response</a></li>
			<li><a href="map">InteractivMap</a></li>
          </ul>
        </li>
		</ul>
    </nav>
	</div>
	  <h1 style="font-family:verdana; color:blue; font-size: 150%">Information about Earthquake response:<br><br></h1>
  <div style="background:rgb(200,200,200);padding:10px;">
  <br><br>
	  <button id="start">Start</button>
	  <div id="googleMap" style="width:100%;height:400px;"></div>

	  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFc7pJusrQeKWR-7FpNZUQEa4GUDadyi8&callback=myMap"></script>

  </div>
</div>
</body>
</html>