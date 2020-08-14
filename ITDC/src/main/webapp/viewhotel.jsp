<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
marigin:0;
padding:0;
font-family:sans-serif;

background-color:cover;
}
</style>
</head>

<body>
<h2>Hotel List</h2>
 <c:forEach var="hotel" items="${list}">
    <fieldset style="width: 300px; height: 300px; border-radius: 10px; border: solid 2px black;">
        <form action = "userbookroom">
            <h2><input type="hidden" name="hotelname" value="${hotel.hotelname}">Hotel name : ${hotel.hotelname}</h2>
            <h4><input type="hidden" name="hoteladdress" value="${hotel.hoteladdress}">Hotel address : ${hotel.hoteladdress}</h4>
            <h4><input type="hidden" name="hotelphnno" value="${hotel.hotelphnno}">Hotel phone no : ${hotel.hotelphnno}</h4>
            <h4><input type="hidden" name="hotelrooms" value="${hotel.hotelrooms}">Rooms booked : ${hotel.hotelrooms}</h4>
            <h4><input type="hidden" name="hotelcost" value="${hotel.hotelcost}">Hotel cost : ${hotel.hotelcost}</h4>
            
            <input type ="submit" value="Book Now">
        </form>
      </fieldset> <br>
    </c:forEach>
    <input type="hidden">
</body>
</html>
