<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width,initial-scale = 1">
    <title>Nepal Earthquake-Earthquake response </title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>
    <link rel="stylesheet" href="/resources/css/aftershocks.css" />
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
                <li ><a href="donations">Donations</a></li>
                <li class="active"><a href="aftershocks">Aftershocks</a></li>
                <li><a href="about">About</a></li>
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
                        <li><a href="donations">Donations</a></li>
                        <li  class="active"><a href="aftershocks">Aftershocks</a></li>
                        <li><a href="about">About</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <div>
        <br><br><br>
        <div id="googleMap"></div>
        <br><br>
        <button id = "animationButton" onclick="startAnimation()">Start</button>
        <table id="earthquakeTable" style="width:100%"></table>
    </div>


    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyCFc7pJusrQeKWR-7FpNZUQEa4GUDadyi8&callback=myMap"></script>
</div>
</body>
</html>