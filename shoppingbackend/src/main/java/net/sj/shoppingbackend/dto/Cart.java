package net.sj.shoppingbackend.dto;

import java.io.Serializable;

import javax.persistence.*;

@Entity
public class Cart implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	
	@Column(name="grand_total")
	private double grandTotal;
	@Column(name="cart_lines")
	private int cartLines;
	
	/*  -----------   */
	@OneToOne
	//@JoinColumn(name="uid") -- used set column explicitely
	private User user;
	
	
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	/*  -----------   */
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	
	public double getGrandTotal() {
		return grandTotal;
	}
	public void setGrandTotal(double grandTotal) {
		this.grandTotal = grandTotal;
	}
	public int getCartLines() {
		return cartLines;
	}
	public void setCartLines(int cartLines) {
		this.cartLines = cartLines;
	}
	
	
	
}
