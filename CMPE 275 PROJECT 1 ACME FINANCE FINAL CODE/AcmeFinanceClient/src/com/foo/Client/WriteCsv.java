package com.foo.Client;
import java.io.*;

public class WriteCsv 
{
  
public void historycsv(String symbol,long cap,float low, float open, float high,float close )
{
		String filename=symbol;
		 
	 String vol=String.valueOf(cap);
	 String l=String.valueOf(low);
	 String o=String.valueOf(open);
	 String h=String.valueOf(high);
	 String c=String.valueOf(close);
	 
		  
		try 
	    {
		File csvFile;
		//Writer output=null;
			FileOutputStream fos; 
		    DataOutputStream dos;
		csvFile = new File("C:\\275\\outputDir\\history"+filename+".csv");
	    if(!csvFile.exists())
			{
	    	   fos = new FileOutputStream(csvFile);
	    	   dos=new DataOutputStream(fos);
	   	    dos.writeChars(filename+","+vol+","+l+","+o+","+h+","+c +"\n");
	  
	  
	     
	      
        } 
	    else{
	    	fos = new FileOutputStream(csvFile,true);
	    	 dos=new DataOutputStream(fos);
	    	 dos.writeChars(filename+","+vol+","+l+","+o+","+h+","+c+"\n");
	    }
	    }
	    catch (IOException e)
	    {
	      e.printStackTrace();
        }
}
  public void snapshotcsv(String symbol,long cap,float low, float open, float high,float close,String sdate,String edate )
  {
  		String filename=symbol;
  		 String vol=String.valueOf(cap);
  		 String l=String.valueOf(low);
  		 String o=String.valueOf(open);
  		 String h=String.valueOf(high);
  		 String c=String.valueOf(close);
  		try 
  	    {
  			File csvFile;
  			//Writer output=null;
  				FileOutputStream fos; 
  			    DataOutputStream dos;
  			csvFile = new File("C:\\275\\outputDir\\history"+filename+".csv");
  		    if(!csvFile.exists())
  				{
  		    	   fos = new FileOutputStream(csvFile);
  		    	   dos=new DataOutputStream(fos);
  		   	    dos.writeChars(filename+","+vol+","+l+","+o+","+h+","+c+","+sdate+","+edate+"\n");
  		  
  		  
  		     
  		      
  	        } 
  		    else{
  		    	fos = new FileOutputStream(csvFile,true);
  		    	 dos=new DataOutputStream(fos);
  		    	dos.writeChars(filename+","+vol+","+l+","+o+","+h+","+c+","+sdate+","+edate+"\n");
  		    }
  	    }
  	    catch (IOException e)
  	    {
  	      e.printStackTrace();
          }
  }
  public void analyzedcsv(String symbol,long cap,float low, float open, float high,float close,String sdate)
  {
  		String filename=sdate;
  		String ticker=symbol;
  		 String vol=String.valueOf(cap);
  		 String l=String.valueOf(low);
  		 String o=String.valueOf(open);
  		 String h=String.valueOf(high);
  		 String c=String.valueOf(close);
  		try 
  	    {
  			File csvFile;
  			//Writer output=null;
  				FileOutputStream fos; 
  			    DataOutputStream dos;
  			csvFile = new File("C:\\275\\outputDir\\analyzed"+filename+".csv");
  		    if(!csvFile.exists())
  				{
  		    	   fos = new FileOutputStream(csvFile);
  		    	   dos=new DataOutputStream(fos);
  		   	    dos.writeChars(ticker+","+vol+","+l+","+o+","+h+","+c+"\n");
  		  
  		  
  		     
  		      
  	        } 
  		    else{
  		    	fos = new FileOutputStream(csvFile,true);
  		    	 dos=new DataOutputStream(fos);
  		    	dos.writeChars(ticker+","+vol+","+l+","+o+","+h+","+c+"\n");
  		    }
  	    }
  	    catch (IOException e)
  	    {
  	      e.printStackTrace();
          }
  }

}
