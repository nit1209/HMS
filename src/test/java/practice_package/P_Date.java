package practice_package;

import java.text.SimpleDateFormat;
import java.util.Date;

public class P_Date {

	public static void main(String[] args) {
		Date date = new Date();
		SimpleDateFormat DDformatter = new SimpleDateFormat("dd");
		SimpleDateFormat MMMformatter = new SimpleDateFormat("MMM");
		SimpleDateFormat MMMMMformatter = new SimpleDateFormat("MMMMM");
		SimpleDateFormat YYformatter = new SimpleDateFormat("yy");

		String dd = DDformatter.format(date);
		String mmm = MMMformatter.format(date);		
		String yy = YYformatter.format(date);
		String mmmmm = MMMMMformatter.format(date);

		System.out.println(dd+" "+mmmmm+" "+yy);
		
	}

}
