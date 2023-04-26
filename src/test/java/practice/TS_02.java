package practice;

import org.testng.annotations.Test;

public class TS_02 {
@Test(groups = "smoke")
public void test2()
{
	System.out.println("test-02----EXECUTED");
}

@Test(groups = "regression")
public void TS_03()
{
	System.out.println("test-03----EXECUTED");
}
}
