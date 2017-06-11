/**
 * Created by Robert-PC on 6/10/2017.
 */
window.onload = pageLoad;
var strings = [ "asd", "asdas", "asdasd", "asdasd", "asd"];
var i = 0;


function pageLoad() {
    var startButton = document.getElementById("start");

    startButton.onclick = alertMe;
}

function alertMe() {
    var testingInterval = setInterval(function(){
        alert(strings[i]);
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
        zoom:5,
    };
    var map=new google.maps.Map(document.getElementById("googleMap"),mapProp);
}

