package com.java.lessons.l4.collections.lib;

import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class LogFormatterText extends Formatter {
	@Override
	public String format(LogRecord record) {
		StringBuffer sb = new StringBuffer();
		sb.append("Prefixn");
		sb.append(record.getMessage());
		sb.append("Suffixn");
		sb.append("n");
		return sb.toString();
	}
	
	@Override
    public String getHead(Handler h) {
    	
        return "HEADER =================================================\n" + super.getHead(h);
    }
 
	@Override
	public String getTail(Handler h) {
        return "TAIL  =================================================\n" + super.getTail(h);
    }
}
