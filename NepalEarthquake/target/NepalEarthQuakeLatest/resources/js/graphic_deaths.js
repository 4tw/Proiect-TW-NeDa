anychart.onDocumentReady(function () {
    // create data set
    var dataSet = anychart.data.set(getData());

    // create map chart
    map = anychart.map();

    map.geoData(anychart.maps.nepal);
    map.padding(0);
    var lat_data, long_data, region_data;
    // create map title
    map.title().enabled(true).padding([20, 0, 20, 0]).text("Click on a zone for generate your graph.");
    map.background('transparent');
    //create choropleth series
    var series = map.choropleth(dataSet);
    series.tooltip()
        .title(false)
        .separator(false)
        .format(function () {
            return '<span>' + this.name + '</span><br/>' +
                '<span style="font-size: 14px; color: black">id: ' + this.id + '</span>';
        });
    series.selectionMode("none")
        .labels(false)
        .fill('#F7F7F7')
        .hoverFill('#64b5f6')
        .stroke('#b2b7b7')
        .tooltip()
        .useHtml(true)
        .padding([8, 13, 10, 13])
        .fontSize(16);

    //set series geo id field settings
    series.geoIdField("id");

    // add pointsHover listener to get hovered region
    map.listen('pointsHover', function (evt) {
        if (evt.seriesStatus[0].points[0]) {
            region_data = evt.seriesStatus[0].points[0].properties.name;
        }
        else region_data = undefined;
    });

    map.listen('click', function () {
        get_data(region_data);
    });
    // set container id for the chart
    map.container('container');

    // initiate chart drawing
    map.draw();
});

function getData() {
    return [
        {'id': 'NP.PM'},
        { "id": "NP.MP"},
        {"id": "NP.747"},
        {"id": "NP.748"},
        {"id": "NP.749"},
        {"id": "NP.SP"},
        {"id": "NP.751"},
        {"id": "NP.MM"},
        {"id": "NP.753"},
        {"id": "NP.754"},
        {"id": "NP.PW"},
        {"id": "NP.756"},
        { "id": "NP.757"},
        { "id": "NP.354"}
    ]
}
function get_data(zone){
    var url='http://localhost:9999/deadMen/zone/'+zone;
    var xhttp = new XMLHttpRequest();
    xhttp.addEventListener("load",function() {
        var ourData=JSON.parse(xhttp.responseText);
        get_dataGraphic(ourData);
        drawGraph(zone);
    } );
    xhttp.open("GET", url, true);
    xhttp.send();
}
var json=[];
function get_dataGraphic(jsonData)
{   json=[];
    for(var i=0;i<jsonData.length;i++)
    {var a=[];
        a[0]=jsonData[i][0];
        a[1]=jsonData[i][2];
        a[2]=jsonData[i][1];
        json[i]=a;
    }
}
function  drawGraph( zone) {
    alert(json);
    // create pie chart with passed data
    var dataSet = anychart.data.set(json);
    // map data for the first series, take x from the zero column and value from the first column of data set
    var seriesData_1 = dataSet.mapAs({x: [0], value: [1]});
    // map data for the second series, take x from the zero column and value from the second column of data set
    var seriesData_2 = dataSet.mapAs({x: [0], value: [2]});
    // create bar chart
    chart = anychart.bar();

    // turn on chart animation
    chart.animation(true);

    // set padding
    chart.padding([10, 20, 5, 20]);
    chart.background('transparent');

    // force chart to stack values by Y scale.
    chart.yScale().stackMode('value');

    // format y axis labels so they are always positive
    chart.yAxis().labels().format(function () {
        return Math.abs(this.value).toLocaleString();
    });

    // allow labels to overlap
    chart.xAxis(0).overlapMode("allowOverlap");

    // turn on extra axis for the symmetry
    chart.xAxis(1)
        .enabled(true)
        .orientation('right')
        .overlapMode("allowOverlap");

    // set chart title text
    chart.title('No of deaths in '+zone);

    chart.interactivity().hoverMode('byY');

    chart.tooltip()
        .title(false)
        .separator(false)
        .displayMode('separated')
        .positionMode('point')
        .useHtml(true)
        .fontSize(15)
        .offsetX(5)
        .offsetY(0)
        .format(function () {
            return '<span style="color: #262129"></span>' + Math.abs(this.value).toLocaleString();
        });

    // temp variable to store series instance
    var series;

    // create first series with mapped data
    series = chart.bar(seriesData_1);
    series.tooltip()
        .position('right')
        .anchor('left');
    series.color("#327793");
    series.name('Male');

    // create second series with mapped data
    series = chart.bar(seriesData_2);
    series.tooltip()
        .position('left')
        .anchor('right');
    series.color("#9a7d7d");
    series.name('Womens');

    // turn on legend
    chart.legend()
        .enabled(true)
        .inverted(true)
        .fontSize(15)
        .padding([10, 10, 20, 10]);
    chart.height(350);
    chart.width(450);
    // set container id for the chart
    document.getElementById('graphic').innerHTML = "";
    chart.container('graphic');
    // initiate chart drawing
    chart.draw();
    var buttonJPG = document.getElementById("btnJPG");
    var buttonSVG = document.getElementById("btnSVG");
    var buttonPNG = document.getElementById("btnPNG");
// 3. Add event handler
    buttonJPG.addEventListener ("click", function (){chart.saveAsJpg({width: 360, height: 500, quality: 0.3, forceTransparentWhite: "false", filename: "Deaths_injured"})});
    buttonSVG.addEventListener ("click", function (){chart.saveAsSvg({width: 360, height: 500, filename: 'custom_name'})});
    buttonPNG.addEventListener ("click", function (){chart.saveAsSvg({width: 360, height: 500, quality: 0.3, filename: "custom_name"})});
}
