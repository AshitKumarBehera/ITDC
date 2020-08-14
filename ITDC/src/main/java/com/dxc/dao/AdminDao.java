package com.dxc.dao;

import java.text.ParseException;
import java.util.ArrayList;

import java.util.List;

import org.bson.Document;

import com.dxc.pojos.Booking;
import com.dxc.pojos.Hotel;
import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;




public class AdminDao 
{
	MongoClient mongoclient=new MongoClient("localhost",27017);
	MongoDatabase mongodatabase=mongoclient.getDatabase("tourism");

	
	
	
	
	public boolean adminLogin(String aid, String apass) 
	{
		MongoCollection<Document>  collection=mongodatabase.getCollection("admin");
		List<Document> list=(List<Document>) collection.find().into(new ArrayList<>());
		for (Document d : list) 
		{
			String u=(String) d.get("adminid");
			String p=(String) d.get("adminpass");
			if(aid.equals(u)&&apass.equals(p))
			{
				return true;
			}
		}
		return false;
	}
	
	
	
	

	public boolean addHotel(Hotel hotel) 
	{
		MongoCollection<Document>  collection=mongodatabase.getCollection("hotel");
		List<Document> list= collection.find().into(new ArrayList<>());

		String hotelname=hotel.getHotelname();
		String hoteladdress=hotel.getHoteladdress();
		String hotelphnno=hotel.getHotelphnno();
		String hotelrooms=hotel.getHotelrooms();
		double hotelcost=hotel.getHotelcost();

		for (Document d : list) 
		{
			Document s1=new Document();
			s1.append("hotelname", hotelname);
			s1.append("hoteladdress", hoteladdress);
			s1.append("hotelphnno", hotelphnno);
			s1.append("hotelrooms", hotelrooms);
			s1.append("hotelcost", hotelcost);

			collection.insertOne(s1);

			return true;
		}
		return false;
	}

	
	
	
	
	
	public List<Document> showHotels(Hotel hotel) 
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
	
	
	
	
	

	public List<Document> dailyBooking(String bookeddate, Booking booking) throws ParseException 
	{
		MongoCollection<Document> collection=mongodatabase.getCollection("booking");
		Document s1=new Document();       
	    s1.append("bookeddate", bookeddate);
		FindIterable<Document> cursor=collection.find();   
		MongoCursor<Document> itr=cursor.iterator();
	    cursor=collection.find(s1);
	    List<Document> list=new ArrayList<>();
	    while(itr.hasNext())
	    {
	    	Document d=itr.next();
	    	System.out.println(d);
	    	list.add(d);
	    }
	    return list;
	}

	
	
	
	
	
	
	
	public boolean cancelRequest(Booking booking) 
	{  	   
		MongoCollection<Document> mongoCollection = mongodatabase.getCollection("booking");
        List<Document> documents = mongoCollection.find().into(new ArrayList<>());
        Document oldstatus=new Document();
        oldstatus.append("status", "requested");
        
        Document newstatus=new Document();
        newstatus.append("$set", new Document("status", "cancelled"));
        
        mongoCollection.updateOne(oldstatus, newstatus);
        
        return true;
	}
}

