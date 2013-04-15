var lastElement = null;
function get(name) {
    if (name = (new RegExp('[?&]' + encodeURIComponent(name) + '=([^&]*)')).exec(location.search))
        return decodeURIComponent(name[1]);
}
function initialize() {
    var latitud = get("latitud");
    var longitud = get("longitud");
    var titulo = get("titulo");
    var myLatlng = new google.maps.LatLng(latitud, longitud);
    var mapOptions = {
        zoom: 15,
        center: myLatlng,
        mapTypeId: google.maps.MapTypeId.ROADMAP
    };
    var map = new google.maps.Map(document.getElementById('map-canvas'), mapOptions);

    var marker = new google.maps.Marker({
        position: myLatlng,
        map: map,
        title: titulo
    });
}
google.maps.event.addDomListener(window, 'load', initialize);