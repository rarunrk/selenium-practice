package com.zert.java.tutorial;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SwappingTest {
	
	@Test

	public void swap_test() {
	 Swapping result = Swapping.swap(5, 10);
     Assert.assertEquals(result.y, 5);
     Assert.assertEquals(result.x, 10);
	}

}
