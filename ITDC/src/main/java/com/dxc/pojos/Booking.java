package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Booking 
{
@Id
private String sno;
private String userphnno;
private String username;
private String userid;
private String userrroms;
private String hotelname;
private String hoteladdress;
private String hotelphnno;
private String hotelrooms;
private double hotelcost;
private String fromdate;
private String todate;
private String bookeddate;
private String status;

public Booking() {
	
}


public Booking(String sno, String userphnno, String username, String userid, String userrroms, String hotelname,
		String hoteladdress, String hotelphnno, String hotelrooms, double hotelcost, String fromdate, String todate,
		String bookeddate, String status) {
	super();
	this.sno = sno;
	this.userphnno = userphnno;
	this.username = username;
	this.userid = userid;
	this.userrroms = userrroms;
	this.hotelname = hotelname;
	this.hoteladdress = hoteladdress;
	this.hotelphnno = hotelphnno;
	this.hotelrooms = hotelrooms;
	this.hotelcost = hotelcost;
	this.fromdate = fromdate;
	this.todate = todate;
	this.bookeddate = bookeddate;
	this.status = status;
}


public String getSno() {
	return sno;
}

public void setSno(String sno) {
	this.sno = sno;
}

public String getUserphnno() {
	return userphnno;
}

public void setUserphnno(String userphnno) {
	this.userphnno = userphnno;
}

public String getUsername() {
	return username;
}

public void setUsername(String username) {
	this.username = username;
}

public String getUserid() {
	return userid;
}

public void setUserid(String userid) {
	this.userid = userid;
}

public String getUserrroms() {
	return userrroms;
}

public void setUserrroms(String userrroms) {
	this.userrroms = userrroms;
}

public String getHotelname() {
	return hotelname;
}

public void setHotelname(String hotelname) {
	this.hotelname = hotelname;
}

public String getHoteladdress() {
	return hoteladdress;
}

public void setHoteladdress(String hoteladdress) {
	this.hoteladdress = hoteladdress;
}

public String getHotelphnno() {
	return hotelphnno;
}

public void setHotelphnno(String hotelphnno) {
	this.hotelphnno = hotelphnno;
}

public String getHotelrooms() {
	return hotelrooms;
}

public void setHotelrooms(String hotelrooms) {
	this.hotelrooms = hotelrooms;
}

public double getHotelcost() {
	return hotelcost;
}

public void setHotelcost(double hotelcost) {
	this.hotelcost = hotelcost;
}

public String getFromdate() {
	return fromdate;
}

public void setFromdate(String fromdate) {
	this.fromdate = fromdate;
}

public String getTodate() {
	return todate;
}

public void setTodate(String todate) {
	this.todate = todate;
}

public String getBookeddate() {
	return bookeddate;
}

public void setBookeddate(String bookeddate) {
	this.bookeddate = bookeddate;
}

public String getStatus() {
	return status;
}


public void setStatus(String status) {
	this.status = status;
}


@Override
public String toString() {
	return "Booking [sno=" + sno + ", userphnno=" + userphnno + ", username=" + username + ", userid=" + userid
			+ ", userrroms=" + userrroms + ", hotelname=" + hotelname + ", hoteladdress=" + hoteladdress
			+ ", hotelphnno=" + hotelphnno + ", hotelrooms=" + hotelrooms + ", hotelcost=" + hotelcost + ", fromdate="
			+ fromdate + ", todate=" + todate + ", bookeddate=" + bookeddate + ", status=" + status + "]";
}
}

