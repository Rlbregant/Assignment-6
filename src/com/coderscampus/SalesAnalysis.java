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

	private SalesData salesData;

	public SalesAnalysis(SalesData salesData) {
		this.salesData = salesData;
	}

	public void generateModel3Report() {
		List<Sale> model3Sales = salesData.getModel3Sales();

		// Group the sales by year and month
		Map<YearMonth, Integer> monthlySales = model3Sales.stream().collect(Collectors
				.groupingBy(sale -> YearMonth.parse(sale.date, DATE_FORMAT), Collectors.summingInt(Sale::getQuantity)));

		System.out.println("Model 3 Yearly Sales Report");
		System.out.println("---------------------------");
		// Print the sales by year
		Map<Integer, Integer> yearlySales = monthlySales.entrySet().stream().collect(
				Collectors.groupingBy(entry -> entry.getKey().getYear(), Collectors.summingInt(Map.Entry::getValue)));
		for (Map.Entry<Integer, Integer> entry : yearlySales.entrySet()) {
			System.out.println(entry.getKey() + " -> " + entry.getValue());
			
		}
		System.out.println("");
		// Find the best and worst month
		Sale bestMonth = model3Sales.stream().max(Comparator.comparingInt(Sale::getQuantity))
				.orElseThrow(() -> new RuntimeException("No sales data found"));
		System.out.println("The best month for Model 3 was: " + bestMonth.date);

		Sale worstMonth = model3Sales.stream().min(Comparator.comparingInt(Sale::getQuantity))
				.orElseThrow(() -> new RuntimeException("No sales data found"));
		System.out.println("The worst month for Model 3 was: " + worstMonth.date);
		System.out.println("");
	}

	public void generateModelSReport() {
		  List<Sale> modelSSales = salesData.getModelSSales();

		  // Group the sales by year and month
		  Map<YearMonth, Integer> monthlySales = modelSSales.stream()
		      .collect(Collectors.groupingBy(sale -> YearMonth.parse(sale.date, DATE_FORMAT),
		                                     Collectors.summingInt(Sale::getQuantity)));

		  System.out.println("Model S Yearly Sales Report");
		  System.out.println("---------------------------");
		  // Print the sales by year
		  Map<Integer, Integer> yearlySales = monthlySales.entrySet().stream()
		      .collect(Collectors.groupingBy(entry -> entry.getKey().getYear(),
		                                     Collectors.summingInt(Map.Entry::getValue)));
		  for (Map.Entry<Integer, Integer> entry : yearlySales.entrySet()) {
		    System.out.println(entry.getKey() + " -> " + entry.getValue());
		  }
		  System.out.println("");
		  // Find the best and worst month
		  Sale bestMonth = modelSSales.stream().max(Comparator.comparingInt(Sale::getQuantity))
		      .orElseThrow(() -> new RuntimeException("No sales data found"));
		  System.out.println("The best month for Model 3 was: " + bestMonth.date);

		  Sale worstMonth = modelSSales.stream().min(Comparator.comparingInt(Sale::getQuantity))
		      .orElseThrow(() -> new RuntimeException("No sales data found"));
		  System.out.println("The worst month for Model 3 was: " + worstMonth.date);
		  System.out.println("");
		}


	public void generateModelXReport() {
		  List<Sale> modelXSales = salesData.getModelSSales();

		  // Group the sales by year and month
		  Map<YearMonth, Integer> monthlySales = modelXSales.stream()
		      .collect(Collectors.groupingBy(sale -> YearMonth.parse(sale.date, DATE_FORMAT),
		                                     Collectors.summingInt(Sale::getQuantity)));

		  System.out.println("Model X Yearly Sales Report");
		  System.out.println("---------------------------");
		  // Print the sales by year
		  Map<Integer, Integer> yearlySales = monthlySales.entrySet().stream()
		      .collect(Collectors.groupingBy(entry -> entry.getKey().getYear(),
		                                     Collectors.summingInt(Map.Entry::getValue)));
		  for (Map.Entry<Integer, Integer> entry : yearlySales.entrySet()) {
		    System.out.println(entry.getKey() + " -> " + entry.getValue());
		  }
		  System.out.println("");
		  // Find the best and worst month
		  Sale bestMonth = modelXSales.stream().max(Comparator.comparingInt(Sale::getQuantity))
		      .orElseThrow(() -> new RuntimeException("No sales data found"));
		  System.out.println("The best month for Model X was: " + bestMonth.date);

		  Sale worstMonth = modelXSales.stream().min(Comparator.comparingInt(Sale::getQuantity))
		      .orElseThrow(() -> new RuntimeException("No sales data found"));
		  System.out.println("The worst month for Model X was: " + worstMonth.date);
		  System.out.println("");
		}

	public static void main(String[] args) throws IOException {
		SalesData salesData = new SalesData();
		salesData.readData();

		SalesAnalysis salesAnalysis = new SalesAnalysis(salesData);
		salesAnalysis.generateModel3Report();
		salesAnalysis.generateModelSReport();
		salesAnalysis.generateModelXReport();
	}
}
