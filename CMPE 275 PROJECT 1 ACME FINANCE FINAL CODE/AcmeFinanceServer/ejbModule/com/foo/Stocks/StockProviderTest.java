package com.foo.Stocks;

import static org.junit.Assert.*;

import java.util.List;
import java.util.ListIterator;

import org.junit.Test;

public class StockProviderTest {

	StockProvider s=new StockProvider();
	@Test
	public void testStockProvider() {
		 
	}

	@Test
	public void testGetStocks() {
		try{
		boolean check_method=false;
		List<Stocks> stocks=s.getStocks("AA");
		ListIterator i=stocks.listIterator();
		while(i.hasNext())
		{
			check_method=true;
			 
		}
		 
		assertEquals("Success",true,check_method);
		}
		catch(Exception e)
		{
			
		}

		
	}

	@Test
	public void testGetStocksByDateRange() 
	{
		try{
			boolean check_method=false;
			List<Stocks> stocks=s.getStocksByDateRange("A", "2008-03-11","2010-05-20" );
			ListIterator i=stocks.listIterator();
			while(i.hasNext())
			{
				check_method=true;
				 
			}
			 
			assertEquals("Success",true,check_method);
			}
			catch(Exception e)
			{
				
			}
		 
	}

	@Test
	public void testGetStocksByDate() 
	{
		try{
			boolean check_method=false;
			List<Stocks> stocks=s.getStocksByDate("2008-03-11");
			ListIterator i=stocks.listIterator();
			while(i.hasNext())
			{
				check_method=true;
				 
			}
			 
			assertEquals("Success",true,check_method);
			}
			catch(Exception e)
			{
				
			}
	}

	@Test
	public void testGetTopStocksByCap() {
		try{
			boolean check_method=false;
			List<Stocks> stocks=s.getTopStocksByCap("2008-03-11");
			ListIterator i=stocks.listIterator();
			while(i.hasNext())
			{
				check_method=true;
				 
			}
			 
			assertEquals("Success",true,check_method);
			}
			catch(Exception e)
			{
				
			}
		
		 
	}

}
