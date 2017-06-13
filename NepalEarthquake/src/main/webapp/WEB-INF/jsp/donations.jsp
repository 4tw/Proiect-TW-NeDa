<!DOCTYPE html>
<html lang = "en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width = device-width,initial-scale = 1">
    <title>Nepal Earthquake-E.propagation </title>
    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="/resources/js/FileSaver.js" type="text/javascript"></script>
    <script src="/resources/js/canvas-toBlob.js" type="text/javascript"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script src="/resources/js/pie.js" type="text/javascript"></script>
    <link rel="stylesheet" href="/resources/css/donations.css" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/Chart.js/2.6.0/Chart.min.js"></script>


</head>
<body>
<div class="container-fluid">
    <div class="hidden-xs">
        <nav id="nav1" class="navbar navbar-inverse navbar-static-top" >
            <div class="navbar-header">
                <a class="navbar-brand" href="index">Nepal Earthquake</a>
            </div>
            <ul class="nav navbar-nav navbar-right">
                <li ><a href="index">Home</a></li>
                <li ><a href="deaths">Deaths</a></li>
                <li ><a href="damages">Damages</a></li>
                <li class="active"><a href="donations">Donations</a></li>
                <li><a href="aftershocks">Aftershocks</a></li>
                <li><a href="about">About</a></li>
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
                        <li><a href="aftershocks">Aftershocks</a></li>
                        <li><a href="about">About</a></li>
                    </ul>
                </li>
            </ul>
        </nav>
    </div>
    <h1>Donations made by charitable organizations:<br><br></h1>
    <div id="mydiv">
        <div class="row" id="row1">
            <div class="col-sm-8 col-md-8">
                <div id="chart" class="chart-container">
                    <canvas id="myChart"></canvas>
                </div>
            </div>
            <div class="col-sm-4">
                <br><br>
                <form class="form-inline">
                    <div class="form-group">
                        <p>Select the desired chart type.</p>
                        <br>
                        <label for="sel2">Chart Type:</label>
                        <select class="form-control" id="sel2" onchange="getSelectValue();">
                            <option value="pie" selected="selected">Pie Chart</option>
                            <option value="horizontalBar">Bar Chart</option>
                        </select>
                        <br><br>
                    </div>
                </form>
                <br><br>
                <p>Select the format you want to download the requested information.</p>
                <br>
                <form class="form-inline">
                    <div class="form-group">
                        <label for="sel3">Save chart as:</label>
                        <select id="sel3" class="form-control">
                            <option value="png" selected="selected">PNG</option>
                            <option value="jpg">JPG</option>
                            <option value="svg">SVG</option>
                        </select>
                        <br><br>

                        <button id="saveButton" type="button" class="btn btn-primary" onclick="saveFunction()">Download</button>

                    </div>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>