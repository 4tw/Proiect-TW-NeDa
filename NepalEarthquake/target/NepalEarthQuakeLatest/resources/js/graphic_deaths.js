anychart.onDocumentReady(function () {
    // preluam datele
    var dataSet = anychart.data.set(getData());

    // cream harta cu informatii despre zonele din nepal
    map = anychart.map();

    map.geoData(anychart.maps.nepal);
    map.padding(0);
    var region_data;
    // alegem un titlu
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

    // add evenimente
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
        a[1]=(-1)*jsonData[i][1];
        a[2]=jsonData[i][2];
        json[i]=a;
    }
}
function  drawGraph( zone) {
    // creare chart
    var dataSet = anychart.data.set(json);

    // preluam prima valoare a json-ului si a doua
    var seriesData_1 = dataSet.mapAs({x: [0], value: [1]});

    // preluam prima valoare a json-ului si a treia
    var seriesData_2 = dataSet.mapAs({x: [0], value: [2]});

    chart = anychart.column();
    chart.animation(true);

    chart.title('No of deaths in ' + zone);
    chart.title().padding([0, 0, 10, 0]);
    chart.background('transparent');
    var series;

    // helper function to setup label settings for all series
    var setupSeries = function (series, name) {
        series.name(name);
        series.selectFill('#f48fb1 0.8')
            .selectStroke('2 #c2185b');
    };

    series = chart.column(seriesData_1);
    series.xPointPosition(0.45);
    series.name( 'Men');
    series.selectFill('#f48fb1 0.8')
        .selectStroke('2 #c2185b');

    series = chart.column(seriesData_2);
    series.xPointPosition(0.25);
    series.name('Women');
    series.selectFill('#f48fb1 0.8')
        .selectStroke('2 #c2185b');

    chart.barGroupsPadding(0.3);

    // format numbers in y axis label to match browser locale
    //chart.yAxis().labels().format('{%Value}{groupsSeparator: }');


    // turn on legend
    chart.legend()
        .enabled(true)
        .fontSize(13)
        .padding([0, 0, 20, 0]);

    chart.interactivity().hoverMode('single');

    chart.tooltip().format('{%Value}{groupsSeparator: }');
    // set container id for the chart
    document.getElementById('graphic').innerHTML = "";
    chart.container('graphic');

    chart.draw();
    var buttonJPG = document.getElementById("btnJPG");
    var buttonSVG = document.getElementById("btnSVG");
    var buttonPNG = document.getElementById("btnPNG");
// 3. Add event handler
    buttonJPG.addEventListener ("click", function (){chart.saveAsJpg({width: 360, height: 500, quality: 0.3, forceTransparentWhite: "false", filename: "Deaths"})});
    buttonSVG.addEventListener ("click", function (){chart.saveAsSvg({width: 360, height: 500, filename: 'Deaths'})});
    buttonPNG.addEventListener ("click", function (){chart.saveAsPng({width: 360, height: 500, quality: 0.3, filename: "Deaths"})});
}
