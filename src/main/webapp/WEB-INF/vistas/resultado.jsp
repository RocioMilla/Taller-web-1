<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
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

<h3>productos encontrados </h3>
<div id="tablaLista">
	<table class="table table-bordered table-hover " >
		<tr>
		
			<th>marca</th>
		
		
		</tr>

		<c:forEach items="${listaDeProductos}" var="item">
		<tr>

			<td>${item.brand}</td>
			
		</tr>
		</c:forEach>
	</table>

</div>

<h3>comercios encontrados </h3>
	<table class="table table-bordered table-hover " >
		<tr>

			<th>marca</th>
	

		</tr>

		<c:forEach items="${comercios}" var="item">
		<tr>
			<td>${item.name}</td>
		
		</tr>
		</c:forEach>
	</table>
	

</body>
</html>