package com.zert.java.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

@Test

public class AnimalTest {
	
	@Test
	public void eatsTest() {
		Animal ref = new Shark(); 
		 String result = ref.eats();
		 Assert.assertEquals(result, "All Sharks eats and swim");
		 		 
	}
}
