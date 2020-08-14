package com.dxc;

import java.text.ParseException;
import java.util.List;



import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.dxc.pojos.Admin;
import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.services.AdminService;


@Controller
public class AdminController 
{
	AdminService adminsevice=new AdminService();
	String msg;
	
	
	@RequestMapping("/home")
	public String home() 
	{
		return "home";
	}
	
	
	
	
	
	@RequestMapping("/adminlogin")
	public String adminLogin(@ModelAttribute Admin admin,Model m)
	{
		String aid=admin.getAdminid();
		String apass=admin.getAdminpass();

		boolean b=adminsevice.adminLogin(aid,apass);
		if(b==true) 
		{
			return "adminmenu";
		}
		else 
		{	
            msg="Admin login successfull.";
			m.addAttribute("msg", msg);
			return "msg";
		}
	}
	
	
	
	
	
	
@RequestMapping("/addhotel")
public String addHotel(@ModelAttribute Hotel hotel,Model m) 
{
	boolean b=adminsevice.addHotel(hotel);
	if(b==true) 
	{
		msg="Hotel added successfully.";
	}
	else
	{
		msg="Please try again.";
	}
	m.addAttribute("msg", msg);
	return "msg";	
}





@RequestMapping("/showlisthotel")
public String showHotels(@ModelAttribute Hotel hotel,Model m) 
{
	List<Document> list=adminsevice.showHotels(hotel);
	m.addAttribute("list", list);
	return "hotellist";	
}






@RequestMapping("/dailybooking")
public String dailyBooking(@RequestParam String bookeddate,@ModelAttribute Booking booking,Model m) throws ParseException 
{	
	List<Document> list=adminsevice.dailyBooking(bookeddate,booking);
	m.addAttribute("list", list);
	return "dailybookinglist";
}





@RequestMapping("/approvecancelrequest")
public String cancelRequest(@ModelAttribute Booking booking, Model m) 
{
boolean b = adminsevice.cancelRequest(booking);
msg = "Booking cancelled.";
m.addAttribute("msg",msg);
return "msg";
}





@RequestMapping("/adminlogout")
public String logout() 
{
	return "home";
}
}
