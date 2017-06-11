<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width,initial-scale = 1">
    <title>Nepal Earthquake-Damages </title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <link rel="stylesheet" href="/resources/css_damage/damages.css" />
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/js_damage/heatmap.js" type="text/javascript"> </script>

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
    <h1 style="font-family:verdana; background:rgba(255,255,255,0.5);padding:10px;color:black; font-size: 150%">A heatmap that shows the most affected areas by the 2015's earthquake:<br><br></h1>
        <div class="row">
            <div class="col-sm-6">
                <div id="map" style="width:940px;height:500px;background:yellow"></div>
            </div>
            <br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
        </div>
    </div>
</div>
</div>
</body>
</html>