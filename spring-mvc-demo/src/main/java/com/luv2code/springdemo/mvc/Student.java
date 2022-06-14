package com.luv2code.springdemo.mvc;

import java.util.HashMap;

//import  org.springframework.stereotype.Component;

//@Component
public class Student {
	private String firstName;
	private String lastName;
	private HashMap<String, String> countryOptions;
	private String country;
	private String favouriteLanguage;
	private String[] operatingSystems;

	public String[] getOperatingSystems() {
		return operatingSystems;
	}

	public void setOperatingSystems(String[] operatingSystems) {
		this.operatingSystems = operatingSystems;
	}

	public String getFavouriteLanguage() {
		return favouriteLanguage;
	}

	public void setFavouriteLanguage(String favouriteLanguage) {
		this.favouriteLanguage = favouriteLanguage;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Student() {

		countryOptions = new HashMap<>();
		countryOptions.put("IND", "India");
		countryOptions.put("USA", "Ameraica");
		countryOptions.put("RUS", "Russia");
		countryOptions.put("CHN", "China");
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getCountry() {
		return country;
	}

	public HashMap<String, String> getCountryOptions() {
		return countryOptions;
	}

}
