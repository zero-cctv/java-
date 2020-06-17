package as.test;

import java.io.*;
import java.net.*;
public class URL1
{
	public static void main(String args[])
	{
		try
	    {
	    	URL u1=new URL("http://mil.news.sohu.com/");
	    	System.out.println(u1.getProtocol());
	    	System.out.println(u1.getHost());
	    	System.out.println(u1.getPort());
	    	System.out.println(u1.getFile());
	    }
	    catch(MalformedURLException e)
	    {
		    System.out.println(e);
	    }
	    catch(IOException ee)
	    {
		    System.out.println(ee);
	    }
	    catch(Exception eee)
	    {
		    System.out.println(eee);
	    }    
	}
}