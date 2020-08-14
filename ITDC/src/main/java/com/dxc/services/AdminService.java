package com.dxc.services;

import java.text.ParseException;
import java.util.List;



import org.bson.Document;

import com.dxc.dao.AdminDao;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;


public class AdminService {
	AdminDao adminDao=new AdminDao();

	public boolean adminLogin(String aid, String apass) {
		
		return adminDao.adminLogin(aid,apass);
	}

	public boolean addHotel(Hotel hotel) {
		
		return adminDao.addHotel(hotel);
	}

	
	public List<Document> showHotels(Hotel hotel) {
		return adminDao.showHotels(hotel);
	}

	public List<Document> dailyBooking(String bookeddate, Booking booking) throws ParseException {
		
		return adminDao.dailyBooking(bookeddate,booking);
	}

	public boolean cancelRequest(Booking booking) {
		
		return adminDao.cancelRequest(booking);
	}

}
