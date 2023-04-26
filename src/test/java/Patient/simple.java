package Patient;

import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class simple {

@Parameters("browser")
@Test
public void m1(String browser)
{
	System.out.println("my browser"+ browser);
}




}
