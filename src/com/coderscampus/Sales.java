package com.coderscampus;

public class Sales {
	String date;
	String model;
	int quantity;

	public Sales(String date, String model, int quantity) {
		this.date = date;
		this.model = model;
		this.quantity = quantity;
	}

	public String getDate() {
		return date;
	}

	public String getModel() {
		return model;
	}

	public int getQuantity() {
		return quantity;
	}
}