package com.coderscampus;

import java.io.IOException;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SalesAnalysis {
	private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("MMM-yy");

	public void generateReport(String model, List<Sales> sales, SalesData salesData) {
		// Group the sales by year and month
		Map<YearMonth, Integer> monthlySales = sales.stream().collect(Collectors.groupingBy(
				sale -> YearMonth.parse(sale.date, DATE_FORMAT), Collectors.summingInt(Sales::getQuantity)));

		System.out.println(model + " Yearly Sales Report");
		System.out.println("---------------------------");
		// Print the sales by year
		Map<Integer, Integer> yearlySales = monthlySales.entrySet().stream().collect(
				Collectors.groupingBy(entry -> entry.getKey().getYear(), Collectors.summingInt(Map.Entry::getValue)));
		for (Map.Entry<Integer, Integer> entry : yearlySales.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
		}
		System.out.println();
		// Find the best and worst month
		Sales bestMonth = sales.stream().max(Comparator.comparingInt(Sales::getQuantity))
				.orElseThrow(() -> new RuntimeException("No sales data found"));
		System.out.println("The best month for " + model + " was: " + bestMonth.date);

		Sales worstMonth = sales.stream().min(Comparator.comparingInt(Sales::getQuantity))
				.orElseThrow(() -> new RuntimeException("No sales data found"));
		System.out.println("The worst month for " + model + " was: " + worstMonth.date);
		System.out.println();
	}

	public static void main(String[] args) throws IOException {
		SalesData salesData = new SalesData();
		salesData.readData();

		SalesAnalysis analysis = new SalesAnalysis();
		analysis.generateReport("Model 3", salesData.getModel3Sales(), salesData);
		analysis.generateReport("Model S", salesData.getModelSSales(), salesData);
		analysis.generateReport("Model X", salesData.getModelXSales(), salesData);
	}
}