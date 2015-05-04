package com.java.lessons.l4.collections.lib;

//David - jak cist IFace

/* Do MainClass vlozit
FileOutputStream fout= new FileOutputStream("app_stdout.log");
FileOutputStream ferr= new FileOutputStream("app_stderr.log");
MultiOutputStream multiOut= new MultiOutputStream(System.out, fout);
MultiOutputStream multiErr= new MultiOutputStream(System.err, ferr);
PrintStream stdout= new PrintStream(multiOut);
PrintStream stderr= new PrintStream(multiErr);
System.setOut(stdout);
System.setErr(stderr);

https://docs.oracle.com/javase/7/docs/api/java/io/OutputStream.html

*/



import java.io.IOException;
import java.io.OutputStream;

public class MultiOutputStream extends OutputStream
{    // http://www.codeproject.com/Tips/315892/A-quick-and-easy-way-to-direct-Java-System-out-to
     // System.out.println("Holy Rusty Metal Batman! I can't believe this was so simple!");
     // System.err.println("God I hate you Robin.");
    
	OutputStream[] outputStreams;
	
	// DAVID co jsou tady ty tri tecky????
	
	public MultiOutputStream(OutputStream... outputStreams)
	{
		this.outputStreams= outputStreams; 
	}
	
	@Override
	public void write(int b) throws IOException
	{
		for (OutputStream out: outputStreams)
			out.write(b);			
	}
	
	@Override
	public void write(byte[] b) throws IOException
	{
		for (OutputStream out: outputStreams)
			out.write(b);
	}
 
	@Override
	public void write(byte[] b, int off, int len) throws IOException
	{
		for (OutputStream out: outputStreams)
			out.write(b, off, len);
	}
 
	@Override
	public void flush() throws IOException
	{
		for (OutputStream out: outputStreams)
			out.flush();
	}
 
	@Override
	public void close() throws IOException
	{
		for (OutputStream out: outputStreams)
			out.close();
	}
}
