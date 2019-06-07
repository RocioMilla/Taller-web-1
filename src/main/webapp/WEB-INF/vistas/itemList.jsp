<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Rocio
  Date: 01/06/2019
  Time: 2:26
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
	
		<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
		<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
		<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
		<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
 <script src="http://maps.google.com/maps/api/js?key=AIzaSyCiIDP3P5IqtJ4LQGy2--zrhbtCsXJGpjI&sensor=false" 
          type="text/javascript"></script>
	</head>
	<body>
	
	  <div id="map" style="width: 600px; height: 300px;"></div>
<script type="text/javascript">
 
  var jsontext = '${jsonString}';


  var locations = JSON.parse(jsontext);



    var map = new google.maps.Map(document.getElementById('map'), {
      zoom: 10,
      center: new google.maps.LatLng(-34.7504785, -58.5846362),
      mapTypeId: google.maps.MapTypeId.ROADMAP
    });

    var infowindow = new google.maps.InfoWindow();

    var marker, i;

    for (i = 0; i < locations.length; i++) {  
      marker = new google.maps.Marker({
        position: new google.maps.LatLng(locations[i]["latitude"], locations[i]["longitude"]),
        map: map
      });

      google.maps.event.addListener(marker, 'click', (function(marker, i) {
        return function() {
          infowindow.setContent(locations[i]["name"]);
          infowindow.open(map, marker);
        }
      })(marker, i));
    }
  </script>
		<div class="container">
			<br>
				<c:choose>
    			<c:when test="${empty items}">
        			<h4><span>No hay resultados</span></h4>
    			</c:when>
    			<c:otherwise>
        			<c:forEach items="${items}"  var="item">
        				<div id="itemId${item.id}" class="card text-white bg-info mb-3" style="max-width: 20rem;">
  							<div class="card-header">Producto #${item.brand}</div>
  			
  							</div>
					
 					</c:forEach>
 					
 					<c:forEach items="${comercios}"  var="item">
        				<div id="itemId${item.id}" class="card text-white bg-info mb-3" style="max-width: 20rem;">
  							<div class="card-header">Comercios #${item.name}</div>
  							<div class="card-body">
    							<h5 class="card-title">Comercio: <span class="text-capitalize">${item.name}</span></h5>
    							<p class="card-text">
    								Distancia: <span>Kms</span>
    							</p>
  							</div>
						</div>
 					</c:forEach>
    			</c:otherwise>
				</c:choose>
					</div>
		</div>
	</body>
</html>
