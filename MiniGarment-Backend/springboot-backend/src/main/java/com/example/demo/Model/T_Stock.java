package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "stocks")

public class T_Stock {
	
	@Id
	@Column(name = "item_code")
	private String itemcode;
	
	@Column(name = "fabric_type")
	private String fabrictype;
	
	@Column(name = "Colour")
	private String colour;
	
	@Column(name = "quantity")
	private int qty;
	
	@Column(name = "received_Qty")
	private int receivedqty;
	
	@Column(name = "used_Qty")
	private int usedqty;
	
	@Column(name = "damaged_Qty")
	private int damagedqty;
	
	@Column(name = "return_Qty")
	private int returnqty;
	
	@Column(name = "Price")
	private String price;
	
	public T_Stock() {
		
	}
	
	
	public T_Stock(String fabrictype, String colour, int qty, int receivedqty, int usedqty, int damagedqty,
			int returnqty, String price) {
		super();
		this.fabrictype = fabrictype;
		this.colour = colour;
		this.qty = qty;
		this.receivedqty = receivedqty;
		this.usedqty = usedqty;
		this.damagedqty = damagedqty;
		this.returnqty = returnqty;
		this.price = price;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getFabrictype() {
		return fabrictype;
	}
	public void setFabrictype(String fabrictype) {
		this.fabrictype = fabrictype;
	}
	public String getColour() {
		return colour;
	}
	public void setColour(String colour) {
		this.colour = colour;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	public int getReceivedqty() {
		return receivedqty;
	}
	public void setReceivedqty(int receivedqty) {
		this.receivedqty = receivedqty;
	}
	public int getUsedqty() {
		return usedqty;
	}
	public void setUsedqty(int usedqty) {
		this.usedqty = usedqty;
	}
	public int getDamagedqty() {
		return damagedqty;
	}
	public void setDamagedqty(int damagedqty) {
		this.damagedqty = damagedqty;
	}
	public int getReturnqty() {
		return returnqty;
	}
	public void setReturnqty(int returnqty) {
		this.returnqty = returnqty;
	}
	public String getPrice() {
		return price;
	}
	public void setPrice(String price) {
		this.price = price;
	}
	
	
	
	

}