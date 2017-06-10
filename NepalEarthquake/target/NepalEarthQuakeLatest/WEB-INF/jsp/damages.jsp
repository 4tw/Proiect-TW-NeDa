<!DOCTYPE html>
<html lang = "en">
<head>
	<meta charset="UTF-8">
	<meta name="viewport" content="width = device-width,initial-scale = 1">
	<title>Nepal Earthquake-Damages </title>
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
			<li class="active"><a href="damages">Damages</a></li>
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
			<li><a href="index">Home</a></li>
			<li><a href="deaths">Deaths</a></li>
			<li class="active"><a href="damages">Damages</a></li>
			<li><a href="earthquake-propagation">Earthquake Propagation</a></li>
			<li><a href="earthquake-response">Earthquake response</a></li>
			<li><a href="map">InteractivMap</a></li>
          </ul>
        </li>
		</ul>
    </nav>
	</div>
	  <h1 style="font-family:verdana; color:blue; font-size: 150%">Information about damages:<br><br></h1>
  <div style="background:rgb(200,200,200);padding:10px;">
  <br><br>
		    <form class="form-inline">
				<div class="form-group">
				  <label for="sel1">Localitate:</label>
				  <select class="form-control" id="sel1">
					<option>Sagarmatha</option>
					<option>Lumbini</option>
					<option>Seti</option>
					<option>Bheri</option>
				  </select>
						<label for="sel2">Format:</label>
				  <select class="form-control" id="sel2">
					<option>Harta</option>
					<option>ColumnChart</option>
					<option>LineChart</option>
					<option>Histograma</option>
				  </select>
				   <button type="submit" class="btn btn-default">Submit</button>
				</div>
            </form>
	 <br><br>
	  <div class="row">
		  <div class="col-sm-6">
		     <img class="hidden-xs" src="/resources/img/9.png" alt="Nepal" width="460" height="345">
	  </div>
		  <div class="col-sm-6">
		  <p>Select the format you want to download the requested information.</p>
		  <br>
		   <form class="form-inline">
				<div class="form-group">
				  <label for="sel3">Format:</label>
				  <select class="form-control" id="sel3">
					<option>PNG</option>
					<option>SVG</option>
				  </select>
				  <br><br>
				   <button type="submit" class="btn btn-primary"><span class="glyphicon glyphicon-download"></span> Download</button>
				</div>
            </form>
		   </div>
	 </div>	
</div>
</div>
</body>
</html>