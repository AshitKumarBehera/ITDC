<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style type="text/css">
body{
marigin:0;
padding:0;
font-family:sans-serif;

background-color:aqua;
}
</style>
</head>
<body>
<center>
<form action="confirm">
    
 <h2><input type="hidden" name="hotelname" value="${hotel.hotelname}">Hotel name:${hotel.hotelname}<br></h2>
<h4><input type="hidden" name="hoteladdress" value="${hotel.hoteladdress}">Hotel address:${hotel.hoteladdress}<br></h4>
<h4><input type="hidden" name="hotelphnno" value="${hotel.hotelphnno}">Hotel phone no:${hotel.hotelphnno}<br></h4>
<h4><input type="hidden" name="userrroms" value="${booking.hotelrooms}">Rooms booked:${booking.userrroms}<br></h4>

   
   
   
    <c:set var="hotelcost" value="${hotel.hotelcost}"></c:set>       
    <c:set var="userrroms" value="${booking.userrroms}"></c:set>   
    <c:set var="totalcost" value="${userrroms * hotelcost}"></c:set>   
    <c:set var="userid" value="${booking.userid} "></c:set>
    <c:set var="fromdate" value="${booking.fromdate} "></c:set>
    <c:set var="todate" value="${booking.todate} "></c:set>
    <c:set var="bookeddate" value="${booking.bookeddate} "></c:set>

    <h4><input type="hidden" name="hotelcost" value="${totalcost}">Hotel cost per day: ${totalcost}</h4>
    <h4><input type="hidden" name="userid" value="${booking.userid}"> User id :${booking.userid} </h4>
    <h4><input type="hidden" name="fromdate" value="${booking.fromdate}">From date: ${booking.fromdate} </h4>
    <h4><input type="hidden" name="todate" value="${booking.todate }"> To date :${booking.todate } </h4>
    <h4><input type="hidden" name="bookeddate" value="${booking.bookeddate}">Booking date : ${booking.bookeddate}  </h4>
   
    <input type="submit">
 </form>
 </center>
</body>
</html>