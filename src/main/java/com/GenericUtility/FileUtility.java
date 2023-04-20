package com.GenericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class FileUtility 
{
	/**
	 * this is used to read data from property file with key and returns the value
	 * @param key
	 * @return
	 * @throws Throwable
	 */
	public String readDataFromPropertyFile(String key) throws Throwable 
	{
		FileInputStream fis = new FileInputStream(IpathConstants.FilePath);
		Properties pObj = new Properties();
		pObj.load(fis);
		String value = pObj.getProperty(key);
		return value;
	}




}
