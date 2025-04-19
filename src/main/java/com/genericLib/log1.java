package com.genericLib;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

public class log1 {
private static	Logger logger=Logger.getLogger(log1.class.getName());
	public static void configure()
	{
	 	
		
	  PropertyConfigurator.configure("log4j.properties");
BasicConfigurator.configure();
}

	public static void info(String message){
		logger.info(message);
	}
	
	public static void warn(String message)
	{
		logger.warn(message);
	}
}
