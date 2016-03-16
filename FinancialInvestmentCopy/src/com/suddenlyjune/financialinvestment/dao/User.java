package com.suddenlyjune.financialinvestment.dao;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class User {
	private int id;
	@Valid
	@Size(min = 1, max = 100, message = "Name must be between 1 to 100 characters.")
	private String name;

	@Size(min = 10, max = 100, message = "Address must be between 1 to 100 characters.")
	private String address;

	@Size(min = 1, max = 50, message = "City must be between 1 to 50 characters.")
	private String city;
	
	private String zip; 

	@NotNull
	@Pattern(regexp = ".*\\@.*\\..*", message = "This does not appear to be a valid email address.")
	private String email;

	@Size(min = 3, max = 25, message = "User name must be between 3 to 25 characters.")
	private String username;

	@Size(min = 3, max = 25, message = "password must be between 3 to 25 characters.")
	private String password;
	
	private boolean enabled;

	public User() {

	}



	public User(int id, String name, String address, String city, String zip, String email, String username,
			String password, boolean enabled) {
		super();
		this.id = id;
		this.name = name;
		this.address = address;
		this.city = city;
		this.zip = zip;
		this.email = email;
		this.username = username;
		this.password = password;
		this.enabled = enabled;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getZip() {
		return zip;
	}



	public void setZip(String zip) {
		this.zip = zip;
	}



	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}



	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", address=" + address + ", city=" + city + ", zip=" + zip
				+ ", email=" + email + ", username=" + username + ", password=" + password + ", enabled=" + enabled
				+ "]";
	}


}
