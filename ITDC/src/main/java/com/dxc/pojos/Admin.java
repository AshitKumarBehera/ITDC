package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Admin {
	@Id
private String adminid;
private String adminname;
private String adminpass;

public Admin() {
	
}
public Admin(String adminid, String adminname, String adminpass) {
	
	this.adminid = adminid;
	this.adminname = adminname;
	this.adminpass = adminpass;
}
public String getAdminid() {
	return adminid;
}
public void setAdminid(String adminid) {
	this.adminid = adminid;
}
public String getAdminname() {
	return adminname;
}
public void setAdminname(String adminname) {
	this.adminname = adminname;
}
public String getAdminpass() {
	return adminpass;
}
public void setAdminpass(String adminpass) {
	this.adminpass = adminpass;
}
@Override
public String toString() {
	return "Admin [adminid=" + adminid + ", adminname=" + adminname + ", adminpass=" + adminpass + "]";
}
}
