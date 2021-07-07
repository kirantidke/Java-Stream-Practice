package com.bridgelabz.stream;

import java.util.*;

import java.util.stream.Collectors;

class Product {
	String name;
	float price;
	int id;

	public Product(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
}

public class JavaStreams {

	public static void main(String[] args) {
		List<Product> list = new ArrayList<Product>();

		// adding products to list

		list.add(new Product(1, "HP Laptop", 25000f));
		list.add(new Product(2, "Dell Laptop", 30000f));
		list.add(new Product(3, "Lenevo Laptop", 28000f));
		list.add(new Product(4, "Sony Laptop", 28000f));
		list.add(new Product(5, "Apple Laptop", 90000f));

		// creating product pricelist

		// List<Float> priceList = new ArrayList<Float>();

		/**
		 * ADDING WITHOUT STREAM adding laptops having price less 30000 into this list
		 * 
		 * for(Product product:list) if(product.price < 30000) {
		 * priceList.add(product.price);
		 * 
		 * } System.out.println("price list = " + priceList);
		 */

		
		// USING STREAMS
		
		List<Float> priceList = list.stream().filter(p -> p.price > 30000)// filtering data
				.map(p -> p.price) // fetching price
				.collect(Collectors.toList()); // collecting as list
		System.out.println(priceList);
	}

}
