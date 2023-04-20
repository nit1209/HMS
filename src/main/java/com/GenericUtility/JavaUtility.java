package com.GenericUtility;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
	/**
	 * 1.his method is to generate the random number 
	 * 2.generate the system date 
	 * @return
	 */
	
	//for generating the random
	public int random() {
		Random ran = new Random();
		int random = ran.nextInt(1000);
		return random;
	}
	
	//get the system date
	public String getSystemDate() {
		Date dt = new Date();
		String date = dt.toString();
		return date;
	}
	
	//change format of date
	public String formatSystemdate() {
		SimpleDateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh-mm-ss");
		Date dt = new Date();
		String getDateAndTime = dateformat.format(dt);
		return getDateAndTime;
		
	}
	
	
	
}
