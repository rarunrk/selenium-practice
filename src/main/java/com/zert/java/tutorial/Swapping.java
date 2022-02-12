package com.zert.java.tutorial;


public class Swapping {
	
	int x ; 
	int y; 
	
	public static Swapping swap(int x , int y) {
		System.out.println("Before swapping" + x+y);
		x= x+y; 
		y = x-y; 
		x = x-y ; 
		System.out.println("after swapping "+ x+y);
		Swapping swapping = new Swapping();
		swapping.x=x;
		swapping.y=y;
		return swapping ; 
		
 }
}
