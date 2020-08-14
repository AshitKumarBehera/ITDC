package com.dxc.services;

import java.util.List;

import org.bson.Document;

import com.dxc.dao.UserDao;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;

public class UserService {
	UserDao userDao=new UserDao();

	public boolean newuserLogin(User user) {
		
		return userDao.newuserLogin(user);
	}

	public boolean userLogin(String userphnno, String userpass) {
		
		return userDao.userLogin(userphnno,userpass);
	}

	public List<Document> viewHotels(Hotel hotel) {
		
		return userDao.viewHotels(hotel);
	}

	public boolean confirmBooking(Booking booking, Hotel hotel, User user, String un, String id, String r,String phn) {
		
		return userDao.confirmBooking(booking,hotel,user,un,id,r,phn);
	}

	public List<Document> bookingHistory(Booking booking, String phn) {
		
		return userDao.bookingHistory(booking,phn);
	}

	public boolean cancelRequest(Booking booking) {
		
		return userDao.cancelRequest(booking);
	}

	

	
}
