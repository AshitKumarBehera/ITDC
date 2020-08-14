<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
body{

}
</style>

</head>

<body onload="addDate();">
<center>
<table>
<tr>
<form action="book">
<tr><td>Enter user id        -<input type="text" name="userid"></td></tr>
<tr><td>Enter from date       -<input type="text" name="fromdate" placeholder="dd-mm-yyyy"></td></tr>
<tr><td>Enter to date         -<input type="text" name="todate" placeholder="dd-mm-yyyy"></td></tr>
<tr><td>No of rooms      -<input type="text" name="userrroms"></td><br>
<tr><td>Booking date  -<input type ="text"  id="date" name="bookeddate" readonly="readonly"></td> </tr>
    

 <tr><td><center><input type="submit" value="Book Now"> </center></td></tr>
 

</form>
</tr>
</table>
</center>

 <script>
        function addDate() {
            date = new Date();
            var month = date.getMonth() + 1;
            var day = date.getDate();
            var year = date.getFullYear();

 

            if (document.getElementById('date').value == '') {
                document.getElementById('date').value = day + '-' + month + '-'
                        + year;
            }
        }
    </script>



</body>
</html>