package practice_package;




import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Soft_assert {
	SoftAssert sa=	new SoftAssert();
	@Test
	public void test1()
	{
		System.out.println("TS-1");
		System.out.println("TS-2");
		System.out.println("TS-3");
		sa.assertEquals(2, 1);
		System.out.println("TS-4");
		sa.assertAll();
	}

	@Test
	public void test2()
	{
		System.out.println("TS-5");
		System.out.println("TS-6");
		System.out.println("TS-7");
		sa.assertEquals("TY", "ty");
		System.out.println("TS-8");
		sa.assertAll("check here wat u have written");
	}
}
