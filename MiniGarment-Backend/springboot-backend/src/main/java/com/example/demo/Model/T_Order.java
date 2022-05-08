package com.example.demo.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GenerationType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "orders")

public class T_Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long  id;
	
	@Column(name = "Date")
	private String date;
	
	@Column(name = "Supplier")
	private String supplier;
	
	@Column(name = "item_code")
	private String itemcode;
	
	@Column(name = "item_name")
	private String itemname;
	
	@Column(name = "quantity")
	private String qty;
	
	@Column(name = "unit_price")
	private String unitprice;
	
	@Column(name = "total_price")
	private String totalprice;
	
	public T_Order() {
		
	}
	
	public T_Order(String date, String supplier, String itemcode, String itemname, String qty, String unitprice,
			String totalprice) {
		super();
		this.date = date;
		this.supplier = supplier;
		this.itemcode = itemcode;
		this.itemname = itemname;
		this.qty = qty;
		this.unitprice = unitprice;
		this.totalprice = totalprice;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getSupplier() {
		return supplier;
	}
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	public String getItemcode() {
		return itemcode;
	}
	public void setItemcode(String itemcode) {
		this.itemcode = itemcode;
	}
	public String getItemname() {
		return itemname;
	}
	public void setItemname(String itemname) {
		this.itemname = itemname;
	}
	public String getQty() {
		return qty;
	}
	public void setQty(String qty) {
		this.qty = qty;
	}
	public String getUnitprice() {
		return unitprice;
	}
	public void setUnit(String unitprice) {
		this.unitprice = unitprice;
	}
	public String getTotalprice() {
		return totalprice;
	}
	public void setTotalprice(String totalprice) {
		this.totalprice = totalprice;
	}

}
