package com.dbo;

import java.io.File;

public class Roominfo {

	private int roomno;
	private String roomtype;
	private int roomcap;
	private int roomcost;
	private int buildingno;
	private String roomimagename;
	public int getRoomno() {
		return roomno;
	}
	public void setRoomno(int roomno) {
		this.roomno = roomno;
	}
	public String getRoomtype() {
		return roomtype;
	}
	public void setRoomtype(String roomtype) {
		this.roomtype = roomtype;
	}
	public int getRoomcap() {
		return roomcap;
	}
	public void setRoomcap(int roomcap) {
		this.roomcap = roomcap;
	}
	public int getRoomcost() {
		return roomcost;
	}
	public void setRoomcost(int roomcost) {
		this.roomcost = roomcost;
	}
	public int getBuildingno() {
		return buildingno;
	}
	public void setBuildingno(int buildingno) {
		this.buildingno = buildingno;
	}
	public String getRoomimagename() {
		return roomimagename;
	}
	public void setRoomimagename(String roomimagename) {
		this.roomimagename = roomimagename;
	}

}
