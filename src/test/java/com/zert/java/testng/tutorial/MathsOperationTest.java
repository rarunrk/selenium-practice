package com.zert.java.testng.tutorial;

import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class MathsOperationTest {
	MathsOperation mathOperation;
	
	@BeforeClass
	public void  setMathObject() {
		mathOperation = new MathsOperation();
	}
	
	@Test
	public void add_integer_test() {
		int result = mathOperation.add(5, 7);
		Assert.assertEquals(result, 12);
	}
	
	@Test
	public void add_double_test() {
		double result = mathOperation.add(5.5, 7.7);
		Assert.assertEquals(result, 13.2);
	}

}
