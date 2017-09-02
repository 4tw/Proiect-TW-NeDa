/**
 * Created by Robert-PC on 6/10/2017.
 */
var url = "http://localhost:9999/aftershocks/detailed";

function startAnimation() {
    var xhttp = new XMLHttpRequest();
    xhttp.addEventListener("load",function() {
        var currentDistrict = 0;
        var earthquakeData=JSON.parse(xhttp.responseText);
        showEarthquakeAftershocks(earthquakeData, currentDistrict);
    } );
    xhttp.open("GET", url, true);
    xhttp.send();


}

function showEarthquakeAftershocks(earthquakeData, currentDistrict){
    var mapOptions = {
        zoom: 7,
        center: new google.maps.LatLng(28.502943, 83.619921),
    };
    document.getElementById("googleMap").innerHTML = "";
    var map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);
    var earthquakeTable = document.getElementById("earthquakeTable");
    earthquakeTable.innerHTML = "";

    earthquakeTable.style.backgroundColor = "LightGreen";

    var header = earthquakeTable.createTHead();
    var row = header.insertRow(0);

    row.style.height = 100;
    row.style.backgroundColor = "LightBlue";
    var cell = row.insertCell(0);

    cell.innerHTML = "<b>District</b>";

    cell = row.insertCell(1);
    cell.innerHTML = "<b>Magnitude</b>";

    cell = row.insertCell(2);
    cell.innerHTML = "<b>Date</b>";

    cell = row.insertCell(3);
    cell.innerHTML = "<b>Hour</b>";

    earthquakeTable.style.backgroundColor = "gray";

    var startDrawingCircles = setInterval(function(){
        var earthquakeCircle = new google.maps.Circle({
            strokeColor: '#FF0000',
            strokeOpacity: 0.8,
            strokeWeight: 2,
            fillColor: '#E16D65',
            fillOpacity: 0,
            map: map,
            center: {lat : earthquakeData[currentDistrict][0], lng : earthquakeData[currentDistrict][1]},
            radius: 15000
        });

        var maxRadius = 100000;
        var changeCircleRadius = setInterval(function(){

            earthquakeCircle.setRadius(earthquakeCircle.getRadius() + 4000);

            if(earthquakeCircle.getRadius() > maxRadius){
                clearInterval(changeCircleRadius);
                earthquakeCircle.setRadius(5000);
                earthquakeCircle.fillOpacity = 1;
            }
        }, 125);

        createRow(earthquakeTable, earthquakeData, currentDistrict);

        currentDistrict = currentDistrict + 1;
        if(currentDistrict === earthquakeData.length){
            clearInterval(startDrawingCircles);
            currentDistrict = 0;
        }
    },3000);
}

function createRow(earthquakeTable, earthquakeData, currentDistrict) {
    var header = earthquakeTable.createTHead();
    var row = header.insertRow(currentDistrict+1);

    if(currentDistrict % 2 === 1){
        row.style.backgroundColor = "white";
    }

    row.style.height = 100;
    var cell = row.insertCell(0);

    cell.innerHTML = "<b>" + earthquakeData[currentDistrict][2] + "</b>";

    cell = row.insertCell(1);
    cell.innerHTML = "<b>" +  earthquakeData[currentDistrict][3] + "</b>";

    cell = row.insertCell(2);
    cell.innerHTML = "<b>" +  earthquakeData[currentDistrict][5] + "</b>";

    cell = row.insertCell(3);
    cell.innerHTML = "<b>" +  earthquakeData[currentDistrict][4] + "</b>";

}


function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(28.502943, 83.619921),
        zoom:5
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
