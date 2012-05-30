package com.foo.Client;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Test;

public class StockProviderClientTest {
StockProviderClient s=new StockProviderClient();
	@Test
	public void testStockProviderClient() {
		 
	}

	@Test
	public void testGethistoricaldata() {
		try{
		s.gethistoricaldata("AA", "csv");
		Boolean check_file=false;
		File f = new File("C:\\275\\outputDir\\historyAA.csv");
		if (f.exists())
		{
			check_file= true;
			System.out.print(check_file);
		}
		//fail("Not yet implemented");
		assertEquals("Success",true,check_file);
		}
		catch(Exception e)
		{}
	}

	@Test
	public void testGetsnapshotdata() {
		try{
			s.getsnapshotdata("A","xml", "2008-03-11", "2010-05-20");
			Boolean check_file=false;
			File f1 = new File("C:\\275\\outputDir\\snapshot-A.xml");
			if (f1.exists())
			{
				check_file= true;
				System.out.print(check_file);
			}
			//fail("Not yet implemented");
			assertEquals("Success",true,check_file);
			}
			catch(Exception e)
			{}
		
	}

	@Test
	public void testGetrealtimedata() {
		try{
			s.getrealtimedata("2008-03-11", "xml");
			Boolean check_file=false;
			File f2 = new File("C:\\275\\outputDir\\realtime-2008-03-11.xml");
			if (f2.exists())
			{
				check_file= true;
				System.out.print(check_file);
			}
			//fail("Not yet implemented");
			assertEquals("Success",true,check_file);
			}
			catch(Exception e)
			{}
		
		 
	}

	@Test
	public void testGetanalyzedata() {
		try{
			s.getanalyzedata("2008-03-11", "xml");
			Boolean check_file=false;
			File f2 = new File("C:\\275\\outputDir\\analyze-2008-03-11.xml");
			if (f2.exists())
			{
				check_file= true;
				System.out.print(check_file);
			}
			//fail("Not yet implemented");
			assertEquals("Success",true,check_file);
			}
			catch(Exception e)
			{}
	}

	@Test
	public void testMain() {
		 
	}

}
