package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Hotel {
	@Id
private String hotelname;
private String hoteladdress;
private String hotelphnno;
private String hotelrooms;
private double hotelcost;

public Hotel() 
{
	
}

public Hotel(String hotelname, String hoteladdress, String hotelphnno, String hotelrooms, double hotelcost) {
	super();
	this.hotelname = hotelname;
	this.hoteladdress = hoteladdress;
	this.hotelphnno = hotelphnno;
	this.hotelrooms = hotelrooms;
	this.hotelcost = hotelcost;
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
@Override
public String toString() {
	return "Hotel [hotelname=" + hotelname + ", hoteladdress=" + hoteladdress + ", hotelphnno=" + hotelphnno
			+ ", hotelrooms=" + hotelrooms + ", hotelcost=" + hotelcost + "]";
}
}
