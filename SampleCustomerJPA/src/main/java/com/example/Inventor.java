package com.example;

public class Inventor {
	private String name;
	private String address;
	private String country;

	public Inventor() {
		super();
	}

	public Inventor(String name, String address, String country) {
		super();
		this.name = name;
		this.address = address;
		this.country = country;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
