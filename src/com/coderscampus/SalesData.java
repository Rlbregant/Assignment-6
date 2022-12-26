package com.coderscampus;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SalesData {
	private static final String MODEL_3_FILE = "model3.csv";
	private static final String MODEL_S_FILE = "modelS.csv";
	private static final String MODEL_X_FILE = "modelX.csv";

	private List<Sale> model3Sales;
	private List<Sale> modelSSales;
	private List<Sale> modelXSales;

	public SalesData() {
		model3Sales = new ArrayList<>();
		modelSSales = new ArrayList<>();
		modelXSales = new ArrayList<>();
	}

	public void readData() throws IOException {
		readModel3Sales();
		readModelSSales();
		readModelXSales();
	}

	private void readModel3Sales() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(MODEL_3_FILE));
		String line = reader.readLine(); // skip the first line with the header

		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			String date = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			Sale sale = new Sale(date, "Model 3", quantity);
			model3Sales.add(sale);

		}
		reader.close();
	}

	private void readModelSSales() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(MODEL_S_FILE));
		String line = reader.readLine(); // skip the first line with the header

		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			String date = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			Sale sale = new Sale(date, "Model S", quantity);
			modelSSales.add(sale);
		}
		reader.close();
	}

	private void readModelXSales() throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(MODEL_X_FILE));
		String line = reader.readLine(); // skip the first line with the header

		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			String date = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			Sale sale = new Sale(date, "Model X", quantity);
			modelXSales.add(sale);
		}
		reader.close();
	}

	public List<Sale> getModel3Sales() {
		return model3Sales;
	}

	public List<Sale> getModelSSales() {
		return modelSSales;
	}

	public List<Sale> getModelXSales() {
		return modelXSales;
	}
}
