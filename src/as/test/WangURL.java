package as.test;

import java.io.*;
import java.net.*;
public class WangURL
{
	public static void main(String args[])
	{
		try
	    {
	    	URL u1=new URL("http://www.baidu.com/");
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