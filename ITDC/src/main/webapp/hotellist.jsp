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
background-color:skyblue;
background-color:cover;
}
</style>
</head>
<body>
<h2>Hotel List</h2>
<table border="1" style="padding: 0px;">

<tr>
<th>Hotel name</th>
<th>Hotel address</th>
<th>Hotel phone no</th>
<th>Hotel rooms</th>
<th>Hotel cost</th>

<th>
</tr>
 <c:forEach var="s" items="${list}">
         <tr> 
                <td><h4> <c:out value="${s.hotelname}"></c:out></h4> </td>
                <td><h4> <c:out value="${s.hoteladdress}"></c:out> </h4></td>
                <td><h4> <c:out value="${s.hotelphnno}"></c:out></h4></td> 
                <td><h4> <c:out value="${s.hotelrooms}"></c:out> </h4></td>
                <td><h4> <c:out value="${s.hotelcost}"></c:out></h4> </td>
               
         </tr>
        
        
    </c:forEach>
   </table>
</body>



</html>
