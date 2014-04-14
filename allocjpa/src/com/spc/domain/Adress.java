package com.spc.domain;

import javax.persistence.Embeddable;

@Embeddable
public class Adress {

	private String street;
    private String city;
    private String zipCode;
	
    public String getStreet() {
		return street;
	}
	public String getCity() {
		return city;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
}
