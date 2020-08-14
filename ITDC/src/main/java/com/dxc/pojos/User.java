package com.dxc.pojos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class User {
@Id
private String userphnno;
private String username;
private String userpass;

public User() {
	
}

public User(String userphnno, String username, String userpass) {
	
	this.userphnno = userphnno;
	this.username = username;
	this.userpass = userpass;
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

public String getUserpass() {
	return userpass;
}

public void setUserpass(String userpass) {
	this.userpass = userpass;
}

@Override
public String toString() {
	return "User [userphnno=" + userphnno + ", username=" + username + ", userpass=" + userpass + "]";
}


}
