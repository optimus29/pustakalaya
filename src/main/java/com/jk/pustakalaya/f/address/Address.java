package com.jk.pustakalaya.f.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.jk.pustakalaya.f.country.Country;
import com.jk.pustakalaya.f.user.User;

/**
 * Represents address.
 * @author Jitendra
 */

@Entity
@Table(name="Address")
public class Address {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String line1;

	private String line2;

	private String city;

	@Column(name="stateName")
	private String state;

	private String pin;


	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name="countryFk")
	private Country country;


	@ManyToOne
	@JoinColumn(name="userFk")
	private User user;


	public Address() {}


	public String getLine1() {
		return line1;
	}


	public void setLine1(String line1) {
		this.line1 = line1;
	}


	public String getLine2() {
		return line2;
	}


	public void setLine2(String line2) {
		this.line2 = line2;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	public String getState() {
		return state;
	}


	public void setState(String state) {
		this.state = state;
	}


	public String getPin() {
		return pin;
	}


	public void setPin(String pin) {
		this.pin = pin;
	}


	public String getCountry() {
		return country.getName();
	}


	public void setCountry(Country country) {
		this.country = country;
	}


	public int getId() {
		return id;
	}




	public User getUser() {
		return user;
	}


	public void setUser(User user) {
		this.user = user;
	}


	@Override
	public String toString() {
		return "Address [id=" + id + ", line1=" + line1 + ", line2=" + line2 + ", city=" + city + ", state=" + state
				+ ", pin=" + pin + ", country=" + country.getName() + "]";
	}
}
