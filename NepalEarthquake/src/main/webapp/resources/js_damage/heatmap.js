function initMap() {
    var mapOptions = {
        zoom: 8,
        center: new google.maps.LatLng(27.647084, 85.347761),
    };

    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

    google.maps.event.addDomListener(window, "resize", function() {
        var center = map.getCenter();
        google.maps.event.trigger(map, "resize");
        map.setCenter(center);
    });



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
            opacity: 0.7,
            maxIntensity: 50000,
            intensity: 200
        });

        heatmap.setMap(map);

    });
    testing.open('GET', 'http://localhost:9999/housesDestroyed/short', true);
    testing.send();

}

function initMap1() {
    var mapOptions = {
        zoom: 8,
        center: new google.maps.LatLng(27.647084, 85.347761),
    };

    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

}







