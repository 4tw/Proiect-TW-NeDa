function initMap() {
    var mapOptions = {
        zoom: 8,
        center: new google.maps.LatLng(27.647084, 85.347761),
    };

    var map = new google.maps.Map(document.getElementById('map'), mapOptions);

    // Create the search box and link it to the UI element.
    var input = document.getElementById('pac-input');
    var searchBox = new google.maps.places.SearchBox(input);
    map.controls[google.maps.ControlPosition.TOP_LEFT].push(input);

    // Bias the SearchBox results towards current map's viewport.
    map.addListener('bounds_changed', function() {
        searchBox.setBounds(map.getBounds());
    });

    var markers = [];
    // Listen for the event fired when the user selects a prediction and retrieve
    // more details for that place.
    searchBox.addListener('places_changed', function() {
        var places = searchBox.getPlaces();

        if (places.length == 0) {
            return;
        }

        // Clear out the old markers.
        markers.forEach(function(marker) {
            marker.setMap(null);
        });
        markers = [];

        // For each place, get the icon, name and location.
        var bounds = new google.maps.LatLngBounds();
        places.forEach(function(place) {
            if (!place.geometry) {
                console.log("Returned place contains no geometry");
                return;
            }
            var icon = {
                url: place.icon,
                size: new google.maps.Size(71, 71),
                origin: new google.maps.Point(0, 0),
                anchor: new google.maps.Point(17, 34),
                scaledSize: new google.maps.Size(25, 25)
            };

            // Create a marker for each place.
            markers.push(new google.maps.Marker({
                map: map,
                icon: icon,
                title: place.name,
                position: place.geometry.location
            }));

            if (place.geometry.viewport) {
                // Only geocodes have viewport.
                bounds.union(place.geometry.viewport);
            } else {
                bounds.extend(place.geometry.location);
            }
        });
        map.fitBounds(bounds);
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







