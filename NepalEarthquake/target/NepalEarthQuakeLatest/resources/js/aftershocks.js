/**
 * Created by Robert-PC on 6/10/2017.
 */
var url = "http://localhost:9999/aftershocks/detailed";

function alertMe() {
    var xhttp = new XMLHttpRequest();
    xhttp.addEventListener("load",function() {
        var i = 0;
        var ourData=JSON.parse(xhttp.responseText);
        startAlerting(ourData, i);
    } );
    xhttp.open("GET", url, true);
    xhttp.send();


}

function startAlerting(strings, i){
    var mapOptions = {
        zoom: 7,
        center: new google.maps.LatLng(28.502943, 83.619921),
    };
    document.getElementById("googleMap").innerHTML = "";
    var map = new google.maps.Map(document.getElementById('googleMap'), mapOptions);

    var cityCircle = new google.maps.Circle({
        strokeColor: '#FF0000',
        strokeOpacity: 0.8,
        strokeWeight: 2,
        fillColor: '#E16D65',
        fillOpacity: 0,
        map: map,
        center: {lat : 28.502943, lng : 83.619921},
        radius: 15000
    });

    var maxRadius = 100000;
    var changeCircleRadius = setInterval(function(){

        cityCircle.setRadius(cityCircle.getRadius() + 3000);

        if(cityCircle.getRadius() > maxRadius){
            clearInterval(changeCircleRadius);
            cityCircle.setRadius(5000);
            cityCircle.fillOpacity = 1;
        }
    }, 50);


    var testingInterval = setInterval(function(){
        //alert(strings[i]);
        i = i+1;
        if ( i === strings.length){
            i = 0;
            clearInterval(testingInterval);
        }
    },2000);
}

function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(28.502943, 83.619921),
        zoom:5
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
