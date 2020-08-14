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
background-color:#33FFF7;
background-color:cover;
}
</style>
</head>
<body>
<form action="approvecancelrequest">
<table border="1" style="padding: 0px;">
<tr>
<th>User id</th>
<th>User phone no</th>
<th>Hotel name</th>
<th>Hotel address</th>
<th>Hotel phone no</th>
<th>No of rooms alloted</th>
<th>Hotel cost per day</th>
<th>From date</th>
<th>To Date</th>
<th>Booking Date</th>
<th>Booking status</th>
<th>Cancel log</th>
 

 </tr>
<c:forEach var="s" items="${list}">
                 <tr>
                           <td><input type="hidden" name="userid" value="${s.userid}">${s.userid}</td>
                    <td><input type="hidden" name="userphnno" value="${s.userphnno}">${s.userphnno}</td>
                    <td><input type="hidden" name="hotelname" value="${s.hotelname}">${s.hotelname}</td>
                    <td><input type="hidden" name="hoteladdress" value="${s.hoteladdress}">${s.hoteladdress}</td>
                    <td><input type="hidden" name="hotelphnno" value="${s.hotelphnno}">${s.hotelphnno}</td>
                    <td><input type="hidden" name="userrroms" value="${s.userrroms}">${s.userrroms}</td>
                    <td><input type="hidden" name="hotelcost" value="${s.hotelcost}">${s.hotelcost}</td>
                    <td><input type="hidden" name="fromdate" value="${s.fromdate}">${s.fromdate}</td>
                    <td><input type="hidden" name="todate" value="${s.todate}">${s.todate}</td>
                    <td><input type="hidden" name="bookeddate" value="${s.bookeddate}">${s.bookeddate}</td>
                    <td><input type="hidden" name="status" value="${s.status}">${s.status}</td>
                   <td><button id="firstbutton" onclick="disablefirstbutton">Cancel</button></td>
                              
                        </tr>            
                    </c:forEach> 
                         
 </table>

</form>
</body>
</html>