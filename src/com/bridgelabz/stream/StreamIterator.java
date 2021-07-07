package com.bridgelabz.stream;
import java.util.stream.Collectors;  
import java.util.*;

class Products {
	int id;
	String name;
	float price;

	public Products(int id, String name, float price) {
		this.id = id;
		this.name = name;
		this.price = price;
	}
	
	 public int getId() {  
	        return id;  
	    }  
	    public String getName() {  
	        return name;  
	    }  
	    public float getPrice() {  
	        return price;  
	    }  
}

public class StreamIterator {
	public static void main(String[] args) {
		List<Products> productsList = new ArrayList<Products>();

		// Adding Products
		productsList.add(new Products(1, "HP Laptop", 25000f));
		productsList.add(new Products(2, "Dell Laptop", 30000f));
		productsList.add(new Products(3, "Lenevo Laptop", 28000f));
		productsList.add(new Products(4, "Sony Laptop", 28000f));
		productsList.add(new Products(5, "Apple Laptop", 90000f));

		// This is more compact approach for filtering data
		productsList.stream().filter(product -> product.price == 30000)
				.forEach(product -> System.out.println(product.name));

		Float totalPrice = productsList.stream().map(product -> product.price).reduce(0.0f,
				(sum, price) -> sum + price); // accumulating price
		System.out.println(totalPrice);
		
		// More precise code
		//float totalPrice2 = productsList.stream().map(product -> product.price).reduce(0.0f, Float::sum); // accumulating
		//System.out.println(totalPrice2);
		
		//using collectors
		
		  double totalPriceCol = productsList.stream()  
                  .collect(Collectors.summingDouble(product->product.price));  
		  System.out.println("total price using collectors= "+totalPriceCol);  
		  
		  // max() method to get max Product price     
	        Products productA = productsList.stream().max((product1, product2)->product1.price > product2.price ? 1: -1).get();    
	        System.out.println("maxium price laptop is = "+productA.name+" And price="+productA.price);    
	        
	     // min() method to get min Product price    
	        Products productB = productsList.stream().min((product1, product2)->product1.price > product2.price ? 1: -1).get();    
	        System.out.println("min price laptop is= "+productB.name+" And price= "+productB.price);   
	        
	        // count number of products based on the filter  
	        
	        long count = productsList.stream()  
	                    .filter(product->product.price<30000)  
	                    .count();  
	        System.out.println("products having price less than 3000 is = "+count);  
	
	     // Converting product List into Set  
	        
	        Set<Float> productPriceList =   
	            productsList.stream()  
	            .filter(product->product.price < 30000)   // filter product on the base of price  
	            .map(product->product.price)  
	            .collect(Collectors.toSet());   // collect it as Set(remove duplicate elements)  
	        System.out.println("products in Set = "+productPriceList);  
	        
	     // Converting Product List into a Map  
	        Map<Integer,String> productPriceMap =   
	            productsList.stream()  
	                        .collect(Collectors.toMap(p->p.id, p->p.name));  
	              
	       System.out.println("products in map= "+productPriceMap);  
	       
	       //by refering methods
	       
	       List<Float> productPriceListNew =   
	                productsList.stream()  
	                            .filter(p -> p.price > 30000) // filtering data  
	                            .map(Products::getPrice)         // fetching price by referring getPrice method  
	                            .collect(Collectors.toList());  // collecting as list  
	        System.out.println(productPriceListNew);  
	}
}