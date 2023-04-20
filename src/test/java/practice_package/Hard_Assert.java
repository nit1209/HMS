package practice_package;

import static org.testng.Assert.*;

import org.testng.annotations.Test;

public class Hard_Assert {

	@Test
	public void test1()
	{
		System.out.println("TS-1");
		System.out.println("TS-2");
		System.out.println("TS-3");
		assertEquals("lolwa", "lolw","dont know wat happend");
		System.out.println("TS-4");
		
	}

	@Test
	public void test2()
	{
		System.out.println("TS-5");
		System.out.println("TS-6");
		System.out.println("TS-7");
		assertFalse(false);
		System.out.println("TS-8");
		
	}
}
