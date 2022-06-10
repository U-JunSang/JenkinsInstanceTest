package com.min.edu.dtos;

public class InfoUser {

	private String address;
	private String phone;
	private String name;
	public InfoUser() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InfoUser(String address, String phone, String name) {
		super();
		this.address = address;
		this.phone = phone;
		this.name = name;
	}
	@Override
	public String toString() {
		return "InfoUser [address=" + address + ", phone=" + phone + ", name=" + name + "]";
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
