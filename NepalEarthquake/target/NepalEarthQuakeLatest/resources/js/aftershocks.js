/**
 * Created by Robert-PC on 6/10/2017.
 */
window.onload = pageLoad;

function pageLoad() {
    var startButton = document.getElementById("start");

    startButton.onclick = alertMe;
}

function alertMe() {
    setInterval(function(){
        alert("hi");
    },200);
}

function myMap() {
    var mapProp= {
        center:new google.maps.LatLng(51.508742,-0.120850),
        zoom:5,
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

