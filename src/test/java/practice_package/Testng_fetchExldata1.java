package practice_package;

import org.testng.annotations.Test;

public class Testng_fetchExldata1 {
@Test(dataProviderClass =TestNg_storeddatafromexcel.class,dataProvider = "data1" )
public void getdata(String a,String b,String c,String d)
{
	System.out.println(a+b+c+d);
}

}
