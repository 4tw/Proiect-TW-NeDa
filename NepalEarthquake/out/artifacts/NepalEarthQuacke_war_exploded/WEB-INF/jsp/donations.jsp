<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width,initial-scale = 1">
    <title>Nepal Earthquake-E.propagation </title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

    <script src="/resources/js/pie.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/resources/css/donations.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>
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
                <li class="active"><a href="donations">Donations</a></li>
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
                        <li><a href="damages">Damages</a></li>
                        <li  class="active"><a href="donations">Donations</a></li>
                        <li><a href="earthquake-response">Earthquake response</a></li>
                        <li><a href="map">InteractivMap</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <h1 style="font-family:verdana; color:hsl(0,0%,2%); font-size: 150%">Donations made by charitable organizations:<br><br></h1>
    <div style="background:rgba(255,255,255,0.5);padding:10px;">
        <div class="row">
            <div class="col-sm-8 col-md-8">
                <div class="chart-container">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
            <div class="col-sm-4">
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