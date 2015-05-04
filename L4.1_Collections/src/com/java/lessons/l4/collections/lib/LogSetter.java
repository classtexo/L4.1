package com.java.lessons.l4.collections.lib;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;
import java.util.logging.Logger;

public class LogSetter {
	
	public static Logger setLogger(Logger logIn)  {
		
		logIn.setLevel(Level.FINE);
		//logIn.addHandler(new MyTextFormatter());
		
		Handler consoleHandler = null;
		FileHandler  fileHandler  = null;

        consoleHandler = new ConsoleHandler();
		try {fileHandler  = new FileHandler("applog.log,htm",true);}
		catch   (SecurityException | IOException e) {
			 e.printStackTrace();
		 }
		logIn.addHandler(fileHandler);
		
		consoleHandler.setFormatter(new LogFormatterText());
		fileHandler.setFormatter(new LogFormatterHtml());
		
		
		
		return logIn;
	}
	

	}
	

