package RavishKiReport;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class Simple {
@Parameters("browser")
@Test
public void mI(String browser)
{
	System.out.println("Kuch bhi");
}
	

}
