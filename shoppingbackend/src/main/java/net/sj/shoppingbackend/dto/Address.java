package net.sj.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.*;

import org.hibernate.validator.constraints.NotBlank;

@Entity
public class Address  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="address_line_one")
	@NotBlank(message="Please Enter address line one!")
	private String addressLineOne;
	@Column(name="address_line_two")
	@NotBlank(message="Please Enter address line two!")
	private String addressLineTwo;
	@NotBlank(message="Please Enter city name!")
	private String city;
	@NotBlank(message="Please Enter state name!")
	private String state;
	@NotBlank(message="Please Enter country name!")
	private String country;
	@Column(name="postal_code")
	@NotBlank(message="Please Enter postal code of your city!")
	private String postalCode;
	
	private boolean shipping;
	private boolean billing;
	
	/*  ------------  */
	@ManyToOne
	private User user;
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	/*  ------------  */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getAddressLineOne() {
		return addressLineOne;
	}
	public void setAddressLineOne(String addressLineOne) {
		this.addressLineOne = addressLineOne;
	}
	public String getAddressLineTwo() {
		return addressLineTwo;
	}
	public void setAddressLineTwo(String addressLineTwo) {
		this.addressLineTwo = addressLineTwo;
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
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public boolean isShipping() {
		return shipping;
	}
	public void setShipping(boolean shipping) {
		this.shipping = shipping;
	}
	public boolean isBilling() {
		return billing;
	}
	public void setBilling(boolean billing) {
		this.billing = billing;
	}
	@Override
	public String toString() {
		return "Address [id=" + id + ", addressLineOne=" + addressLineOne + ", addressLineTwo=" + addressLineTwo
				+ ", city=" + city + ", state=" + state + ", country=" + country + ", postalCode=" + postalCode
				+ ", shipping=" + shipping + ", billing=" + billing + ", user=" + user + "]";
	}
	
	
	
}
