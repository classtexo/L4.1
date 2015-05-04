package com.java.lessons.l4.collections.lib;

import java.util.Date;
import java.util.logging.Formatter;
import java.util.logging.Handler;
import java.util.logging.Level;
import java.util.logging.LogRecord;

public class LogFormatterHtml extends Formatter {
	  public String format(LogRecord rec) {
		    StringBuffer buf = new StringBuffer(1000);
		    if (rec.getLevel().intValue() >= Level.WARNING.intValue()) {
		      buf.append("<b>");
		      buf.append(rec.getLevel());
		      buf.append("</b>");
		    } else {
		      buf.append(rec.getLevel());
		    }
		    buf.append(' ');
		    buf.append(rec.getMillis());
		    buf.append(' ');
		    buf.append(formatMessage(rec));
		    buf.append('\n');
		    return buf.toString();
		  }

		  public String getHead(Handler h) {
		    return "<HTML><HEAD>" + (new Date()) + "</HEAD><BODY><PRE>\n";
		  }

		  public String getTail(Handler h) {
		    return "</PRE></BODY></HTML>\n";
		  }
		}