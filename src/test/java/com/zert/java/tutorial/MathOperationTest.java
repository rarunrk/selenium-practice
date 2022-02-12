package com.zert.java.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathOperationTest {

	
	@Test
	public void sub_test() {
		int result = MathOperation.sub(10, 5);
		Assert.assertEquals(result, 5);
		
	}
	
	@Test
	public void multiply_test() {
		int result = MathOperation.multiply(5, 15); 
		Assert.assertEquals(result, 75);
	}
	@Test
	public void areaOfCircle_test() {
		double result = MathOperation.areaOfCircle(14); 
		Assert.assertEquals(result, 615.44);
				
		
	}
}
