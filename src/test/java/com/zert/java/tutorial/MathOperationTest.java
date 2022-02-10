package com.zert.java.tutorial;

import org.testng.Assert;
import org.testng.annotations.Test;

public class MathOperationTest {

	
	@Test
	public void add_test() {
		int result = MathOperation.sub(10, 5);
		Assert.assertEquals(result, 5);
	}
}
