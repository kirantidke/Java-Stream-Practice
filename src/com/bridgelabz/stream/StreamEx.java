package com.bridgelabz.stream;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.ArrayList;
public class StreamEx {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> list1 = new ArrayList<>();
		List<Integer> list2 = new ArrayList<>();
		List<Integer> list3 = new ArrayList<>();
		
		list1.add(10);
		list1.add(23);
		list1.add(35);
		list1.add(40);
		list1.add(50);
		System.out.println(list1);
		list2.add(2);
		list2.add(4);
		list2.add(50);
		list2.add(21);
		list2.add(22);
		System.out.println(list2);
		
		list3.add(23);
		list3.add(47);
		list3.add(505);
		list3.add(215);
		list3.add(224);
		System.out.println(list3);
		
		//without stream adding even numbers from list1 to lestEven
		
		List<Integer> listEven = new ArrayList<>();
		for(Integer i:list1) {
			if(i%2 == 0) {
				listEven.add(i);
			}
		}
		System.out.println("List1 = "+list1);
		System.out.println("ListEven = "+listEven);
		
		//using Streams
		/**
		Stream<Integer> stream = list1.stream();
		List<Integer> newList = stream.filter(i->i%2 == 0).collect(collectors.toList());
		System.out.println(newList);
		*/
		
		List<Integer> newList = list1.stream().filter(i->i%2 == 0).collect(Collectors.toList());
		System.out.println("Even list="+newList);
	}
	
		
}
