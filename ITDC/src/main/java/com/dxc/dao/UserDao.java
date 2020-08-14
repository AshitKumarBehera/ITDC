package com.dxc.dao;

import java.util.ArrayList;
import java.util.List;

import org.bson.Document;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.dxc.pojos.User;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;

public class UserDao 
{
	MongoClient mongoclient = new MongoClient("localhost", 27017);
	MongoDatabase mongodatabase = mongoclient.getDatabase("tourism");

	
	
	
	
	public boolean newuserLogin(User user) 
	{
		MongoCollection<Document> collection = mongodatabase.getCollection("user");
		List<Document> list = collection.find().into(new ArrayList<>());

		String userphnno = user.getUserphnno();
		String username = user.getUsername();
		String userpass = user.getUserpass();

		for (Document d : list) 
		{
			String u = (String) d.get("userphnno");

			if (u.equals(userphnno)) 
			{
				return false;
			}
		}

		Document s1 = new Document();
		s1.append("userphnno", userphnno);
		s1.append("username", username);
		s1.append("userpass", userpass);
		collection.insertOne(s1);
		return true;
	}

	
	
	
	
	
	public boolean userLogin(String userphnno, String userpass) 
	{
		MongoCollection<Document> collection = mongodatabase.getCollection("user");
		List<Document> list = (List<Document>) collection.find().into(new ArrayList<>());

		FindIterable<Document> cursor = collection.find();
		MongoCursor<Document> itr = cursor.iterator();
		for (Document d1 : list) 
		{
			while (itr.hasNext()) 
			{
				Document d = itr.next();

				String u = (String) d.get("userphnno");
				String p = (String) d.get("userpass");

				if (userphnno.equals(u) && userpass.equals(p)) 
				{
					return true;
				}
			}
		}
		return false;
	}

	
	
	
	
	

	public List<Document> viewHotels(Hotel hotel) 
	{
		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel");
		List<Document> list=new ArrayList<>();
		FindIterable<Document> cursor=collection.find();
		MongoCursor<Document> itr=cursor.iterator();
		while(itr.hasNext()) 
		{
			Document d=itr.next();
			list.add(d);
		}
		return list;
	}

	
	
	
	
	
	public boolean confirmBooking(Booking booking, Hotel hotel, User user, String un, String id, String r,String phn) 
	{
		Document d2 = new Document();
		d2.append("hotelrooms", r);
		MongoCollection<Document> collection = mongodatabase.getCollection("hotel");

		List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
		FindIterable<Document> cursor = collection.find();

		MongoCursor<Document> itr = cursor.iterator();
		
		while (itr.hasNext()) 
		{
			Document d = itr.next();
			String dbName = d.getString("hotelname");

			if (hotel.getHotelname().equals(dbName)) 
			{

				int userGivenRooms = Integer.parseInt(r);
				int hotelRooms = Integer.parseInt(d.getString("hotelrooms"));

				int finalRooms = hotelRooms - userGivenRooms;
				String fr = Integer.toString(finalRooms);
				
				Document o = new Document();
				o.append("hotelname", d.getString("hotelname"));

				Document u = new Document();
				u.append("$set", new Document("hotelrooms", fr));
				collection.updateOne(o, u);
				cursor = collection.find();
				itr = cursor.iterator();
				while (itr.hasNext()) 
				{
					list.add(itr.next());
				}
			}
		}

		MongoCollection<Document> collection1 = mongodatabase.getCollection("booking");

		List<Document> list1 = (List<Document>) collection.find().into(new ArrayList<>());

		String userphn=phn;
		String userid=booking.getUserid();
		String userrroms=booking.getUserrroms();
		String hotelname=hotel.getHotelname();
		String hoteladdress=hotel.getHoteladdress();
		String hotelphnno=hotel.getHotelphnno();
		double totcost=booking.getHotelcost();
		String fromdate=booking.getFromdate();
		String todate=booking.getTodate();
		String bookeddate=booking.getBookeddate();
		String status="booked";
		Document d1 = new Document();
		d1.append("userphnno", userphn);
		d1.append("userid", userid);
		d1.append("userrroms", r);
		d1.append("hotelname", hotelname);
		d1.append("hoteladdress", hoteladdress);
		d1.append("hotelphnno", hotelphnno);
		d1.append("hotelcost", totcost);
		d1.append("fromdate", fromdate);
		d1.append("todate", todate);
		d1.append("bookeddate", bookeddate);
		d1.append("status", status);

		collection1.insertOne(d1);
		return true;
	}

	
	
	
	
	
	public List<Document> bookingHistory(Booking booking, String phn) 
	{
		  Document d2 = new Document();
	        d2.append("userphnno", phn);

	        MongoCollection<Document> collection = mongodatabase.getCollection("booking");

	        List<Document> list = (List<Document>) collection.find(d2).into(new ArrayList<>());
	        FindIterable<Document> cursor = collection.find();

	        MongoCursor<Document> itr = cursor.iterator();
	        
	        while (itr.hasNext()) 
	        {
	            Document d = itr.next();
	            String d1 = d.getString("userphnno");

	            if (phn == d1) 
	            {
	                list.add(d2);
	            }
	        }
	        return list;
	}

	
	
	
	
	
	public boolean cancelRequest(Booking booking) 
	{
	    MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
        List<Document> documents = mongoCollection.find().into(new ArrayList<>());
        
        Document oldstatus=new Document();
        oldstatus.append("status", "booked");
        
        Document newstatus=new Document();
        newstatus.append("$set", new Document("status", "requested"));
        
        mongoCollection.updateOne(oldstatus, newstatus);
        return true;
    }
}