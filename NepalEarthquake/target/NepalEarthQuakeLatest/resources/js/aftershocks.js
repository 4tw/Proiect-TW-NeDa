/**
 * Created by Robert-PC on 6/10/2017.
 */
var url = "http://localhost:9999/aftershocks/detailed";
window.onload = pageLoad;


function pageLoad() {
    var startButton = document.getElementById("start");

    var xhttp = new XMLHttpRequest();
     //var ourData=JSON.parse(xhttp.responseText);

}

function alertMe() {
    strings = ["asd", "Asd", "asda", "asdasd"];

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

    var testingInterval = setInterval(function(){
        console.log(strings[i]);
        i = i+1;
        if ( i === strings.length){
            i = 0;
            clearInterval(testingInterval);
        }
    },2000);
}

function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(51.508742,-0.120850),
        zoom:5
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}
