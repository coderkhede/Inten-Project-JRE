package com.dbo;

public class BookingInfo {
private String Username;
private int roomno;
private int buildingno;
private String bookfrom;
private String bookto;
private int noofcostumer;
private String email;
private String phno;
private int bookingid;
private int price;

public int getPrice() {
	return price;
}
public void setPrice(int price) {
	this.price = price;
}
public int getBookingid() {
	return bookingid;
}
public void setBookingid(int bookingid) {
	this.bookingid = bookingid;
}
public String getUsername() {
	return Username;
}
public void setUsername(String username) {
	Username = username;
}
public int getRoomno() {
	return roomno;
}
public void setRoomno(int roomno) {
	this.roomno = roomno;
}
public int getBuildingno() {
	return buildingno;
}
public void setBuildingno(int buildingno) {
	this.buildingno = buildingno;
}
public String getBookfrom() {
	return bookfrom;
}
public void setBookfrom(String bookfrom) {
	this.bookfrom = bookfrom;
}
public String getBookto() {
	return bookto;
}
public void setBookto(String bookto) {
	this.bookto = bookto;
}
public int getNoofcostumer() {
	return noofcostumer;
}
public void setNoofcostumer(int noofcostumer) {
	this.noofcostumer = noofcostumer;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getPhno() {
	return phno;
}
public void setPhno(String phno) {
	this.phno = phno;
}

}
