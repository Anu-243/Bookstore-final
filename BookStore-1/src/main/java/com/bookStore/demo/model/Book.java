package com.bookStore.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Book 
{
	    @Id
	    private int Billno;
	    private String name;
	    private String Bookname;
	    private int quantity;
	    private int price;
		public int getBillno() {
			return Billno;
		}
		public void setBillno(int billno) {
			Billno = billno;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getBookname() {
			return Bookname;
		}
		public void setBookname(String bookname) {
			Bookname = bookname;
		}
		public int getQuantity() {
			return quantity;
		}
		public void setQuantity(int quantity) {
			this.quantity = quantity;
		}
		public int getPrice() {
			return price;
		}
		public void setPrice(int price) {
			this.price = price;
		}
}