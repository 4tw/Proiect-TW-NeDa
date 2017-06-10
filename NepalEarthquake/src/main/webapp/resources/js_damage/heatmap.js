function initMap() {
    var mapOptions = {
        zoom: 8,
        center: new google.maps.LatLng(27.647084, 85.347761),
    };

    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

    var testing = new XMLHttpRequest();

    function returnResults(line){
        return {location : new google.maps.LatLng(line[0], line[1]), weight : line[2] };
    };

    testing.addEventListener('load', function () {
        var ourData = JSON.parse(testing.responseText);
        var myHeatMap = ourData.map(returnResults);
        console.log(myHeatMap);

        var heatmap;
        heatmap = new google.maps.visualization.HeatmapLayer({
            data: myHeatMap,
            radius: 50,
            opacity: 0.5,
            maxIntensity: 10000
        });

        heatmap.setMap(map);

    });
    testing.open('GET', 'http://localhost:9999/housesDestroyed/short', true);
    testing.send();

}
function addScript( url, callback ) {
    var script = document.createElement( 'script' );
    if( callback ) script.onload = callback;
    script.type = 'text/javascript';
    script.src = url;
    document.body.appendChild( script );
}

function loadMapsAPI() {
    addScript( 'https://maps.googleapis.com/maps/api/js?key=AIzaSyDX9nXsXlEVuMa1TJmsOaY7nj9M7jOGMj4&libraries=visualization&callback=initMap');
}

window.onload = loadMapsAPI;





