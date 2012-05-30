package com.foo.Client;
import java.io.*;
import java.util.List;
 
import java.util.Properties;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.rmi.PortableRemoteObject;

 

import com.foo.Stocks.StockProviderRemote;
import com.foo.Stocks.Stocks;
  
public class StockProviderClient {
		//private String host;
		static StockProviderRemote svr;
			 
		public StockProviderClient(){
			//host = host1;
		}
		
		public void gethistoricaldata(String ticker,String dataformat) {
			String m=ticker;
			System.out.println(m);
			String format=dataformat;
			System.out.println(format);
			String fpath = null;
			FileOutputStream fos = null; 
		    DataOutputStream dos = null;
			try {
				Properties properties = new Properties();
				properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
				Context ctx = new InitialContext(properties);
				Object ref = ctx.lookup("StockProvider/remote");
				svr = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
				List<Stocks> stocks = svr.getStocks(m);
				if(format.equalsIgnoreCase("xml"))
				{
					System.out.println("want xml file");
					File xmlFile;
					fpath = "C:\\275\\outputDir\\history-"+m+".xml";
					xmlFile = new File(fpath);
					fos = new FileOutputStream(xmlFile);
			    	dos=new DataOutputStream(fos);
					dos.writeChars("<?xml version=\'1.0\'>\n");
				    dos.writeChars("<Stock>\n");
				   	dos.writeChars("<symbol>"+m+"</symbol>\n");
					 System.out.println("In client historical data");

				}
				for (Stocks s : stocks)  
				{
					long sId=s.getSId();
					String symbol=s.getSymbol();
					float low=s.getLow();
					long cap=s.getCap();
					float open=s.getOpen();
					float close=s.getClose();
					float high=s.getHigh();
					String date=s.getDate();
					if(format.equalsIgnoreCase("xml"))
					{
						ToXml t=new ToXml();
						t.historyxml(dos, date, symbol, cap, low, open, high, close);
					} else if(format.equalsIgnoreCase("csv")) 
					{
						WriteCsv k=new WriteCsv();
						k.historycsv(symbol, cap, low, open, high, close);	
					} else if(format.equalsIgnoreCase("json"))
					{
						jsonparser j=new jsonparser();
						j.historyjson(symbol, cap, low, open, high, close);
					}
				}
				if(format.equalsIgnoreCase("xml")){
					dos.writeChars("</Stock>\n");
				}
				System.out.println("-----");
	 		} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		public void getsnapshotdata(String ticker,String dataformat,String startdate,String enddate) {
			String m=ticker;
			String format=dataformat;
			String sdate=startdate;
			String edate=enddate;
			String fpath = "";
			FileOutputStream fos = null; 
		    DataOutputStream dos = null;
			try {
				Properties properties = new Properties();
				properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
				Context ctx = new InitialContext(properties);
				Object ref = ctx.lookup("StockProvider/remote");
				svr = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
				System.out.println("getSTocksByDateRange: " + m + ", " + sdate + ", " + edate  );
				List<Stocks> stocks = svr.getStocksByDateRange(m,sdate,edate);
				if(format.equalsIgnoreCase("xml"))
				{
					System.out.println("want xml file");
					File xmlFile;
					fpath = "C:\\275\\outputDir\\snapshot-"+m+".xml";
					xmlFile = new File(fpath);
					fos = new FileOutputStream(xmlFile);
			    	dos=new DataOutputStream(fos);
					dos.writeChars("<?xml version=\'1.0\'>\n");
				    dos.writeChars("<Stock>\n");
				   	dos.writeChars("<symbol>"+m+"</symbol>\n");
				}
				for (Stocks s : stocks){
					 Long sId=s.getSId();
					 String date = s.getDate();
					 float low=s.getLow();
					 Long cap=s.getCap();
					 float open=s.getOpen();
					 float close=s.getClose();
					 float high=s.getHigh();
					 if(format.equalsIgnoreCase("xml"))
					 {
						ToXml t=new ToXml();
						t.snapshotxml(dos, cap, low, open, high, close,date);
					 }
					 else if(format.equalsIgnoreCase("csv")) 
						{
							WriteCsv k=new WriteCsv();
						k.snapshotcsv(m, cap, low, open, high, close,sdate,edate);	
						} else if(format.equalsIgnoreCase("json"))
						{
							jsonparser j=new jsonparser();
							j.snapshotjson(m, cap, low, open, high, close,sdate,edate);
						}
					}
					if(format.equalsIgnoreCase("xml"))
					{
						dos.writeChars("</Stock>\n");
					}
				
				System.out.println("-----");
	 		} catch (Exception e) {
	 			e.printStackTrace();
			}
		}
			
		public void getrealtimedata(String date, String dataformat){
			String format=dataformat;
			String sdate=date;
			String fpath = "";
			FileOutputStream fos = null; 
		    DataOutputStream dos = null;
			try {
				Properties properties = new Properties();
				properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
				Context ctx = new InitialContext(properties);
				Object ref = ctx.lookup("StockProvider/remote");
				svr = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
				System.out.println("getSTocksByDate: " + sdate  );
				List<Stocks> stocks = svr.getStocksByDate(sdate);
				if(format.equalsIgnoreCase("xml")){
					System.out.println("want xml file");
					File xmlFile;
					fpath = "C:\\275\\outputDir\\realtime-"+sdate+".xml";
					xmlFile = new File(fpath);
					fos = new FileOutputStream(xmlFile);
			    	dos=new DataOutputStream(fos);
					dos.writeChars("<?xml version=\'1.0\'>\n");
				    dos.writeChars("<Stock>\n");
				   	dos.writeChars("<date>"+sdate+"</date>\n");
				}
				for (Stocks s : stocks) {
					 Long sId=s.getSId();
					 String symbol=s.getSymbol();
					 float low=s.getLow();
					 Long cap=s.getCap();
					 float open=s.getOpen();
					 float close=s.getClose();
					 float high=s.getHigh();
					 if(format.equalsIgnoreCase("xml")){
						ToXml t=new ToXml();
						t.realtimexml(dos, symbol, cap, low, open, high, close);
					 } 
					 
				}
				System.out.println("-----");
	 		} catch (Exception e) {
	 			e.printStackTrace();
			}
		}
				
public void getanalyzedata(String date, String dataformat) 
		{
			String format=dataformat;
			String sdate=date;
			String fpath = "";
			FileOutputStream fos = null; 
		    DataOutputStream dos = null;
			try {
				Properties properties = new Properties();
				properties.put(Context.PROVIDER_URL, "jnp://localhost:1099");
				properties.put(Context.INITIAL_CONTEXT_FACTORY,"org.jnp.interfaces.NamingContextFactory");
				properties.put(Context.URL_PKG_PREFIXES,"org.jboss.naming:org.jnp.interfaces");
				Context ctx = new InitialContext(properties);
				Object ref = ctx.lookup("StockProvider/remote");
				svr = (StockProviderRemote) PortableRemoteObject.narrow(ref, StockProviderRemote.class);
				System.out.println("getTopStocksByCap: " + sdate  );
				List<Stocks> stocks = svr.getTopStocksByCap(sdate);
				if(format.equalsIgnoreCase("xml"))
				{
					System.out.println("want xml file");
					File xmlFile;
					fpath = "C:\\275\\outputDir\\analyze-"+sdate+".xml";
					xmlFile = new File(fpath);
				    fos = new FileOutputStream(xmlFile);
				    dos=new DataOutputStream(fos);
					dos.writeChars("<?xml version=\'1.0\'>\n");
				    dos.writeChars("<Stock>\n");
				   	dos.writeChars("<date>"+sdate+"</date>\n");
				   	for (Stocks s : stocks) 
				   	{
				   		Long sId=s.getSId();
				   		String symbol=s.getSymbol();
				   		float low=s.getLow();
				   		Long cap=s.getCap();
				   		float open=s.getOpen();
				   		float close=s.getClose();
				   		float high=s.getHigh();
				   		if(format.equalsIgnoreCase("xml")){
				   		ToXml t=new ToXml();
				   		t.analyzexml(dos, symbol, cap, low, open, high, close);
				   		}
				   		else if(format.equalsIgnoreCase("csv")) 
						{
							WriteCsv k=new WriteCsv();
						k.analyzedcsv(symbol, cap, low, open, high, close,sdate);	
						} else if(format.equalsIgnoreCase("json"))
						{
							jsonparser j=new jsonparser();
							j.analyzedjson(symbol, cap, low, open, high, close,sdate);
						}
					}
					if(format.equalsIgnoreCase("xml"))
					{
						dos.writeChars("</Stock>\n");
					}
					
				}
				System.out.println("-----");
	 			} 
			catch (Exception e) 
			{
				e.printStackTrace();
			}
		}

		
		/*public static void main(String[] args){
		 
			StockProviderClient s=new StockProviderClient();
			s.getrealtimedata("2008-03-11", "xml");
			s.gethistoricaldata("A", "xml");
			//s.getsnapshotdata("A","json", "2008-03-11", "2010-05-20");
			//s.getsnapshotdata("A","xml", "2008-03-11", "2010-05-20");
			s.getanalyzedata("2008-03-11", "xml");
			s.getsnapshotdata("A","csv", "20080311", "20100520");
		}*/
	}
		



