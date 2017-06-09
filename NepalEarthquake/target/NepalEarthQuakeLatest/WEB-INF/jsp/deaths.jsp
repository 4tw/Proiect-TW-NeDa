<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width,initial-scale = 1">
	<title>Nepal Earthquake-Deaths </title>
    <script src="/resources/js/nepal.js"></script>
	<link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="https://cdn.anychart.com/js/7.13.1/anychart-bundle.min.js"></script>
    <link rel="stylesheet" href="https://cdn.anychart.com/css/7.13.1/anychart-ui.min.css" />
    <link rel="stylesheet" href="/resources/css/deaths.css" />

    <script src="/resources/js/graphic_deaths.js">


    </script>
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
			<li class="active"><a href="deaths">Deaths</a></li>
			<li ><a href="damages">Damages</a></li>
			<li><a href="earthquake-propagation">Earthquake Propagation</a></li>
			<li><a href="earthquake-response">Earthquake response</a></li>
			<li><a href="map">InteractivMap</a></li>
		</ul>
    </nav>
	</div>
	   <div class="hidden-sm hidden-md hidden-lg">
	<nav class="navbar navbar-inverse navbar-fixed-top">
		<div class="navbar-header">
			<a class="navbar-brand" href="index">Nepal Earthquake</a>
		</div>
		<ul class="nav navbar-nav navbar-right">
		<li class="dropdown">
          <a class="dropdown-toggle" data-toggle="dropdown" href="#">Meniu <span class="caret"></span></a>
          <ul class="dropdown-menu">
			<li ><a href="index">Home</a></li>
			<li class="active"><a href="deaths">Deaths</a></li>
			<li><a href="damages">Damages</a></li>
			<li><a href="earthquake-propagation">Earthquake Propagation</a></li>
			<li><a href="earthquake-response">Earthquake response</a></li>
			<li><a href="map">InteractivMap</a></li>
          </ul>
        </li>
		</ul>
    </nav>
	</div>
	  <h1 style="font-family:verdana; color: hsl(0,0%,0%); font-size: 150%">Information about deaths:<br><br></h1>
  <div id="div1">
      <div class="row" id="row1">
          <div class="col-md-6" id="col1" style="margin :0 auto; pading:10px;">
              <div id="container"></div>
          </div>
          <div class="col-md-6" id="col2" style="margin :0 auto; pading:10px;">
              <div id="graphic"></div><br>
              <button type="button" class="btn btn-primary" id="btnJPG" style="float: right;">Save JPG</button>
              <button type="button" class="btn btn-primary" id="btnPNG" style="float: right;">Save PNG</button>
              <button type="button" class="btn btn-primary" id="btnSVG" style="float: right;">Save SVG</button>
          </div>
      </div>

	 </div>	
</div>
</body>
</html>