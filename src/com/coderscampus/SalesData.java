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

	final List<Sales> model3Sales;
	final List<Sales> modelSSales;
	final List<Sales> modelXSales;

	public SalesData() {
		model3Sales = new ArrayList<>();
		modelSSales = new ArrayList<>();
		modelXSales = new ArrayList<>();
	}

	public void readData() throws IOException {
		readSales(MODEL_3_FILE, "Model 3", model3Sales);
		readSales(MODEL_S_FILE, "Model S", modelSSales);
		readSales(MODEL_X_FILE, "Model X", modelXSales);
	}

	private void readSales(String file, String model, List<Sales> salesList) throws IOException {
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line = reader.readLine(); // skip the first line with the header

		while ((line = reader.readLine()) != null) {
			String[] parts = line.split(",");
			String date = parts[0];
			int quantity = Integer.parseInt(parts[1]);
			Sales sale = new Sales(date, model, quantity);
			salesList.add(sale);
		}
		reader.close();
	}

	public List<Sales> getModel3Sales() {
		return model3Sales;
	}

	public List<Sales> getModelSSales() {
		return modelSSales;
	}

	public List<Sales> getModelXSales() {
		return modelXSales;
	}
}