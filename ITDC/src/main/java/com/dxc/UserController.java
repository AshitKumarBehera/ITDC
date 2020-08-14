package com.dxc;

import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.Date;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.bson.Document;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;
import com.dxc.services.UserService;

@Controller
public class UserController 
{
	UserService usersevice=new UserService();
	Hotel hotel;
	String msg;
	String userid;
	String userrroms;
	String fromdate;
	String todate;
	String bookeddate;
	Booking booking=new Booking();
	
	private String p;
	private String uphn = null;
    private String uname = null;
    private String ro = null;

    
    
    
	@RequestMapping("/newuserlogin")
	public String newuserLogin(@ModelAttribute User user,Model m) 
	{
		this.p=user.getUserphnno();
		System.out.println(user.getUserphnno());
		boolean b=usersevice.newuserLogin(user);
		if(b==true) 
		{
			msg="New user added successfully.";
		}
		else 
		{
			msg="Please try again.";
		}
		m.addAttribute("msg", msg);
		return "msg";
	}
	
	
	
	
	
	@RequestMapping("/userlogin")
	public String userLogin(@ModelAttribute User user,Model m,HttpSession session)
	{
		String userphnno=user.getUserphnno();
		session.setAttribute("userphnno", userphnno);
		String userpass=user.getUserpass();
		boolean b=usersevice.userLogin(userphnno,userpass);
		if(b==true) 
		{
			return "usermenu";
		}
		else 
		{
			msg="Invalid login credentials.";
			m.addAttribute("msg", msg);
			return "msg";
		}
	}
	
	
	
	
	
	@RequestMapping("/viewhotels")
	public String viewHotels(@ModelAttribute Hotel hotel,Model m) 
	{
		List<Document> list=usersevice.viewHotels(hotel);
		m.addAttribute("list", list);
		return "viewhotel";
	}
	
	
	
	
	
	@RequestMapping("/userbookroom")
	public String bookAccomodation(@ModelAttribute Hotel hotel,Model m) 
	{
		this.hotel=hotel;
		m.addAttribute("hotel", hotel);
		return "bookroom";
	}
	
	
	
	
	
	
	@RequestMapping("/book")
	public String bookHotel(@ModelAttribute User user,@RequestParam String userid,@RequestParam String fromdate,@RequestParam String todate,@RequestParam String bookeddate,@RequestParam String userrroms,Model m) throws ParseException 
	{
		this.userid=userid;
		this.fromdate=fromdate;
		this.todate=todate;
		this.bookeddate=bookeddate;
		this.userrroms=userrroms;
        this.ro=userrroms;
		int givenrooms=Integer.parseInt(userrroms);
		int allrooms=Integer.parseInt(hotel.getHotelrooms());
		System.out.println(givenrooms);
		System.out.println(allrooms);

		booking.setUserid(userid);
		booking.setFromdate(fromdate);
		booking.setTodate(todate);
		booking.setBookeddate(bookeddate);
		booking.setUserrroms(userrroms);
      

		SimpleDateFormat sdformat = new SimpleDateFormat("MM-dd-yyyy");
		Date from = sdformat.parse(fromdate);
		Date to = sdformat.parse(todate);
		Date sys = sdformat.parse(bookeddate);
		if (from.compareTo(sys) >= 0 && to.compareTo(sys) >= 0) 
		{
			if (to.compareTo(from) >= 0) 
			{
				if ((givenrooms <= allrooms)) 
				{
					m.addAttribute("user", user);
					m.addAttribute("hotel", hotel);
					m.addAttribute("booking", booking);
					return "confirmbooking";
				}
				else 
				{
					msg = "Rooms not available.";
					m.addAttribute("msg", msg);
				}
			} 
			else 
			{
				msg = "Invalid to date.";
				m.addAttribute("msg", msg);
			}
		} 
		else 
		{
			msg = "Invalid from date.";
			m.addAttribute("msg", msg);
		}
		return "msg";
	}

	
	
	
	
@RequestMapping("/confirm")
public String confirmBooking(HttpSession session,@ModelAttribute Booking booking,@ModelAttribute Hotel hotel,@ModelAttribute User user,Model model) 
{
	String un = uname;
    String id = uphn;
    String r = ro;
    String phn=(String) session.getAttribute("userphnno");
	boolean b=usersevice.confirmBooking(booking,hotel,user,un,id,r,phn);
	if(b==true) 
	{	
	msg="Booking confirmed.";
	model.addAttribute("msg", msg);
	}
	return "msg";
}






@RequestMapping("/bookingsHistory")
public String bookingHistory(HttpSession session,@ModelAttribute Booking booking, Model m) 
{
	 String phn=(String) session.getAttribute("userphnno");
    List<Document> list = usersevice.bookingHistory(booking, phn);
    m.addAttribute("list", list);
    return "history";
}






@RequestMapping("/cancelrequest")
public String cancelRequest(@ModelAttribute Booking booking, Model m) 
{
    boolean b = usersevice.cancelRequest(booking);
    if(b==true) 
    {
    msg = "Requested booking cancellation.";
    m.addAttribute("msg", msg);
    }
    return "msg";
}





@RequestMapping("/userlogout")
public String logout() 
{
	return "home";
}
}

