package com.foo.Client;

import java.io.*;

public class ToXml 
{
public void historyxml(DataOutputStream dos, String date, String symbol,long  cap, float low, float open, float high, float close)
{
	
String s=symbol;
	
	try 
	{
	//	File xmlFile;
	//	Writer output = null;
	//	xmlFile = new File(fpath);
		
	/*	
		if(!xmlFile.exists())
		{
			output = new BufferedWriter(new FileWriter(xmlFile));
			
			output.write("<symbol>"+symbol+"</symbol>\n");
			output.write("<cap>"+cap+"</cap>\n");
			output.write("<low>"+low+"</low>\n");
			output.write("<open>"+open+"</open>\n");
			output.write("<high>"+high+"</high>\n");
			output.write("<close>"+close+"</close>\n");
			
			
			 
			
		} 
		else
		{*/
			//FileWriter fw = new FileWriter(xmlFile,true);
			//fw.write("<symbol>"+symbol+"</symbol>\n");
			//fw.write("<cap>"+cap+"</cap>\n");
			//fw.write("<low>"+low+"</low>\n");
			//fw.write("<open>"+open+"</open>\n");
			//fw.write("<high>"+high+"</high>\n");
			//fw.write("<close>"+close+"</close>\n");
			
			
		dos.writeChars("<date d='"+date+"'>\n");
		dos.writeChars("<cap>"+cap+"</cap>\n");
		dos.writeChars("<low>"+low+"</low>\n");
		dos.writeChars("<open>"+open+"</open>\n");
		dos.writeChars("<high>"+high+"</high>\n");
		dos.writeChars("<close>"+close+"</close>\n");
		dos.writeChars("</date>\n");	
			//fw.close();
		//}
		
	}
		
	
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
	
public void snapshotxml(DataOutputStream dos, long  cap, float low, float open, float high, float close,String date)
{
	

	
	try 
	{
	//	dos.writeChars("<symbol>"+symbol+"</symbol>\n");
		dos.writeChars("<date d='>"+date+"'>\n");
		dos.writeChars("<cap>"+cap+"</cap>\n");
		dos.writeChars("<low>"+low+"</low>\n");
		dos.writeChars("<open>"+open+"</open>\n");
		dos.writeChars("<high>"+high+"</high>\n");
		dos.writeChars("<close>"+close+"</close>\n");
		dos.writeChars("</date>\n");	
		
		
	}
		
	
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 

public void realtimexml(DataOutputStream dos, String symbol,long  cap, float low, float open, float high, float close)
{
	
String s=symbol;
	
	try 
	{
	//	File xmlFile;
	//	Writer output = null;
	//	xmlFile = new File(fpath);
		
	/*	
		if(!xmlFile.exists())
		{
			output = new BufferedWriter(new FileWriter(xmlFile));
			
			output.write("<symbol>"+symbol+"</symbol>\n");
			output.write("<cap>"+cap+"</cap>\n");
			output.write("<low>"+low+"</low>\n");
			output.write("<open>"+open+"</open>\n");
			output.write("<high>"+high+"</high>\n");
			output.write("<close>"+close+"</close>\n");
			
			
			 
			
		} 
		else
		{*/
			//FileWriter fw = new FileWriter(xmlFile,true);
			//fw.write("<symbol>"+symbol+"</symbol>\n");
			//fw.write("<cap>"+cap+"</cap>\n");
			//fw.write("<low>"+low+"</low>\n");
			//fw.write("<open>"+open+"</open>\n");
			//fw.write("<high>"+high+"</high>\n");
			//fw.write("<close>"+close+"</close>\n");
			
			
		dos.writeChars("<symbol s='"+symbol+"'>\n");
		dos.writeChars("<cap>"+cap+"</cap>\n");
		dos.writeChars("<low>"+low+"</low>\n");
		dos.writeChars("<open>"+open+"</open>\n");
		dos.writeChars("<high>"+high+"</high>\n");
		dos.writeChars("<close>"+close+"</close>\n");
		dos.writeChars("</symbol>\n");	
			//fw.close();
		//}
		
	}
		
	
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 

public void analyzexml(DataOutputStream dos, String symbol,long  cap, float low, float open, float high, float close)
{
	
String s=symbol;
	
	try 
	{
	//	File xmlFile;
	//	Writer output = null;
	//	xmlFile = new File(fpath);
		
	/*	
		if(!xmlFile.exists())
		{
			output = new BufferedWriter(new FileWriter(xmlFile));
			
			output.write("<symbol>"+symbol+"</symbol>\n");
			output.write("<cap>"+cap+"</cap>\n");
			output.write("<low>"+low+"</low>\n");
			output.write("<open>"+open+"</open>\n");
			output.write("<high>"+high+"</high>\n");
			output.write("<close>"+close+"</close>\n");
			
			
			 
			
		} 
		else
		{*/
			//FileWriter fw = new FileWriter(xmlFile,true);
			//fw.write("<symbol>"+symbol+"</symbol>\n");
			//fw.write("<cap>"+cap+"</cap>\n");
			//fw.write("<low>"+low+"</low>\n");
			//fw.write("<open>"+open+"</open>\n");
			//fw.write("<high>"+high+"</high>\n");
			//fw.write("<close>"+close+"</close>\n");
			
			
		dos.writeChars("<symbol s='"+symbol+"'>\n");
		dos.writeChars("<cap>"+cap+"</cap>\n");
		dos.writeChars("<low>"+low+"</low>\n");
		dos.writeChars("<open>"+open+"</open>\n");
		dos.writeChars("<high>"+high+"</high>\n");
		dos.writeChars("<close>"+close+"</close>\n");
		dos.writeChars("</symbol>\n");	
			//fw.close();
		//}
		
	}
		
	
		catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	} 
	
	}
	 
	

	

	

